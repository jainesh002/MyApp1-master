package com.example.radha.myapp;

/**
 * Created by radha on 2/23/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class Signup extends Activity {

    DatabaseManager manager = new DatabaseManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void SignUpClick(View v){
        if(v.getId() == R.id.Bsignupbutton){
            EditText name= (EditText)findViewById(R.id.TFname);
            EditText email= (EditText)findViewById(R.id.TFemail);
            EditText uname= (EditText)findViewById(R.id.TFuname);
            EditText pass1= (EditText)findViewById(R.id.TFpass1);
            EditText pass2= (EditText)findViewById(R.id.TFpass2);

            String namestr= name.getText().toString();
            String emailstr= email.getText().toString();
            String unamestr= uname.getText().toString();
            String pass1str= pass1.getText().toString();
            String pass2str= pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                //error
                Toast pass= Toast.makeText(Signup.this , "password does not match" ,Toast.LENGTH_SHORT);
                pass.show();
            }
            else{
                //add information into database
                Information i = new Information();
                i.setName(namestr);
                i.setEmail(emailstr);
                i.setUname(unamestr);
                i.setPass(pass1str);

                manager.insertContact(i);
                Intent c= new Intent(Signup.this,MainActivity.class);
                startActivity(c);
            }
        }
    }

}

