package com.example.githubmvp_week6day1.view.activities.reporesponseactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.githubmvp_week6day1.R;
import com.example.githubmvp_week6day1.model.datasource.local.pojos.RepoResponse;
import com.example.githubmvp_week6day1.model.remote.OkHttpClass;
import com.example.githubmvp_week6day1.view.adapters.recyclerview.RepoRecyclerViewAdapter;
import com.example.githubmvp_week6day1.view.adapters.recyclerview.RepoRecyclerViewPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class RepoResponseActivity extends AppCompatActivity {

    RepoResponsePresenter repoResponsePresenter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_response);
        recyclerView = findViewById(R.id.rvRecyclerView);
        OkHttpClass okHttpClass = new OkHttpClass();
        okHttpClass.getRepoAsyncResponse();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void populateRandomRecyclerView(List<RepoResponse> repoResponse) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RepoRecyclerViewAdapter recyclerViewAdapter = new RepoRecyclerViewAdapter(repoResponse);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
//        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
//                DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void randomUserEvent(List<RepoResponse> event) {
        populateRandomRecyclerView(event);
    }
}