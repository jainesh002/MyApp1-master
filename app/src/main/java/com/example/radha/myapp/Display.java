package com.example.radha.myapp;

/**
 * Created by radha on 2/23/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by radha on 2/13/2017.
 */

public class Display extends Activity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username= getIntent().getStringExtra("Username");

        TextView tv=(TextView)findViewById(R.id.TVusername);
        tv.setText(username);

        Information i= new Information();
        SQLiteDatabase db;

        DatabaseManager databaseManager=new DatabaseManager(context);
        Cursor cursor=databaseManager.getInformation(i);
        cursor.moveToFirst();
        String name="";

        if(username.equals(cursor.getString(2))){
            name=cursor.getString(1);
            Toast.makeText(Display.this , "Success" ,Toast.LENGTH_SHORT).show();
        }
        TextView tname=(TextView)findViewById((R.id.TVname));
        tname.setText(name);
    }




}