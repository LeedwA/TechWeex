package com.weex.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import urils.ecaray.com.ecarutils.Utils.FileUtil;
import urils.ecaray.com.ecarutils.Utils.FileUtils;

import static com.taobao.weex.common.WXConfig.os;

public class MainActivity extends AppCompatActivity implements IWXRenderListener {

    WXSDKInstance mWXSDKInstance;
    private LinearLayout llay_weex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llay_weex = (LinearLayout) findViewById(R.id.llay_weex);

        mWXSDKInstance = new WXSDKInstance(this);
        mWXSDKInstance.registerRenderListener(this);
        /**
         * WXSample 可以替换成自定义的字符串，针对埋点有效。
         * template 是.we transform 后的 js文件。
         * option 可以为空，或者通过option传入 js需要的参数。例如bundle js的地址等。
         * jsonInitData 可以为空。
         * width 为-1 默认全屏，可以自己定制。
         * height =-1 默认全屏，可以自己定制。
         */

        //加载asset的hello.js
//        mWXSDKInstance.render("WXSample", WXFileUtils.loadAsset("hello.js", this), null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);

        //加载cache的hello.js
        FileUtils.createFileByDeleteOldFile((String)TextUtils.concat(getCacheDir().getAbsolutePath(),File.separator,"hello.js"));
        inputstreamtofile(getResources().openRawResource(R.raw.hello),
                new File((String)TextUtils.concat(getCacheDir().getAbsolutePath(),File.separator,"hello.js")));
        try {
            mWXSDKInstance.render("WXSample",
                    getString(new FileInputStream((String)TextUtils.concat(getCacheDir().getAbsolutePath(),File.separator,"hello.js"))),
                    null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //加载网络的hello.js
//        mWXSDKInstance.renderByUrl(getPackageName(), "http://192.168.0.52/parkCloud/wechat/hello.js", null, null, -1,
//              -1, WXRenderStrategy.APPEND_ASYNC);
    }

    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        llay_weex.addView(view);
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {
        //Native端可以通过接口IWXRenderListener中的onException方法进行处理，如果是主动降级errCode是以“|”分割的字符。
        // “|"前面的字符为1表示主动降级，Native端可以跳转到对应的H5页面。或者用其他的方式提示用户当前环境不支持Weex。
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityDestroy();
        }
    }



    public static String getString(InputStream inputStream) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public void inputstreamtofile(InputStream ins,File file){
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
