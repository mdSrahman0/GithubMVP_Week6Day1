package com.example.githubmvp_week6day1.view.activities.mainactivity;

import com.example.githubmvp_week6day1.model.remote.OkHttpClass;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import okhttp3.OkHttpClient;

public class MainActivityPresenter {

    MainActivityContract mainActivityContract;

    OkHttpClass okHttpClass = new OkHttpClass();

    public OkHttpClass getOkHttpClass() {
        return okHttpClass;
    }

    public void setOkHttpClass(OkHttpClass okHttpClass) {
        okHttpClass.getAsyncResponse();
        this.okHttpClass = okHttpClass;
    }
}
