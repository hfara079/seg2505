package com.seg2505.exemple;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.seg2505.exemple.model.ListeExpertise;
import com.seg2505.exemple.model.Question;
import com.seg2505.exemple.util.UtilisateurUtil;

public class PoserQuestionActivity extends Activity {
	
	private Spinner spinnerChoixExpertise = null;
	EditText edQuestion = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poser_question);
		
		spinnerChoixExpertise = (Spinner)findViewById(R.id.spinnerExpertiseRequise);
		edQuestion = (EditText)findViewById(R.id.editTextQuestion);
		
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
		            	ArrayAdapter<String> adapter = new ArrayAdapter<String>(PoserQuestionActivity.this,
		            			android.R.layout.simple_spinner_item, expertises);
		            	spinnerChoixExpertise.setAdapter(adapter);
		            }
		        }
		    }
		});
	}
	
	public void onOk(View view) {
		Question question = new Question();
		question.setTexte(edQuestion.getText().toString());
		question.setExpertise((String)spinnerChoixExpertise.getSelectedItem());
		question.setUtilisateur(UtilisateurUtil.getUsername());
		question.saveInBackground();
		
		finish();
	}
	
	public void onCancel(View view) {
		finish();
	}
}
