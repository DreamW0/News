package com.haobi.News;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DataBaseHelper extends SQLiteOpenHelper {
    static String name="uuu.db";
    static int dbVersion=1;

    private DataBaseHelper dataBaseHelper;
    public DataBaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }
    //只在创建的时候用一次
    public void onCreate(SQLiteDatabase db) {
        String sql="create table userinfo(id integer primary key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2))";
        db.execSQL(sql);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


        public void regist(String username,String password){
        SQLiteDatabase db;
            db=getReadableDatabase();
            db.execSQL("INSERT INTO user (username,password) VALUES(?,?)",new Object[]{username,password});
        }

        public int login(){
            int data=0;
            SQLiteDatabase db;

            db=getReadableDatabase();
            Cursor cursor =db.query("userinfo",null,null,null,null,null,"username DESC");
            if(cursor.getCount()==0){
                data=1;
            }
            return data;
        }

}
