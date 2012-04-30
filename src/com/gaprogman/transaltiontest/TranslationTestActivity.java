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
    
    //object references
    /* TextView object found about the button object.
     * Used in English locales to store English text,
     * but used in Japanese locale to store Japanese
     * text
     */
    private TextView textViewEnglish;
    
    /* TextView object found under the button object.
     * Used in Japanese locales to store Japanese text,
     * but used in English locale to store English
     * text
     */
    private TextView textViewJapanese;
    
    /* Button object found between the two TextView
     * objects.
     * Used to change the text on both the TextView
     * objects  at the same time. It flips between
     * phrases, encoded as strings, that are found
     * in the strings.xml file
     */
    private Button buttonPress;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        //set the values of the TextView objects to those found
        //in the relevant strings.xml file (strings.xml for English
        //locals and strings-ja.xml for Japanese locals)
        textViewEnglish = (TextView) findViewById(R.id.textViewEnglish);
        textViewJapanese = (TextView) findViewById(R.id.textViewJapanese);
        
        //set the text of the TextView object found at the top of
        //the UI (above the Button object), to the welcome message
        //encoded as a string in the relevant strings.xml file
        textViewEnglish.setText(getString(R.string.welcomeString));
        
        //instantiate the reference to the Button object before
        //we set it's other properties (text value and listener
        //method)
        buttonPress = (Button) findViewById(R.id.button1);
        
        //set the text of the Button object (sandwiched between the
        //two TextView objects) to the encoded button label, found
        //in the relevant strings.xml file
        buttonPress.setText(getString(R.string.initButton));
        
        //tell the button object which listener method to use when
        //the user clicks (or presses) it
        buttonPress.setOnClickListener(this);
        
        //get the device's current locale information. This is used
        //by the Android system to load the correct strings.xml file
        //when needed
        Locale locale = Locale.getDefault(); // current locale
        Log.d(logtag, "lang = " + locale.getLanguage());
    }

    public void onClick(View v) {
        //if the button that has been pressed as the id value of button1
        //i.e "is this the object buttonPress?"
        if (v.getId() == R.id.button1) {
            //if the text value for this button is set to the value used
            //as a prompt for the user to press it
            //i.e. (in English locales) "does the button read 'Please
            //press me'?"
        	if(buttonPress.getText() == getString(R.string.initButton))
        	{
                //if the text value of TextViewEnglish (the TextView above
                //the Button object) is set to the value of the hello message,
                //then change the text  values of both of the TextViews to
                //the goodbye value (all are found in the relevant strings.xml
                //file)
        		if (textViewEnglish.getText() == getString(R.string.hello)) {
        			textViewJapanese.setText(getString(R.string.goodbyeja));
        			textViewEnglish.setText(getString(R.string.goodbye));
        		}
                //otherwise, set the values of both of the TextView's to
                //the hello values (found in the relevant strings.xml file)
        		else{
        			textViewJapanese.setText(getString(R.string.helloja));
        			textViewEnglish.setText(getString(R.string.hello));
        		}
        	}
        }
    }
}