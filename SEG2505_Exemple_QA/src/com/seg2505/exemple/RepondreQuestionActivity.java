package com.seg2505.exemple;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.seg2505.exemple.model.Question;
import com.seg2505.exemple.model.Reponse;
import com.seg2505.exemple.util.QuestionUtil;
import com.seg2505.exemple.util.UtilisateurUtil;

public class RepondreQuestionActivity extends Activity {

	private Spinner spinnerChoixQuestion = null;
	private EditText edReponse = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_repondre_question);
		
		spinnerChoixQuestion = (Spinner)findViewById(R.id.spinnerRepondreQuestion);
		edReponse = (EditText)findViewById(R.id.editTextReponse);
		
		updateUI();
	}
	
	private void updateUI() {
		List<Question> questions = QuestionUtil.getQuestionsPourExpertise(UtilisateurUtil.getExpertise());
		ArrayAdapter<Question> adapter = new ArrayAdapter<Question>(RepondreQuestionActivity.this,
    			android.R.layout.simple_spinner_item, questions);
    	spinnerChoixQuestion.setAdapter(adapter);
	}
	
	public void onMisAJourQuestions(View view) {
		updateUI();
	}
	
	public void onOk(View view) {
		Question question = (Question)spinnerChoixQuestion.getSelectedItem();
		if (question != null) {
			Reponse reponse = new Reponse();
			reponse.setQuestion(question.getObjectId());
			reponse.setTexte(edReponse.getText().toString());
			reponse.setExpert(UtilisateurUtil.getUsername());
			reponse.saveInBackground();
		}
		finish();
	}
	
	public void onCancel(View view) {
		finish();
	}
}
