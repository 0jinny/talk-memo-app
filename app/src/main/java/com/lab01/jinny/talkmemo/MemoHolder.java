package com.lab01.jinny.talkmemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* MemoHolder : findViewById 호출 횟수 줄이기 위한 Holder 클래스 */
public class MemoHolder {
    public ImageView memoImageView;
    public TextView titleView;
    public TextView dateView;

    public MemoHolder(View root){
        memoImageView = (ImageView)root.findViewById(R.id.memo_title_image);
        titleView = (TextView)root.findViewById(R.id.memo_title);
        dateView = (TextView)root.findViewById(R.id.memo_date);
    }
}
