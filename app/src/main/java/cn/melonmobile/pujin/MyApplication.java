package cn.melonmobile.pujin;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import cn.melonmobile.pujin.utils.Utils;

import static cn.melonmobile.pujin.AppConstancs.APP_QQ_ID;
import static cn.melonmobile.pujin.AppConstancs.APP_QQ_KEY;
import static cn.melonmobile.pujin.AppConstancs.APP_WX_ID;
import static cn.melonmobile.pujin.AppConstancs.APP_WX_KEY;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        UMConfigure.init(this,"5acf55c9f29d98626c0001ae","unknow",UMConfigure.DEVICE_TYPE_PHONE,"");
        UMShareAPI.get(Utils.getContext());
        PlatformConfig.setWeixin(APP_WX_ID, APP_WX_KEY);//微信分享初始化
//        PlatformConfig.setQQZone("1105891995","qwRR14ZrA5TUyyic");//QQ分享初始化
        PlatformConfig.setQQZone(APP_QQ_ID,APP_QQ_KEY);//QQ分享初始化
    }
}
