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
    public static final String CustomerTABLE_NAME ="customers";
    public static final String LISTTABLE_NAME ="list";
    public DBhelper(Context context) {
        super(context, DBNAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase Dat) {
        String createTableCustomer = "create TABLE "+CustomerTABLE_NAME + "(" +"name TEXT primary key, "+"skills TEXT, "+"international TEXT, salary INTEGER, userType INTEGER)";
        Dat.execSQL(createTableCustomer);
        Dat.execSQL("create Table security(username TEXT primary key, password TEXT, userType INTEGER)");
        String createTableList = "create TABLE " + LISTTABLE_NAME +"("+"name TEXT primary key, " + "skills TEXT, " + "international TEXT, salary INTEGER)";
        Dat.execSQL(createTableList);
    }

    @Override
    public void onUpgrade(SQLiteDatabase Dat, int i, int i1) {
        Dat.execSQL("drop Table if exists customers");
    }

    public Boolean insertData(String name, String skills, int salary, String international, int userType) {
        SQLiteDatabase Dat = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("name", name);
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
    public Boolean updateData(String oldName,String name, String skills, int salary, String international, int userType){
        SQLiteDatabase Dat = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("skills",skills);
        contentValues.put("salary",salary);
        contentValues.put("international",international);
        contentValues.put("userType",userType);
        Dat.update("customers",contentValues,"name =?",new String[]{oldName});
        return true;
    }
    public Boolean updateSecurity(String oldUsername, String username, String password, int userType){
        SQLiteDatabase Dat = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("username", username);
        content.put("password", password);
        Dat.update("security",content,"username=?",new String[]{oldUsername});
        return true;
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
    public boolean checkName(String name){
        SQLiteDatabase Dat = this.getReadableDatabase();
        Cursor cursor = Dat.rawQuery("Select * from customers where name = ?", new String[]{name});
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

    public String[] getRows(int v) {
        String[] rows = new String[500];
        SQLiteDatabase Dat = this.getReadableDatabase();
        Cursor cursor = Dat.rawQuery("SELECT * FROM " + CustomerTABLE_NAME, null);
        if (cursor != null && cursor.moveToFirst()) {
            int i = 0;
            do {
                rows[i] = cursor.getString(v);
                i++;
            } while (cursor.moveToNext());
        }
        return rows;

    }

    public String[] getListRows(int v){
        String[] rows = new String[500];
        SQLiteDatabase Dat = this.getReadableDatabase();
        Cursor cursor = Dat.rawQuery("SELECT * FROM " + LISTTABLE_NAME, null);
        if (cursor != null && cursor.moveToFirst()) {
            int i = 0;
            do {
                rows[i] = cursor.getString(v);
                i++;
            } while (cursor.moveToNext());
        }
        return rows;

    }
    public boolean insertList(String name, String skills, String international, int salary) {
        SQLiteDatabase Dat = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("name", name);
        content.put("skills", skills);
        content.put("international",international);
        content.put("salary",salary);
        long result = Dat.insert("list", null, content);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public  Cursor getList(){
        SQLiteDatabase Dat = this.getWritableDatabase();
        Cursor cursor = Dat.rawQuery("Select * from list",null);
        return cursor;
    }
    public void deleteTableF(String tablename) {

        String selectQuery = "DELETE FROM " + tablename;

        SQLiteDatabase db= this.getWritableDatabase();

        db.execSQL(selectQuery);
    }
    public Integer deleteTableS(String tablename,String searcher){
        SQLiteDatabase Dat = this.getWritableDatabase();
        if(tablename.equals("customers")) {
            return Dat.delete(tablename, "name = ?",new String[]{searcher});
        }
        else{
           return Dat.delete(tablename,"username = ?",new String[]{searcher});
        }

    }
}