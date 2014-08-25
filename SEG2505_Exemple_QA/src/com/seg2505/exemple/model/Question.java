package com.seg2505.exemple.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Question")
public class Question extends ParseObject {
	
	public static String texte = "texte";
	public static String expertise = "expertise";
	public static String isRepondue = "isRepondue";
	public static String utilisateur = "utilisateur";
	
	public Question() {	
	}
	
	public String getTexte() {
		return getString(texte);
	}
	
	public void setTexte(String valeur) {
		put(texte, valeur);
		saveInBackground();
	}
	
	public String getExpertise() {
		return getString(expertise);
	}
	
	public void setExpertise(String valeur) {
		put(expertise, valeur);
		saveInBackground();
	}
	
	public String getUtilisateur() {
		return getString(utilisateur);
	}
	
	public void setUtilisateur(String valeur) {
		put(utilisateur, valeur);
		saveInBackground();
	}
	
	public boolean isRepondue() {
		return getBoolean(isRepondue);
	}

	public void setRepondue(boolean valeur) {
		put(isRepondue, valeur);
		saveInBackground();
	}
	
	@Override
	public String toString() {
		return getTexte();
	}

}
