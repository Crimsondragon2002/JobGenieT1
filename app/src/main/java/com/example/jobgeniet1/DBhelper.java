package com.example.jobgeniet1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Locale;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Customers.db";

    public DBhelper(Context context) {
        super(context, DBNAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase Dat) {
        Dat.execSQL("create Table customers(name TEXT primary key, age INTEGER, skills TEXT,salary INTEGER, international TEXT,userType INTEGER)");
        Dat.execSQL("create Table security(username TEXT primary key, password TEXT, userType INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Dat, int i, int i1) {
        Dat.execSQL("drop Table if exists customers");
    }

    public Boolean insertData(String name, int age, String skills, int salary, String international, int userType) {
        SQLiteDatabase Dat = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("name", name);
        content.put("age", age);
        content.put("skills", skills);
        content.put("salary", salary);
        content.put("international", international);
        content.put("userType", userType);
        long result = Dat.insert("customers", null, content);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean insertSecurity(String username, String password, int userType) {
        SQLiteDatabase Dat = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("username", username);
        content.put("password", password);
        long result = Dat.insert("security", null, content);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean checkUser(String username){
        SQLiteDatabase Dat = this.getReadableDatabase();
        Cursor cursor = Dat.rawQuery("Select * from security where username = ?", new String[]{username});
        if(cursor.getCount()>0){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkPassword(String password){
        SQLiteDatabase Dat = this.getReadableDatabase();
        Log.i("query","query password is "+password);
        Cursor cursor = Dat.rawQuery("Select * from security where password = ?", new String[]{password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkUsernameAndPassword(String username, String password){
        SQLiteDatabase Dat = this.getReadableDatabase();
        Cursor cursor = Dat.rawQuery("Select * from security where username = ? and password = ?", new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkUserType(String username){
        SQLiteDatabase Dat = this.getReadableDatabase();
        Cursor cursor = Dat.rawQuery("Select * from security where username = ? and userType = 0", new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

}