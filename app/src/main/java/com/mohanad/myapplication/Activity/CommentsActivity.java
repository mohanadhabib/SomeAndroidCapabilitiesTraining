package com.mohanad.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.mohanad.myapplication.Adapters.CommentsAdapter;
import com.mohanad.myapplication.ApiService.ApiCalls;
import com.mohanad.myapplication.ApiService.RetrofitService;
import com.mohanad.myapplication.Model.Comments;
import com.mohanad.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        RecyclerView recyclerView = findViewById(R.id.comments_recycler);
        CommentsAdapter adapter = new CommentsAdapter();
        Intent intent = getIntent();
        int postId = intent.getExtras().getInt("PostId");
        ArrayList<Comments> comments = new ArrayList<>();
        ApiCalls calls = RetrofitService.getRetrofit().create(ApiCalls.class);
        calls.getComments().enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                for(Comments comment : response.body()){
                    if(postId == comment.getPostId()){
                        comments.add(comment);
                    }
                }
                adapter.setComments(comments);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}