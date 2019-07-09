package com.example.githubmvp_week6day1.view.adapters.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.githubmvp_week6day1.R;
import com.example.githubmvp_week6day1.model.pojos.RepoResponse;

import java.util.List;

public class RepoRecyclerViewAdapter extends RecyclerView.Adapter<RepoRecyclerViewAdapter.ViewHolder>
                        implements RepoRecyclerViewContract{

    List<RepoResponse> repoResponseList;
    RepoRecyclerViewPresenter repoRecyclerViewPresenter;

    public RepoRecyclerViewAdapter(List<RepoResponse> repos){
        this.repoResponseList = repos;
        this.repoRecyclerViewPresenter = new RepoRecyclerViewPresenter();
    }

    @NonNull
    @Override
    public RepoRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.response_repo_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RepoRecyclerViewAdapter.ViewHolder viewHolder, int i) {
        final RepoResponse itemRepo = repoResponseList.get(i);
        final String name = itemRepo.getName();
        final String created = "CREATED AT: " + itemRepo.getCreatedAt();
        final String updated = "UPDATED AT: " + itemRepo.getUpdatedAt();
        final String pushed = "PUSHED AT: " + itemRepo.getPushedAt();
        viewHolder.tvName.setText(name);
        viewHolder.tvCreation.setText(created);
        viewHolder.tvUpdated.setText(updated);
        viewHolder.tvPushed.setText(pushed);
    }

    @Override
    public int getItemCount() {
        return repoResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCreation;
        TextView tvUpdated;
        TextView tvPushed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvDisplayName);
            tvCreation = itemView.findViewById(R.id.tvDisplayCreation);
            tvUpdated = itemView.findViewById(R.id.tvDisplayUpdated);
            tvPushed = itemView.findViewById(R.id.tvDisplayPushed);
        }
    }
}
