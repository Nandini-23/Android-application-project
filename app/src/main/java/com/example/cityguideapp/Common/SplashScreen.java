package com.example.cityguideapp.Common;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguideapp.R;
import com.example.cityguideapp.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    //variables
    ImageView backgroundImage;
    TextView poweredByLine;

    //animation
    Animation sideAnim, bottomAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);


        //Hooks
        backgroundImage = findViewById(R.id.background_image);
        poweredByLine = findViewById(R.id.powered_by_line);


    //Animations
     sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
     bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

     //set Aniation on elements
     backgroundImage.setAnimation(sideAnim);
     poweredByLine.setAnimation(bottomAnim);

     new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
             Intent intent = new Intent(getApplicationContext(),UserDashboard.class);
             startActivity(intent);
             finish();

         }
     },SPLASH_TIMER);


    }
}