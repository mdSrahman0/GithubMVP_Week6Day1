package com.example.githubmvp_week6day1.view.activities.mainactivity;

import com.example.githubmvp_week6day1.model.remote.OkHttpClass;

import org.greenrobot.eventbus.EventBus;

public interface MainActivityContract {
    void startOkHttpClient(OkHttpClass okHttpClass);
}
