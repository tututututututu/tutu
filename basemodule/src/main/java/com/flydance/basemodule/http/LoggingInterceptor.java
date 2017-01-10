package com.flydance.basemodule.http;

import com.flydance.basemodule.utils.L;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by tutu on 2017/1/10.
 */

public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        L.ir("请求url参数="+chain.request().url()+chain.request().headers().toString());
        L.ir("返回结果="+chain.request().body().toString());



        return chain.proceed(chain.request());
    }
}
