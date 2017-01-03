package com.morycom.bellgameshow;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable anim;
    ImageView button;
    LinearLayout layoutMenu;
    Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF;
    TextView title;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        button = (ImageView) findViewById(R.id.button);
        layoutMenu = (LinearLayout) findViewById(R.id.layoutMenu);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        buttonE = (Button) findViewById(R.id.buttonE);
        buttonF = (Button) findViewById(R.id.buttonF);
        title = (TextView) findViewById(R.id.title);

        button.setSoundEffectsEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    mp.pause();
                }
                mp.start();
            }
        });

//        button.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    if (v.getId() == R.id.button) {
//                        mp.setLooping(true);
//                        mp.start();
//                    }
//                } else if (event.getAction() == MotionEvent.ACTION_UP) {
//                    if (v.getId() == R.id.button) {
//                        mp.setLooping(false);
//                        mp.pause();
//                    }
//                }
//                return false;
//            }
//        });


        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutMenu.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("Group A");
                mp = MediaPlayer.create(MainActivity.this, R.raw.sound1);
            }
        });


        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutMenu.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("Group B");
                mp = MediaPlayer.create(MainActivity.this, R.raw.sound2);
            }
        });


        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutMenu.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("Group C");
                mp = MediaPlayer.create(MainActivity.this, R.raw.sound3);
            }
        });


        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutMenu.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("Group D");
                mp = MediaPlayer.create(MainActivity.this, R.raw.sound4);
            }
        });

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutMenu.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("Group E");
                mp = MediaPlayer.create(MainActivity.this, R.raw.sound5);
            }
        });

        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutMenu.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                title.setText("Group F");
                mp = MediaPlayer.create(MainActivity.this, R.raw.sound6);
            }
        });



        anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }

    @Override
    public void onBackPressed(){
        if(layoutMenu.getVisibility()==View.VISIBLE){
            finish();
        }else if (layoutMenu.getVisibility()==View.GONE){
            layoutMenu.setVisibility(View.VISIBLE);
            button.setVisibility(View.GONE);
            title.setVisibility(View.GONE);
            title.setText("");
            mp.stop();
        }
    }

}
