package com.example.radha.myapp;

/**
 * Created by radha on 2/23/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by radha on 2/22/2017.
 */

public class DatabaseManager extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "information.db";
    private static final String TABLE_NAME = "information";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    private static final String COLUMN_ORDERINFO = "orderinfo";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_FAV="fav";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table information ( id integer primary key not null , " +
            "name text not null , email text not null , uname text not null , pass text not null, orderinfo text not null,location text not null, fav text not null );";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;

    }

    public void insertContact(Information i){
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        String query= "select * from information";
        Cursor cursor=db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, i.getName());
        values.put(COLUMN_EMAIL, i.getEmail());
        values.put(COLUMN_UNAME, i.getUname());
        values.put(COLUMN_PASS, i.getPass());

        db.insert(TABLE_NAME, null , values);
        db.close();
    }
    public Cursor getInformation(Information i){
        db=this.getReadableDatabase();
        String columns[]={COLUMN_NAME,COLUMN_EMAIL,COLUMN_UNAME,COLUMN_FAV,COLUMN_LOCATION};
        Cursor cursor= db.query(TABLE_NAME,columns,null,null,null,null,null);
        return cursor;
    }

    public String searchPass(String uname){
        db = this.getReadableDatabase();
        String query= "select uname , pass from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b = "not found";

        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query= "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
