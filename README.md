# Weex使用指南
##1.环境配置
[WEEX SDK集成示例](https://github.com/weexteam/article/issues/4)  <br>
[node.js 下载地址](https://nodejs.org/en/) 
##2.集成方法

    APP(Build Gradle)
    compile 'com.alibaba:fastjson:1.1.45'
    compile 'com.taobao.android:weex_sdk:0.9.4@aar'
    compile 'com.github.goEcar:EcarWeex:+'

##3.调用方法
**一.Android加载Weex**<br>
1)Application加入<br>
 ```
@Override
public void onCreate() {
super.onCreate();
InitConfig config=new InitConfig.Builder().setImgAdapter(new TextImageAdapter()).build();
WXSDKEngine.registerComponent("mtext",TestComponent.class);
WXSDKEngine.registerModule("mModule",TestModule.class);
 WXSDKEngine.initialize(this,config);
}
```
2)Activity加入<br>
```  @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
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
    mWXSDKInstance.render("WXSample", WXFileUtils.loadAsset("hello.js", this), null, null, -1, -1,                    WXRenderStrategy.APPEND_ASYNC);
    }
    
      @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        llay_weex.addView(view);//渲染成功的view
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
  }
 ```
 3)Assest加入对应的.we文件生成的.js（此处为hello.js）   <br>
    生成方法   <br>
             1.cmd 进入.we文件目录 <br>
             2.执行  weex  xxxx.we命令生成js文件 <br>
             3.将js文件复制到asset文件夹 <br>
**二.Android自定义Weex控件**<br>
 ```
 public class TextImageAdapter implements IWXImgLoaderAdapter {
  @Override
  public void setImage(String url, ImageView view, WXImageQuality quality, WXImageStrategy strategy) {

    //本地图片统一规则：drawable://ic_launcher
    //放在drawable文件的图片名  注意：不能包含.png
    if (!TextUtils.isEmpty(url)) {
      if (url.startsWith("drawable://")) {
        getImageBydrawableName(view, url);//获取drawable图片
        return;
      }
    }
    //网络图片
    Picasso.with(view.getContext()).load(url).into(view);//获取网络图片
  }  
}
```
**三.weex调用Android方法**
```
       Application里先注册：
       WXSDKEngine.registerModule("mModule",TestModule.class);
      
   TestModule类：
   
    public class TestModule extends WXModule {

    @WXModuleAnno(runOnUIThread = true)
    public void printLog(String str) {
        Toast.makeText(mWXSDKInstance.getContext(), str, Toast.LENGTH_SHORT).show();
    }


}
    
  
    对应的js如下：
        <div>
        <text class="test" onclick="click">点我测试吐司</text>
     </div>
     <script>
  module.exports = {
    methods: {
      click: function() {
        require('@weex-module/mModule').printLog("测试吐司!");
      }
    }
  }
```
**四.Android自定义Weex控件**<br>
   ```
    Application里先注册：
      WXSDKEngine.registerComponent("mtext",TestComponent.class);
      
   TestComponent类： 
    
    public class TestModule extends WXModule {

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
    对应的js
    
        <div>
      <mtext tel="123456" style="width:200;height:100">123456</mtext>
    </div>   
```


##4.资料集合
[WEEX 初级教程](https://weex-project.io/cn/guide/integrate-to-your-app.html)  <br>
[WEEX 进阶教程](https://weex-project.io/cn/references/android-apis.html)  <br>
[WEEX github地址](https://github.com/alibaba/weex)  <br>
[weex项目实战篇](http://www.07net01.com/2017/02/1797605.html)  <br>
[Weex Android SDK源码分析之界面渲染（上）](http://blog.csdn.net/walid1992/article/details/51705371)  <br>
[Weex Android SDK源码分析之界面渲染（下）](http://blog.csdn.net/walid1992/article/details/51759588?locationNum=2&fps=1)  <br>
[Weex 入坑指南：快速开始 Weex 之旅](https://zhuanlan.zhihu.com/p/25177344)  <br>

  
