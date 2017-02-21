package com.flydance.tutu.app;

import android.app.Application;

import com.flydance.basemodule.utils.L;
import com.flydance.basemodule.utils.SPUtils;
import com.flydance.basemodule.utils.Utils;
import com.flydance.basemodule.widget.loadingLayout.LoadingLayout;
import com.flydance.tutu.R;
import com.way.chat.manager.Manager;

/**
 * Created by tutu on 2016/12/29.
 */

public class App extends Application {
    public static App app;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initUtils();
        initSP();
        initLoger();
        initLoadingLayout();

        initDao();
    }

    private void initDao() {
        Manager.setupDatabase(app);
    }

    private void initLoadingLayout() {
        LoadingLayout.getConfig()
                .setErrorText("出错啦~请稍后重试！")
                .setEmptyText("抱歉，暂无数据")
                .setNoNetworkText("无网络连接，请检查您的网络···")
                .setErrorImage(R.mipmap.error)
                .setEmptyImage(R.mipmap.empty)
                .setNoNetworkImage(R.mipmap.no_network)
                .setAllTipTextColor(R.color.black)
                .setAllTipTextSize(14)
                .setReloadButtonText("点我重试哦")
                .setReloadButtonTextSize(14)
                .setReloadButtonTextColor(R.color.black)
                .setReloadButtonWidthAndHeight(150, 40)
                .setAllPageBackgroundColor(R.color.bg);
        //可配置加载中的layout
//        .setLoadingPageLayout(R.layout.define_loading_page);
    }

    private void initLoger() {
        L.initLoger();
    }

    private void initSP() {
        SPUtils.initSP("data");
    }

    private void initUtils() {
        //初始化工具类Context
        Utils.init(this);
    }
}
