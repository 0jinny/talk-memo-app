package com.lab01.jinny.talkmemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView memoListView = (ListView)findViewById(R.id.memo_listview);//메모 목록

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select memo_nm, orgl_dttm from tkmm00tb", null);

        ArrayList<MemoVO> datas = new ArrayList<>();
        while(cursor.moveToNext()){
            MemoVO vo = new MemoVO();
            vo.title = cursor.getString(0);
            vo.date = cursor.getString(1);
            datas.add(vo);
        }

        MemoVO vo = new MemoVO();
        vo.title = "뉴욕 여행 준비";
        vo.date = "2018.02.01 21:10";
        datas.add(vo);

        vo = new MemoVO();
        vo.title = "C O S M E T I C S";
        vo.date = "2018.04.15 23:39";
        datas.add(vo);

        memoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MemoDetailActivity.class);
                startActivity(intent);
            }
        });

        db.close();

        MemoAdapter adapter = new MemoAdapter(this, R.layout.item_memo, datas);
        memoListView.setAdapter(adapter);
    }



}
