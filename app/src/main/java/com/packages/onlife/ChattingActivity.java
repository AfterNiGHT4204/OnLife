package com.packages.onlife;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getstream.sdk.chat.Chat;
import com.scaledrone.lib.Listener;
import com.scaledrone.lib.Room;
import com.scaledrone.lib.RoomListener;
import com.scaledrone.lib.Scaledrone;

import java.util.ArrayList;
import java.util.List;

public class ChattingActivity extends AppCompatActivity{

    private MessageAdapter messageAdapter;
    private ListView messagesView;

    List<String> stringList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        ImageButton sendbutt;
        Button choice1, choice2;
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout02);
        choice1 = (Button) findViewById(R.id.editText);
        choice2 = (Button) findViewById(R.id.editText2);
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = Gravity.RIGHT;
        layoutParams.setMargins(0,0,0,20);
        final LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams2.gravity = Gravity.LEFT;
        layoutParams2.setMargins(0,0,0,20);
        /*final ImageView layoutParams3 = new LinearLayout.LayoutParams(
                90,90
        );
        layoutParams2.gravity = Gravity.LEFT;*/
        sendbutt = (ImageButton) findViewById(R.id.sendbutt);

        TextView imageView = new TextView(ChattingActivity.this);
        imageView.setTextSize(25);
        imageView.setText(" You are invited to a party, but \n your parents didn't allow you \n to go to it. What are you \n going  to do? ");
        imageView.setBackgroundResource(R.drawable.my_message);

        imageView.setGravity(Gravity.RIGHT);



        linearLayout.addView(imageView, layoutParams);
        //messageAdapter = new MessageAdapter(this);
        //messagesView = (ListView) findViewById(R.id.messages_view);
        //messagesView.setAdapter(messageAdapter);

        sendbutt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {




            }
        });

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView imageView = new TextView(ChattingActivity.this);
                imageView.setTextSize(25);
                int end = 0;
                if(choice1.getText().toString().equals("Choose to stay")){
                    imageView.setText(" I choose to stay home. ");
                }else if(choice1.getText().toString().equals("Choose to go to the party")){
                    imageView.setText(" I choose to go to the party. ");
                }else if(choice1.getText().toString().equals("Have a dinner with parents")){
                    imageView.setText(" I have a dinner with my parents. ");
                }else if(choice1.getText().toString().equals("Drink alcohol with friends")){
                    imageView.setText(" I choose to drink with my friends. ");
                }

                imageView.setBackgroundResource(R.drawable.my_message);

                imageView.setGravity(Gravity.RIGHT);

                linearLayout.addView(imageView, layoutParams);

                TextView textView = new TextView(ChattingActivity.this);
                textView.setTextSize(25);
                if(choice1.getText().toString().equals("Choose to stay")){
                    textView.setText(" Your parents invite you to have a \n dinner with them. What are \n you going to do? ");
                    choice1.setText("Have a dinner with parents");
                    choice2.setText("Stay in your room");
                }else if(choice1.getText().toString().equals("Choose to go to the party")){
                    textView.setText(" Your friends want you to \n drink with them. What is \n your choice? ");
                    choice1.setText("Drink alcohol with friends");
                    choice2.setText("Stay in a corner alone");
                }else if(choice1.getText().toString().equals("Have a dinner with parents")){
                    textView.setText(" You are having a nice dinner \n with your family and enjoy \n a nice and peaceful evening. ");
                    choice1.setText("Best Ending");
                    choice2.setText("Best Ending");
                }else if(choice1.getText().toString().equals("Drink alcohol with friends")){
                    textView.setText(" You end up drinking too much \n alcohol and your so-called friends \n having bad photos of you. \n You are ashamed. ");
                    choice1.setText("You don't remember anything");
                    choice2.setText("Dead End");
                    end = 1;
                }

                textView.setBackgroundResource(R.drawable.their_message);


                imageView.setGravity(Gravity.LEFT);

                linearLayout.addView(textView,layoutParams2);

                if(end == 1){
                    ImageView imageView1 = new ImageView(ChattingActivity.this);
                    imageView1.setImageResource(R.drawable.emptybot);
                    imageView1.setLayoutParams(new LinearLayout.LayoutParams(500,300));
                    linearLayout.addView(imageView1);

                }


                //stringList.add(editText.getText().toString());

            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView imageView = new TextView(ChattingActivity.this);
                imageView.setTextSize(25);
                if(choice2.getText().toString().equals("Choose to run")){
                    imageView.setText(" I choose to run away. ");
                }else if(choice2.getText().toString().equals("Choose to go back home")){
                    imageView.setText(" I choose to go to back home. ");
                }else if(choice2.getText().toString().equals("Stay in your room")){
                    imageView.setText(" I choose to stay in my room. ");
                }else if(choice2.getText().toString().equals("Stay in a corner alone")){
                    imageView.setText(" I choose to stay in a corner alone. ");
                }

                imageView.setBackgroundResource(R.drawable.my_message);


                imageView.setGravity(Gravity.RIGHT);



                linearLayout.addView(imageView, layoutParams);

                TextView textView = new TextView(ChattingActivity.this);
                textView.setTextSize(25);
                if(choice2.getText().toString().equals("Choose to run")){
                    textView.setText(" You neglect your parents choice \n and still  go to the party. But \n halfway through you think that \n you might want to go back home.\n What is your choice?");
                    choice1.setText("Choose to go to the party");
                    choice2.setText("Choose to go back home");
                }else if(choice2.getText().toString().equals("Choose to go back home")){
                    textView.setText(" You go back home without your parents \n noticing anything, and then they \n come to your room and invite \n you to have a dinner with them. \n What are you going to do?");
                    choice1.setText("Have a dinner with parents");
                    choice2.setText("Stay in your room");
                }else if(choice2.getText().toString().equals("Stay in your room")){
                    textView.setText(" You are mad with them so you \n decide to stay in your room \n until you calm down. ");
                    choice1.setText("Try better next time");
                    choice2.setText("Good Ending");
                }else if(choice2.getText().toString().equals("Stay in a corner alone")){
                    textView.setText(" You decide to ignore them \n and end up being the one who \n ruined all the fun there. \n You feel bad. ");
                    choice1.setText("You are the party-ruiner");
                    choice2.setText("Dead end");
                }

                textView.setBackgroundResource(R.drawable.their_message);


                imageView.setGravity(Gravity.LEFT);

                linearLayout.addView(textView,layoutParams2);

            }
        });


    }
        // This is where we write the mesage


    }
