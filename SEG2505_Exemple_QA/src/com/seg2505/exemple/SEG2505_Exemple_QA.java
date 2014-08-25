package com.seg2505.exemple;

import java.util.List;

import android.app.Application;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.seg2505.exemple.model.ListeExpertise;
import com.seg2505.exemple.model.Question;
import com.seg2505.exemple.model.Reponse;

public class SEG2505_Exemple_QA extends Application {
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		ParseObject.registerSubclass(Question.class);
		ParseObject.registerSubclass(Reponse.class);
		ParseObject.registerSubclass(ListeExpertise.class);
		
		Parse.initialize(this, "448LCfDpX4KQW2j6HHbpXbhOBLiRHm2eqCrEjHWD", 
				"d4x4A5SJVyWYyznzqlOj6Q8MXnGdD2W6K3HkrfHl");
		
		ParseACL defaultACL = new ParseACL();
		defaultACL.setPublicReadAccess(true);
		ParseACL.setDefaultACL(defaultACL, true);
		
		// creer la liste d'expertises 
		ParseQuery<ListeExpertise> query = new ParseQuery<ListeExpertise>("ListeExpertise");
		query.findInBackground(new FindCallback<ListeExpertise>() {
		    public void done(List<ListeExpertise> expertiseListe, ParseException e) {
		        if (e == null) {
		        	if (expertiseListe.size() == 0) {
		        		ListeExpertise listeExp = new ListeExpertise();
		        		listeExp.saveInBackground();
		        	}
		        }
		    }
		});
	}

}
