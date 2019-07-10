package com.example.githubmvp_week6day1.view.activities.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.githubmvp_week6day1.R;
import com.example.githubmvp_week6day1.model.datasource.local.pojos.GithubResponse;
import com.example.githubmvp_week6day1.model.remote.OkHttpClass;
import com.example.githubmvp_week6day1.view.activities.reporesponseactivity.RepoResponseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplayUser;
    TextView tvDisplayBio;
    TextView tvDisplayCompany;
    TextView tvDisplayLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplayUser = findViewById(R.id.tvDisplayUser);
        tvDisplayBio = findViewById(R.id.tvDisplayBio);
        tvDisplayCompany = findViewById(R.id.tvDisplayCompany);
        tvDisplayLocation = findViewById(R.id.tvDisplayLocation);

        OkHttpClass okHttpClass = new OkHttpClass();
        okHttpClass.getAsyncResponse();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Unregister to EventBus
        EventBus.getDefault().unregister(this);
    }

    //Subscribe to the posting event on EventBus that is passing a UserResponse
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void userResponseEvent(GithubResponse githubResponse) {
        Log.d("TAG_EVENT_RECEIVED", githubResponse.getName());

        tvDisplayUser.setText("Name: " + githubResponse.getName());
        tvDisplayBio.setText("Bio: " + githubResponse.getBio());
        tvDisplayCompany.setText("Company: " + githubResponse.getCompany());
        tvDisplayLocation.setText("Location: " + githubResponse.getLocation());
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, RepoResponseActivity.class);
        startActivity(intent);
    }

}
