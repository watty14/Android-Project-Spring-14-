/**
 * the register form page
 */
package com.example.wallt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
 
public class RegisterActivity extends Activity {
	
	private DataBaseManager db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.register_activity);
        db = new DataBaseManager(this);
        
        TextView registerAccount = (TextView) findViewById(R.id.create);
        
        final TextView userName = (TextView) findViewById(R.id.userNameField);
        final TextView passWord = (TextView) findViewById(R.id.passwordField);
        
        registerAccount.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
            	db.addRow(userName.getText().toString(), passWord.getText().toString());
	            Intent i = new Intent(getApplicationContext(), RegistrationFeed.class);
	          	startActivity(i);
            }
        });
 
        TextView back = (TextView) findViewById(R.id.backToMain);
 
        back.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // Switching back to login screen
                finish();
            }
        });
    }
}