package com.seg2505.exemple;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.seg2505.exemple.model.Question;
import com.seg2505.exemple.model.Reponse;
import com.seg2505.exemple.util.QuestionUtil;
import com.seg2505.exemple.util.UtilisateurUtil;

public class LireEvaluerReponseActivity extends Activity {

	private Spinner spinnerChoixQuestion = null;
	private TextView textViewReponse = null;
	private EditText edEvaluation = null;
	private Reponse reponse = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lire_evaluer_reponse);
		
		spinnerChoixQuestion = (Spinner)findViewById(R.id.spinnerQuestionsAvecReponses);
		textViewReponse = (TextView)findViewById(R.id.textViewReponse);
		edEvaluation = (EditText)findViewById(R.id.editTextEvaluation);
		
		updateUI();
	}
	
	private void updateUI() {
		List<Question> questions = QuestionUtil.getQuestionsPourUtilisateur(UtilisateurUtil.getUsername());
		ArrayAdapter<Question> adapter = new ArrayAdapter<Question>(LireEvaluerReponseActivity.this,
    			android.R.layout.simple_spinner_item, questions);
    	spinnerChoixQuestion.setAdapter(adapter);
	}
	
	public void onVoirReponse(View view) {
		Question question = (Question)spinnerChoixQuestion.getSelectedItem();
		if (question != null) {
			reponse = QuestionUtil.getReponsePourQuestion(question);
			if (reponse != null) {
				textViewReponse.setText(reponse.getTexte());
			}
		}
	}
	
	public void onOk(View view) {
		String eval = edEvaluation.getText().toString();
		if (reponse != null) {
			reponse.setEvaluation(eval);
			reponse.saveInBackground();
		}
		
		finish();
	}
	
	public void onCancel(View view) {
		finish();
	}
}
