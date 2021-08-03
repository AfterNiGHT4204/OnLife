package com.packages.onlife;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.getstream.sdk.chat.Chat;


public class MainPage extends Fragment {


    public MainPage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main_page, container, false);

        Button play, settings;
        play = (Button) view.findViewById(R.id.play_butt);
        settings = (Button) view.findViewById(R.id.sett_butt);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
                        R.anim.disappear);
                play.startAnimation(animation);*/

                Intent intent = new Intent(getActivity(), ChattingActivity.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SettingsPage();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.mainfrag, fragment);
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        return view;


    }
}

