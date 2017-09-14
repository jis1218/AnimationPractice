package com.example.animationprac;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class PropertyAnimation extends AppCompatActivity {

    Button btnJoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

        btnJoy = (Button) findViewById(R.id.btnJoy);
        btnJoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PropertyAnimation.this, JoyStickActivity.class);
                startActivity(intent);
            }
        });
    }

    public void move(View view){
        // 1. 대상을 정의한다. > btnGo
        // 2. 애니메이터를 설정한다.

        ObjectAnimator aniY= ObjectAnimator.ofFloat(btnJoy, "translationY", 100); //움직일 대상, 애니메이션 속성, 속성값
        // 3. 애니메이터를 실행한다.

        ObjectAnimator aniX= ObjectAnimator.ofFloat(btnJoy, "translationX", 100);


        AnimatorSet aniSet = new AnimatorSet();
        aniSet.playTogether(aniY, aniX);
        aniSet.setDuration(3000);
        aniSet.setInterpolator(new LinearInterpolator()); //거리가 가까워지면 속도가 느려지는 것
        // LinearInterpolator()는 일정한 속도 유지, 그 밖에도 여러 Interpolator가 있다.
        aniSet.start();



    }

    public void goJoyStick(View view){

    }
}
