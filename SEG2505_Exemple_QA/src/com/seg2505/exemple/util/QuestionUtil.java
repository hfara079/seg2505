package com.seg2505.exemple.util;

import java.util.ArrayList;
import java.util.List;

import com.parse.ParseException;
import com.parse.ParseQuery;
import com.seg2505.exemple.model.Question;
import com.seg2505.exemple.model.Reponse;

public class QuestionUtil {
	
	public static List<Question> getQuestionsPourExpertise(String expertise) {
		List<Question> listeQuestions = new ArrayList<Question>();
		
		if (expertise != null
				&& !expertise.isEmpty()) {
			ParseQuery<Question> query = new ParseQuery<Question>("Question");
			query.whereEqualTo(Question.expertise, expertise);
			try {
				listeQuestions = query.find();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		 
		return listeQuestions;
	}
	
	public static List<Question> getQuestionsPourUtilisateur(String userName) {
		List<Question> listeQuestions = new ArrayList<Question>();
		
		if (userName != null
				&& !userName.isEmpty()) {
			ParseQuery<Question> query = new ParseQuery<Question>("Question");
			query.whereEqualTo(Question.utilisateur, userName);
			try {
				listeQuestions = query.find();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		 
		return listeQuestions;
	}
	
	public static Reponse getReponsePourQuestion(Question question) {
		List<Reponse> listeReponses = new ArrayList<Reponse>();
		
		if (question != null) {
			ParseQuery<Reponse> query = new ParseQuery<Reponse>("Reponse");
			query.whereEqualTo(Reponse.question, question.getObjectId());
			try {
				listeReponses = query.find();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		 
		if (listeReponses.size() > 0) {
			return listeReponses.get(0);
		}
		return null;
	}

}
