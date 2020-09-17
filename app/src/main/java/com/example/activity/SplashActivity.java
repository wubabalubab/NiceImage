package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.common.BaseActivity;
import com.example.textview.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_splash);

        jumpToMain();
    }
    private void jumpToMain(){
        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
        SplashActivity.this.finish();

    }
}
