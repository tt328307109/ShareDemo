package cn.melonmobile.pujin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.util.List;

public class ShareUtils {
    Context activityContext;

    public ShareUtils(Context activityContext) {
        this.activityContext = activityContext;
    }

    /**
     * 分享文字到微信好友
     * @param msg
     */
    public void shareTextWxFun(String msg){
        //首先判断微信是否安装
        if (!isAvilible(activityContext, "com.tencent.mm")) {// 判断APP是否存在
            Toast.makeText(activityContext, "请先安装微信", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "这是msgTitle");//没作用
        shareIntent.putExtra(Intent.EXTRA_TEXT, "这是msgText:" + msg);//有作用
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI"));
        activityContext.startActivity(shareIntent);
    }

    /**
     * 分享文字到QQ好友
     * @param msg
     */
    public void shareTextQQFun(String msg){
        //首先判断QQ是否安装
        if (!isAvilible(activityContext, "com.tencent.mobileqq")) {// 判断APP是否存在
            Toast.makeText(activityContext, "请先安装QQ", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "这是msgTitle");//没作用
        shareIntent.putExtra(Intent.EXTRA_TEXT, "这是msgText:" + msg);//有作用
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
        activityContext.startActivity(shareIntent);
    }

    /**
     * 分享文字到全部
     * @param msg
     */
    public void shareTextAllFun(String msg){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "这是msgTitle");//没作用
        shareIntent.putExtra(Intent.EXTRA_TEXT, "这是msgText:" + msg);//有作用
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activityContext.startActivity(Intent.createChooser(shareIntent, "这是chooser的title"));
    }

    /**
     * 分享图片到QQ好友
     * @param msg
     * @param picUri
     */
    public void sharePicQQFun(String msg , Uri picUri){
        //首先判断QQ是否安装
        if (!isAvilible(activityContext, "com.tencent.mobileqq")) {// 判断APP是否存在
            Toast.makeText(activityContext, "请先安装QQ", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, picUri);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "这是msgTitle");//没作用
        shareIntent.putExtra(Intent.EXTRA_TEXT, "这是msgText:" + msg);//分享图片时这个没作用
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
        activityContext.startActivity(shareIntent);
    }

    /**
     * 分享图片到微信好友
     * @param msg
     * @param picUri
     */
    public void sharePicWxFun(String msg , Uri picUri){
        //首先判断微信是否安装
        if (!isAvilible(activityContext, "com.tencent.mm")) {// 判断APP是否存在
            Toast.makeText(activityContext, "请先安装微信", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, picUri);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "这是msgTitle");//没作用
        shareIntent.putExtra(Intent.EXTRA_TEXT, "这是msgText:" + msg);//分享图片时这个没作用
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI"));
        activityContext.startActivity(shareIntent);
    }

    /**
     * 分享图片到微信朋友圈
     * @param msg
     * @param picUri
     */
    public void sharePicWxPyqFun(String msg , Uri picUri){
        //首先判断微信是否安装
        if (!isAvilible(activityContext, "com.tencent.mm")) {// 判断APP是否存在
            Toast.makeText(activityContext, "请先安装微信", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, picUri);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "这是msgTitle");//没作用
        shareIntent.putExtra(Intent.EXTRA_TEXT, "这是msgText:" + msg);//分享图片时这个没作用
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
        activityContext.startActivity(shareIntent);
    }


    /**
     * 分享图片到全部
     * @param msg
     * @param picUri
     */
    public void sharePicAllFun(String msg , Uri picUri){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, picUri);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "这是msgTitle");//没作用
        shareIntent.putExtra(Intent.EXTRA_TEXT, "这是msgText:" + msg);//分享图片时这个没作用
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activityContext.startActivity(Intent.createChooser(shareIntent, "这是chooser的title"));
    }


    private boolean isAvilible(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();

        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        for (int i = 0; i < pinfo.size(); i++) {
            if (((PackageInfo) pinfo.get(i)).packageName
                    .equalsIgnoreCase(packageName))
                return true;
        }
        return false;
    }
}
