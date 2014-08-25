package com.seg2505.exemple.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("ListeExpertise")
public class ListeExpertise extends ParseObject {
	
	public static String expertises = "expertises";
	
	public ListeExpertise() {	
	}
	
	public JSONArray getExpertises() {
		return getJSONArray(expertises);
	}
	
	public List<String> getExpertisesList() {
		ArrayList<String> liste = new ArrayList<String>();
		JSONArray array = getJSONArray(expertises);
		if (array != null) {
			for (int i = 0; i < array.length(); i++) {
				try {
					liste.add(array.getString(i));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		
		return liste;
	}
	
	public void setExpertises(JSONArray valeur) {
		put(expertises, valeur);
		saveInBackground();
	}
	
	public void addExpertise(String valeur) {
		JSONArray xps = getJSONArray(expertises);
		if (xps == null) {
			xps = new JSONArray();
		}
		if (!xps.toString().contains(valeur)) {
			xps.put(valeur);
			put(expertises, xps);
			saveInBackground();
		}
	}
	
	public void removeExpertise(String valeur) {
		JSONArray xps = getJSONArray(expertises);
		JSONArray xps2 = new JSONArray();
		if (xps != null) {
			for (int i = 0; i < xps.length(); i++) {
				try {
					String s = xps.getString(i);
					if (!s.equals(valeur)) {
						xps2.put(s);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			put(expertises, xps2);
			saveInBackground();
		}
	}
}
