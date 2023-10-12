package com.mohanad.myapplication.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mohanad.myapplication.Activity.CommentsActivity;
import com.mohanad.myapplication.Model.Posts;
import com.mohanad.myapplication.R;
import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsHolder> {
    private ArrayList<Posts> posts = new ArrayList<>();
    public void setPosts(ArrayList<Posts> posts){
        this.posts = posts;
    }
    @NonNull
    @Override
    public PostsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_item,parent,false);
        return new PostsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsHolder holder, int position) {
        holder.text.setText(posts.get(position).getBody());
        holder.text.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CommentsActivity.class);
            intent.putExtra("PostId",posts.get(holder.getAdapterPosition()).getId());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class PostsHolder extends RecyclerView.ViewHolder{
        public TextView text;
        public PostsHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}
