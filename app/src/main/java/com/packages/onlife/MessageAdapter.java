package com.packages.onlife;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends ArrayAdapter<String> {
    Context context;
    private List<String> listString;
    private final LayoutInflater mInflater;
    public MessageAdapter(Context context) {
        super(context, R.layout.my_message);

        this.context = context;

        mInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public void setData(List<String> stringList) {
        listString = stringList;

        clear();
        if(stringList != null){
            addAll(stringList);
            notifyDataSetChanged();
        }
        Log.d("watafak", "setat");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        if(convertView != null){
            view = mInflater.inflate(R.layout.my_message,parent,false);

        }else {
            view = convertView;
            String currentString = listString.get(position);
            TextView textView = (TextView) view.findViewById(R.id.message_body);

            textView.setText(currentString);
        }



        return convertView;
    }

}