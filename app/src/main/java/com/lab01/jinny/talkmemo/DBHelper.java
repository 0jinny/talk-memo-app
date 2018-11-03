package com.lab01.jinny.talkmemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_CREATE_TABLE_TKMM00TB = "create table tkmm00tb " +
                                                            "(obj_id integer primary key autoincrement,"+
                                                            "memo_nm text," +
                                                            "orgl_dttm datetime," +
                                                            "updt_dttm datetime," +
                                                            "xpr_dttm datetime default \"9999-12-31\")";
    public static final String DATABASE_CREATE_TABLE_TKMM01TB = "create table tkmm01tb " +
                                                            "(obj_id integer primary key autoincrement,"+
                                                            "of_memo integer," +
                                                            "contents text," +
                                                            "orgl_dttm datetime," +
                                                            "updt_dttm datetime," +
                                                            "xpr_dttm datetime default \"9999-12-31\")";

    public DBHelper(Context context) {
        super(context, "talkmemo", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_TABLE_TKMM00TB);//TKMM00TB 테이블 생성
        db.execSQL(DATABASE_CREATE_TABLE_TKMM01TB);//TKMM01TB 테이블 생성
    }//앱 설치 후 SQLiteOpenHelper가 최초로 이용되는 순간 한 번 호출

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        if(newVer==DATABASE_VERSION){
            db.execSQL("drop table tkmm01tb");
            onCreate(db);
        }
    }
}
