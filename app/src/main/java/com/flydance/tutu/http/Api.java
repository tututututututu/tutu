package com.flydance.tutu.http;


import com.flydance.basemodule.http.ParamsInterceptord;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by tutu on 16-11-17
 * Description:
 */
public class Api {
    /**
     * HOST地址
     */
    public static final String BASE_URL = "http://v.juhe.cn/";
    public static volatile ApiService apiService;
    private static volatile Api api;

    public static ApiService getInstance() {
        if (api == null) {
            synchronized (ApiService.class) {
                if (api == null) {
                    api = new Api();
                }
            }
        }
        return apiService;
    }

    private Api() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(
//                new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                L.ir("访问日志="+message);
//            }
//        }
        );
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
//                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new ParamsInterceptord()).build();

        apiService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build().create(ApiService.class);
    }


}
