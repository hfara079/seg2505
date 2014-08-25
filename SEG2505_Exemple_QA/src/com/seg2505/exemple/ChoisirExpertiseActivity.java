package com.seg2505.exemple;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.seg2505.exemple.model.ListeExpertise;
import com.seg2505.exemple.util.UtilisateurUtil;

public class ChoisirExpertiseActivity extends Activity {
	
	private Spinner spinnerChoixExpertise = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choisir_expertise);
		
		spinnerChoixExpertise = (Spinner)findViewById(R.id.spinnerChoixExpertise);
		updateUI();
	}
	
	private void updateUI() {
		// chercher les expertise de parse
		// faire un parse query pour obtenir la liste d'expertise la plus recente
		ParseQuery<ListeExpertise> query = new ParseQuery<ListeExpertise>("ListeExpertise");
		query.findInBackground(new FindCallback<ListeExpertise>() {
		    public void done(List<ListeExpertise> expertiseListe, ParseException e) {
		        if (e == null) {
		            if (expertiseListe.size() > 0) {
		            	// there should be one expertise list
		            	ListeExpertise el = expertiseListe.get(0);
		            	List<String> expertises = el.getExpertisesList();
		            	ArrayAdapter<String> adapter = new ArrayAdapter<String>(ChoisirExpertiseActivity.this,
		            			android.R.layout.simple_spinner_item, expertises);
		            	spinnerChoixExpertise.setAdapter(adapter);
		            	
		            	// chercher l'expertise de l'utilisateur
		        		String expertise = UtilisateurUtil.getExpertise();
		        		if (expertise != null) {
		        			int index = expertises.indexOf(expertise);
		        			spinnerChoixExpertise.setSelection(index);
		        		}
		            }
		        }
		    }
		});
	}
	
	public void onMisAJour(View view) {
		updateUI();
	}
	
	public void onAjouterExpertise(View view) {
		// faire un parse query pour obtenir la liste d'expertise la plus recente
		ParseQuery<ListeExpertise> query = new ParseQuery<ListeExpertise>("ListeExpertise");
		query.findInBackground(new FindCallback<ListeExpertise>() {
		    public void done(List<ListeExpertise> expertiseListe, ParseException e) {
		        if (e == null) {
		        	EditText ed = (EditText)findViewById(R.id.editTextNouvelleCategorie);
		        	String cat = ed.getText().toString();
		        	// there should be one expertise list
	            	ListeExpertise el = expertiseListe.get(0);
	            	el.addExpertise(cat);
		        }
		    }
		});
	}

	public void onOk(View view) {
		String cat = (String)spinnerChoixExpertise.getSelectedItem();
		if (cat != null) {
			UtilisateurUtil.setExpertise(cat);
		}
		finish();
	}
	
	public void onCancel(View view) {
		finish();
	}
}
