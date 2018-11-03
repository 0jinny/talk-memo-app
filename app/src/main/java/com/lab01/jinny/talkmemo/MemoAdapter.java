package com.lab01.jinny.talkmemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/* MemoAdapter : Adapter for Memo */
public class MemoAdapter extends ArrayAdapter<MemoVO> {

    Context context;
    int resId;
    ArrayList<MemoVO> datas;

    public MemoAdapter(Context context, int resId, ArrayList<MemoVO> datas){
        super(context, resId);
        this.context = context;
        this.resId = resId;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();//전체 항목 개수
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null){//최초 실행 시에만 xml 레이아웃 초기화(p.332)
            LayoutInflater inflater = (LayoutInflater)context.getSystemService
                                      (Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            MemoHolder holder = new MemoHolder(convertView);//findViewById 호출 성능 개선을 위한 holder
            convertView.setTag(holder);
        }

        MemoHolder holder = (MemoHolder)convertView.getTag();

        ImageView memoImageView = holder.memoImageView;
        TextView titleView = holder.titleView;
        TextView dateView = holder.dateView;

        final MemoVO vo = datas.get(position);

        titleView.setText(vo.title);
        dateView.setText(vo.date);

        /*나중에 바꿀것 --> 메모장별로 이미지 바꾸기*/
        if(titleView.getText().equals("C O S M E T I C S")){
            memoImageView.setImageDrawable(ResourcesCompat.getDrawable
                    (context.getResources(), R.drawable.cosmetics, null));
        }
        else{
            memoImageView.setImageDrawable(ResourcesCompat.getDrawable
                    (context.getResources(), R.drawable.dumbo, null));
        }

        return convertView;
    }
}
