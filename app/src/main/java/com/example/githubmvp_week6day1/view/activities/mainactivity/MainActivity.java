package com.example.githubmvp_week6day1.view.activities.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.githubmvp_week6day1.R;
import com.example.githubmvp_week6day1.model.remote.OkHttpClass;
import com.example.githubmvp_week6day1.view.activities.reporesponseactivity.RepoResponseActivity;

public class MainActivity extends AppCompatActivity {

    MainActivityPresenter mainActivityPresenter;
    TextView tvDisplayUser;
    TextView tvDisplayBio;
    TextView tvDisplayCompany;
    TextView tvDisplayLocaiton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplayUser = findViewById(R.id.tvDisplayUser);
        tvDisplayBio = findViewById(R.id.tvDisplayBio);
        tvDisplayCompany = findViewById(R.id.tvDisplayCompany);
        tvDisplayLocaiton = findViewById(R.id.tvDisplayLocation);

        OkHttpClass okHttpClass = new OkHttpClass();
        okHttpClass.getAsyncResponse();
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, RepoResponseActivity.class);
        startActivity(intent);
    }
}
