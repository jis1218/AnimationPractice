package com.example.animationprac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMove, btnRotate, btnScale, btnAlpha, btnObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlpha = (Button) findViewById(R.id.btnAlpha);
        btnMove = (Button) findViewById(R.id.btnMove);
        btnObject = (Button) findViewById(R.id.btnObject);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnScale = (Button) findViewById(R.id.btnScale);

        btnMove.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        btnObject.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAlpha:
                alpha();
                break;
            case R.id.btnMove:
                move();
                break;
            case R.id.btnObject:
                Intent intent = new Intent(this, PropertyAnimation.class);
                startActivity(intent);
                break;
            case R.id.btnRotate:
                rotate();
                break;
            case R.id.btnScale:
                scale();
                break;
        }
    }
    // View Animation 정의할 때
    // 1. 애니메이션 xml 정의
    // 2. AnimationUtil로 정의된 애니메이션을 로드해야 한다.(메모리에 올린다.)
    // 3. 로드된 애니메이션을 실제 위젯에 적용
    private void move(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.move);//AnimationUtils는 Animation 객체를 만들어준다.
        btnMove.startAnimation(anim);
    }
    private void rotate(){
        Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        btnRotate.startAnimation(animRotate);
    }
    private void scale(){
        Animation animScale = AnimationUtils.loadAnimation(this, R.anim.scale);
        btnScale.startAnimation(animScale);
    }
    private void alpha(){
        Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        btnAlpha.startAnimation(animAlpha);

    }


}
