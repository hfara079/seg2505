package com.seg2505.exemple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.ParseUser;
import com.parse.ui.ParseLoginBuilder;


public class MainActivity extends ActionBarActivity {
	
	private int loginRequestCode = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
    	super.onActivityResult(arg0, arg1, arg2);
    	
    	if (arg0 == loginRequestCode
    			&& arg1 == RESULT_OK) {
    		// succes du login
    		enableUI(true);
    		findViewById(R.id.buttonLogin).setEnabled(false);
    	}
    }
    
    private void enableUI(boolean b) {
    	findViewById(R.id.buttonChoisirExpertises).setEnabled(b);
    	findViewById(R.id.buttonPoserQuestion).setEnabled(b);
		findViewById(R.id.buttonRepondreQuestion).setEnabled(b);
		findViewById(R.id.buttonLireEvaluerReponse).setEnabled(b);
	}

	public void onLogin(View view) {
    	ParseLoginBuilder builder = new ParseLoginBuilder(MainActivity.this);
    	startActivityForResult(builder.build(), loginRequestCode);
	}
	
	public void onChoisirExpertises(View view) {
		Intent intent = new Intent(this, ChoisirExpertiseActivity.class);
		startActivity(intent);
	}
	
    public void onPoserQuestion(View view) {
    	Intent intent = new Intent(this, PoserQuestionActivity.class);
		startActivity(intent);
	}
	
	public void onRepondreQuestion(View view) {
		Intent intent = new Intent(this, RepondreQuestionActivity.class);
		startActivity(intent);
	}
	
	public void OnLireEvaluerReponse(View view) {
		Intent intent = new Intent(this, LireEvaluerReponseActivity.class);
		startActivity(intent);
	}
}
