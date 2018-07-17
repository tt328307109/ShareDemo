package cn.melonmobile.pujin.thirdshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import cn.melonmobile.pujin.R;
import cn.melonmobile.pujin.utils.ImageUtils;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener {

    Button umshareQQ, umshareWx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initView();
    }

    private void initView() {
        umshareQQ = findViewById(R.id.umshareQQ);
        umshareWx = findViewById(R.id.umshareWx);

        umshareQQ.setOnClickListener(this);
        umshareWx.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.umshareQQ:
                shareQQ();
                break;
            case R.id.umshareWx:
                shareWx();
                break;
            default:
                break;
        }
    }

    private void shareWx() {
        String url = "https://weixin.qq.com/";
        String title = "这是微信分享标题";
        UMImage image = new UMImage(this, ImageUtils.getBitmap(R.drawable.name));
        String describe = "这是描述呢";
        doShareWx(url , title , image , describe);
    }

    private void shareQQ() {
        String url = "https://im.qq.com/";
        String title = "这是QQ分享标题";
        UMImage image = new UMImage(this, ImageUtils.getBitmap(R.drawable.name));
        String describe = "这是描述呢";
        doShareQQ(url , title , image , describe);
    }

    private void doShareWx(String url ,String title , UMImage image , String describe){
        UMWeb web = new UMWeb(url);
        web.setTitle(title);//标题
        web.setThumb(image);  //缩略图
        web.setDescription(describe);//描述

        new ShareAction(this)
                .setPlatform(SHARE_MEDIA.WEIXIN)//传入平台
                .withMedia(web)
                .setCallback(shareListener)//回调监听器
                .share();
    }


    private void doShareQQ(String url ,String title , UMImage image , String describe){
        UMWeb web = new UMWeb(url);
        web.setTitle(title);//标题
        web.setThumb(image);  //缩略图
        web.setDescription(describe);//描述

        new ShareAction(this)
                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                .withMedia(web)
                .setCallback(shareListener)//回调监听器
                .share();
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            //todo 成功
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            //todo 失败
            Toast.makeText(ShareActivity.this , t.getMessage() , Toast.LENGTH_SHORT).show();

        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
