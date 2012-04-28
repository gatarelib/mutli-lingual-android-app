package com.gaprogman.transaltiontest;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TranslationTestActivity extends Activity implements OnClickListener {
private String logtag = getClass().getSimpleName();
    
    private TextView textViewEnglish;
    private TextView textViewJapanese;
    private Button buttonPress;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        textViewEnglish = (TextView) findViewById(R.id.textViewEnglish);
        textViewJapanese = (TextView) findViewById(R.id.textViewJapanese);
        
        textViewEnglish.setText(getString(R.string.welcomeString));
        
        buttonPress = (Button) findViewById(R.id.button1);
        buttonPress.setText(getString(R.string.initButton));
        buttonPress.setOnClickListener(this);
        
        Locale locale = Locale.getDefault(); // current locale
        // Locale locale = getResources().getConfiguration().locale; // or you can ...
        Log.d(logtag, "lang = " + locale.getLanguage());
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
        	if(buttonPress.getText() == getString(R.string.initButton))
        	{
        		if (textViewEnglish.getText() == getString(R.string.hello)) {
        			textViewJapanese.setText(getString(R.string.goodbyeja));
        			textViewEnglish.setText(getString(R.string.goodbye));// set localized text
        		}
        		else{
        			textViewJapanese.setText(getString(R.string.helloja));
        			textViewEnglish.setText(getString(R.string.hello));
        		}
        	}
        }
    }
}