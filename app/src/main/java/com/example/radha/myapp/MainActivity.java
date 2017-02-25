package com.example.radha.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseManager manager=new DatabaseManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jainesh(View v){
        if(v.getId() == R.id.button){
            EditText a=(EditText)findViewById(R.id.TFusername);
            String str=a.getText().toString();
            EditText b=(EditText)findViewById(R.id.TFpassword);
            String pass=b.getText().toString();

            String password = manager.searchPass(str);
            if(pass.equals(password)){
                Intent i= new Intent(MainActivity.this,Display.class);
                i.putExtra("Username",str);
                startActivity(i);
               // i.putExtra("")
            }
            else{
                Toast temp= Toast.makeText(MainActivity.this , "username and password does not match",Toast.LENGTH_SHORT);
                temp.show();
            }

           /* Intent i= new Intent(MainActivity.this,Display.class);
            i.putExtra("Username",str);
            startActivity(i);*/
        }

        if(v.getId()== R.id.Bsignup){

            Intent i= new Intent(MainActivity.this,Signup.class);
            startActivity(i) ;
        }

    }
}

