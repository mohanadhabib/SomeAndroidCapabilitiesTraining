package com.mohanad.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohanad.myapplication.Model.Comments;
import com.mohanad.myapplication.R;
import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsHolder> {

    private ArrayList<Comments> comments = new ArrayList<>();

    public void setComments(ArrayList<Comments> comments){
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_item,parent,false);
        return new CommentsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsHolder holder, int position) {
        holder.email.setText(comments.get(position).getEmail());
        holder.body.setText(comments.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    static class CommentsHolder extends RecyclerView.ViewHolder {
        public TextView email ;
        public TextView body;
        public CommentsHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);
        }
    }
}
