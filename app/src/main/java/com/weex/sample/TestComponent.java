package com.weex.sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;

/*************************************
 * 功能：    weex    WXComponent   示例
 * 创建者： kim_tony
 * 创建日期：2017/2/8
 * 版权所有：深圳市亿车科技有限公司
 *************************************/

public class TestComponent extends WXComponent {


    public TestComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent) {
        super(instance, dom, parent);
    }

    @Override
    protected TextView initComponentHostView(@NonNull Context context) {
        mHost=new TextView(context);
        ((TextView)mHost).setMovementMethod(LinkMovementMethod.getInstance());
        return (TextView)mHost;
    }

    @WXComponentProp(name = "tel")
    public void setTelLink(String tel){
        SpannableString spannable=new SpannableString(tel);
        spannable.setSpan(new URLSpan("tel:"+tel),0,tel.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView)mHost).setText(spannable);
    }

}
