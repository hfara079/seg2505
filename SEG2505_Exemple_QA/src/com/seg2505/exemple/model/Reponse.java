package com.seg2505.exemple.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Reponse")
public class Reponse extends ParseObject {
	
	public static String texte = "texte";
	public static String evaluation = "evaluation";
	public static String question = "question";
	public static String expert = "expert";
	
	public Reponse() {	
	}
	
	public String getTexte() {
		return getString(texte);
	}
	
	public void setTexte(String valeur) {
		put(texte, valeur);
		saveInBackground();
	}
	
	public String getEvaluation() {
		return getString(evaluation);
	}
	
	public void setEvaluation(String valeur) {
		put(evaluation, valeur);
		saveInBackground();
	}

	public String getQuestion() {
		return getString(question);
	}
	
	public void setQuestion(String valeur) {
		put(question, valeur);
		saveInBackground();
	}
	
	public String getExpert() {
		return getString(expert);
	}
	
	public void setExpert(String valeur) {
		put(expert, valeur);
		saveInBackground();
	}
}
