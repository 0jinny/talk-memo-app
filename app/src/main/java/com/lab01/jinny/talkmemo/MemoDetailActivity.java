package com.lab01.jinny.talkmemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MemoDetailActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        CompoundButton.OnClickListener {

    ListView memoListView;
    EditText memoEditText;
    Button addBtn;
    Button addMemoBtn;

    ArrayList<HashMap<String, String>> memoList;

    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_detail);
    }

    @Override
    public void onClick(View view) {
        if(view==addBtn){
            int obj_id = 1;
            String contents = memoEditText.getText().toString();

            if(!contents.isEmpty()){

                addMemoDetail(obj_id, contents);
                insertMemoDetail(obj_id, contents);


                memoEditText.setText(null);
            }
        } else if(view==addMemoBtn){

            Intent intent = new Intent(this, AddMemoActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast t = Toast.makeText(this, "hey!", Toast.LENGTH_SHORT);
        t.show();
    }

    public void addMemoDetail (int obj_id, String contents) {
        //ListView에 추가하기
        HashMap<String, String> map = new HashMap<>();
        map.put("contents", contents);
//        map.put("orgl_dttm", datetime());
        map.put("orgl_dttm", "2018-04-14 16:59");
        memoList.add(map);

        adapter = new SimpleAdapter(this,
                memoList, android.R.layout.simple_list_item_2,
                new String[]{"contents", "orgl_dttm"},
                new int[]{android.R.id.text1, android.R.id.text2});

        memoListView.setAdapter(adapter);
    }

    public void insertMemoDetail (int obj_id, String contents){
        //DB에 저장
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into tkmm01tb (of_memo,contents,orgl_dttm,updt_dttm) " +
                "values ("+obj_id+",'"+contents+"', datetime('now','+9 hours')," +
                "datetime('now','+9 hours'))");

        db.close();
    }
}
