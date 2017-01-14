package com.flydance.basemodule.fileUploadDownload.down;

import com.flydance.basemodule.fileUploadDownload.down.downlaod.DownInfo;
import com.flydance.basemodule.fileUploadDownload.down.downlaod.HttpDownManager;
import com.flydance.basemodule.fileUploadDownload.down.listener.HttpProgressOnNextListener;

/**
 * Created by tutu on 2017/1/14.
 */

public class UseDemo {
    public void use(){
        HttpDownManager manager= HttpDownManager.getInstance();

        DownInfo data = new DownInfo("url",httpProgressOnNextListener);
        manager.startDown(data);
        //支持多任务下载
        //manager.stopAllDown();
    }

    /*下载回调*/
    HttpProgressOnNextListener<DownInfo> httpProgressOnNextListener=new HttpProgressOnNextListener<DownInfo>() {
        @Override
        public void onNext(DownInfo baseDownEntity) {
            //Toast.makeText(getContext(),baseDownEntity.getSavePath(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStart() {
            // tvMsg.setText("提示:开始下载");
        }

        @Override
        public void onComplete() {
            // tvMsg.setText("提示：下载完成");
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            //tvMsg.setText("失败:"+e.toString());
        }


        @Override
        public void onPuase() {
            super.onPuase();
            //tvMsg.setText("提示:暂停");
        }

        @Override
        public void onStop() {
            super.onStop();
        }

        @Override
        public void updateProgress(long readLength, long countLength) {
            // tvMsg.setText("提示:下载中");
            //  progressBar.setMax((int) countLength);
            //  progressBar.setProgress((int) readLength);
        }
    };
}
