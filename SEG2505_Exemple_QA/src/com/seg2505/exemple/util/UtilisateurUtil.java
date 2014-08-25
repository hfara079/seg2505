package com.seg2505.exemple.util;

import com.parse.ParseUser;

public class UtilisateurUtil {
	
	public static String isExpert = "isExpert";
	public static String expertise = "expertise";
	public static String EMPTY = "";
	
	public static boolean isExpert() {
		ParseUser user = ParseUser.getCurrentUser();
		if (user != null) {
			return user.getBoolean(isExpert);
		}
		return false;
	}
	
	public static void setExpert(boolean valeur) {
		ParseUser user = ParseUser.getCurrentUser();
		if (user != null) {
			user.put(isExpert, valeur);
			user.saveInBackground();
		}
	}
	
	public static String getExpertise() {
		ParseUser user = ParseUser.getCurrentUser();
		if (user != null) {
			return user.getString(expertise);
		}
		return null;
	}
	
	public static void setExpertise(String valeur) {
		ParseUser user = ParseUser.getCurrentUser();
		if (user != null) {
			user.put(expertise, valeur);
			user.saveInBackground();
		}
	}
	
	public static String getUsername() {
		ParseUser user = ParseUser.getCurrentUser();
		if (user != null) {
			return user.getUsername();
		}
		return EMPTY;
	}
}
