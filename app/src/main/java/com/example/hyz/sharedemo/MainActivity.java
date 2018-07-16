package com.example.hyz.sharedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button shareTextWx, shareTextQQ, shareTextAll;
    Button sharePicQQ, sharePicWx, sharePicWxPyq, sharePicAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        shareTextWx = findViewById(R.id.shareTextWx);
        shareTextQQ = findViewById(R.id.shareTextQQ);
        shareTextAll = findViewById(R.id.shareTextAll);
        //---------------------------------------------
        sharePicQQ = findViewById(R.id.sharePicQQ);
        sharePicWx = findViewById(R.id.sharePicWx);
        sharePicWxPyq = findViewById(R.id.sharePicWxPyq);
        sharePicAll = findViewById(R.id.sharePicAll);
        //---------------------------------------------
        shareTextWx.setOnClickListener(this);
        shareTextQQ.setOnClickListener(this);
        shareTextAll.setOnClickListener(this);
        sharePicQQ.setOnClickListener(this);
        sharePicWx.setOnClickListener(this);
        sharePicWxPyq.setOnClickListener(this);
        sharePicAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shareTextWx:
                shareTextWxFun();
                break;
            case R.id.shareTextQQ:
                break;
            case R.id.shareTextAll:
                break;
            case R.id.sharePicQQ:
                break;
            case R.id.sharePicWx:
                break;
            case R.id.sharePicWxPyq:
                break;
            case R.id.sharePicAll:
                break;
        }
    }

    private void shareTextWxFun() {

    }


}
