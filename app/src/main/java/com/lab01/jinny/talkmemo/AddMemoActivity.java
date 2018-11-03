package com.lab01.jinny.talkmemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/* AddMemoActivity : 메모방을 추가한다. */
public class AddMemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//팝업 타이틀 없애기

        WindowManager.LayoutParams layoutParams= new WindowManager.LayoutParams();
        layoutParams.flags= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount= 0.7f;//배경 투명도
        getWindow().setAttributes(layoutParams);

        setContentView(R.layout.activity_add_memo);

    }
}
