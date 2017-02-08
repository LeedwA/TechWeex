package com.weex.sample;

import android.widget.Toast;

import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXModuleAnno;

/*************************************
 * 功能：weex module
 * 创建者： kim_tony
 * 创建日期：2017/2/8
 * 版权所有：深圳市亿车科技有限公司
 *************************************/

public class TestModule extends WXModule {

    @WXModuleAnno(runOnUIThread = true)
    public void printLog(String str) {
        Toast.makeText(mWXSDKInstance.getContext(), str, Toast.LENGTH_SHORT).show();
    }


}
