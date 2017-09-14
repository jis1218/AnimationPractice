package com.example.animationprac;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class JoyStickActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlayer, btnUp, btnDown, btnLeft, btnRight;
    FrameLayout frameLayout = null;
    int playerX = 0;
    int playerY = 0;
    final int MOVE_VALUE = 40;
    TextView textView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joy_stick_);

        btnPlayer = (Button) findViewById(R.id.btnPlayer);
        btnDown = (Button) findViewById(R.id.btnDown);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnUp = (Button) findViewById(R.id.btnUp);
        btnRight = (Button) findViewById(R.id.btnRight);

        btnPlayer.setOnClickListener(this);
        btnDown.setOnClickListener(this);
        btnUp.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnLeft.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        int a[] = new int[2];
        frameLayout.getLocationInWindow(a);
        //textView.setText(a[0] + " " + a[1]);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnUp:
                up();
                break;
            case R.id.btnDown:
                down();
                break;
            case R.id.btnLeft:
                left();
                break;
            case R.id.btnRight:
                right();
                break;
        }
        move(playerX, playerY);
    }

    private void up(){
        playerY -= MOVE_VALUE;
    }

    private void down(){
        playerY += MOVE_VALUE;
    }

    private void left(){
        playerX -= MOVE_VALUE;
    }

    private void right(){
        playerX += MOVE_VALUE;
    }
    //이동 애니메이션 시키면 됨

    private void move(int x, int y) {

        ObjectAnimator aniX= ObjectAnimator.ofFloat(btnPlayer, "translationX", x);
        ObjectAnimator aniY = ObjectAnimator.ofFloat(btnPlayer, "translationY", y);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(aniX, aniY);
        set.start();

        int ab[] = new int[2];
        btnPlayer.getLocationOnScreen(ab);
        textView.setText(ab[0] + " " + ab[1]);


    }

    public void goJoyStick(View view){

    }

}
