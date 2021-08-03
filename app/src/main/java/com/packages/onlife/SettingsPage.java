package com.packages.onlife;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class SettingsPage extends Fragment {



    public SettingsPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Button theme, donate;
        View view = inflater.inflate(R.layout.fragment_settings_page, container, false);
        ImageButton sound_toggle, music_toggle;
        final int[] count1 = new int[1];
        final int[] count2 = new int[1];
        music_toggle = (ImageButton) view.findViewById(R.id.music_toggle);
        sound_toggle = (ImageButton) view.findViewById(R.id.sound_toggle);
        music_toggle.setImageResource(R.drawable.unmutenot);
        sound_toggle.setImageResource(R.drawable.unmutes);
        theme = (Button) view.findViewById(R.id.theme_toggle);
        donate = (Button) view.findViewById(R.id.donate_butt);


        count1[0] = 0;
        count2[0] = 0;
        music_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count1[0] == 0){
                    music_toggle.setImageResource(R.drawable.mutes);
                    count1[0] = 1;
                }else{
                    music_toggle.setImageResource(R.drawable.unmutenot);
                    count1[0] = 0;
                }
            }
        });

        sound_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count2[0] == 0){
                    sound_toggle.setImageResource(R.drawable.mutenot);
                    count2[0] = 1;
                }else{
                    sound_toggle.setImageResource(R.drawable.unmutes);
                    count2[0] = 0;
                }
            }
        });

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.google.com")));
            }
        });
        return view;
    }
}