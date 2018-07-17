package cn.melonmobile.pujin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
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
    //cn.melonmobile.pujin
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
                shareTextQQFun();
                break;
            case R.id.shareTextAll:
                shareTextAllFun();
                break;
            case R.id.sharePicQQ:
                sharePicQQFun();
                break;
            case R.id.sharePicWx:
                sharePicWxFun();
                break;
            case R.id.sharePicWxPyq:
                sharePicWxPyqFun();
                break;
            case R.id.sharePicAll:
                sharePicAllFun();
                break;
        }
    }

    private void sharePicAllFun() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.name);
        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(
                this.getContentResolver(), bitmap, null, null));
        ShareUtils utils = new ShareUtils(this);
        utils.sharePicAllFun("这是sharePicAllFun--msg" ,uri);
    }

    private void sharePicWxPyqFun() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.name);
        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(
                this.getContentResolver(), bitmap, null, null));
        ShareUtils utils = new ShareUtils(this);
        utils.sharePicWxPyqFun("这是sharePicWxPyqFun--msg" ,uri);
    }

    private void sharePicWxFun() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.name);
        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(
                this.getContentResolver(), bitmap, null, null));
        ShareUtils utils = new ShareUtils(this);
        utils.sharePicWxFun("这是sharePicWxFun--msg" ,uri);
    }

    private void sharePicQQFun() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources() , R.drawable.name);
        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(
                this.getContentResolver(), bitmap, null, null));
        ShareUtils utils = new ShareUtils(this);
        utils.sharePicQQFun("这是sharePicQQFun--msg" ,uri);
    }

    private void shareTextAllFun() {
        ShareUtils utils = new ShareUtils(this);
        utils.shareTextAllFun("这是shareTextAllFun--msg");
    }

    private void shareTextQQFun() {
        ShareUtils utils = new ShareUtils(this);
        utils.shareTextQQFun("这是shareTextQQFun--msg");
    }

    private void shareTextWxFun() {
        ShareUtils utils = new ShareUtils(this);
        utils.shareTextWxFun("这是shareTextWxFun--msg");
    }


}
