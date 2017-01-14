package com.flydance.basemodule.fileUploadDownload.up.http;

import com.flydance.basemodule.fileUploadDownload.up.entity.BaseResultEntity;
import com.flydance.basemodule.fileUploadDownload.up.entity.UploadResulte;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * service统一接口数据
 * Created by WZG on 2016/7/16.
 */
public interface HttpService {
    /*上传文件*/
    @Multipart
    @POST("AppYuFaKu/uploadHeadImg")
    Observable<BaseResultEntity<UploadResulte>> uploadImage(@Part("uid") RequestBody uid, @Part("auth_key") RequestBody auth_key,
                                                            @Part MultipartBody.Part file);
}
