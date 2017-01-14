package com.flydance.basemodule.fileUploadDownload.up;

/**
 * Created by tutu on 2017/1/14.
 */

public class UseDemo {

//    private void uploadeDo(){
//        File file=new File("/storage/emulated/0/Download/11.jpg");
//        RequestBody requestBody=RequestBody.create(MediaType.parse("image/jpeg"),file);
//        MultipartBody.Part part= MultipartBody.Part.createFormData("file_name", file.getName(), new ProgressRequestBody(requestBody,
//                new UploadProgressListener() {
//                    @Override
//                    public void onProgress(long currentBytesCount, long totalBytesCount) {
//                        tvMsg.setText("提示:上传中");
//                        progressBar.setMax((int) totalBytesCount);
//                        progressBar.setProgress((int) currentBytesCount);
//                    }
//                }));
//        UplaodApi uplaodApi = new UplaodApi(httpOnNextListener,this);
//        uplaodApi.setPart(part);
//        HttpManager manager = HttpManager.getInstance();
//        manager.doHttpDeal(uplaodApi);
//    }
//
//
//    /**
//     * 上传回调
//     */
//    HttpOnNextListener httpOnNextListener=new HttpOnNextListener<UploadResulte>() {
//        @Override
//        public void onNext(UploadResulte o) {
//            tvMsg.setText("成功");
//            Glide.with(MainActivity.this).load(o.getHeadImgUrl()).skipMemoryCache(true).into(img);
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            super.onError(e);
//            tvMsg.setText("失败："+e.toString());
//        }
//
//    };
}
