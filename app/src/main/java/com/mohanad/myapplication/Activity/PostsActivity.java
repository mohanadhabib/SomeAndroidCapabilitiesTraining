package com.mohanad.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.mohanad.myapplication.Adapters.PostsAdapter;
import com.mohanad.myapplication.ApiService.ApiCalls;
import com.mohanad.myapplication.ApiService.RetrofitService;
import com.mohanad.myapplication.Model.Posts;
import com.mohanad.myapplication.R;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        RecyclerView recyclerView = findViewById(R.id.posts_recycler);
        PostsAdapter adapter = new PostsAdapter();
        ArrayList<Posts> posts = new ArrayList<>();
        ApiCalls calls = RetrofitService.getRetrofit().create(ApiCalls.class);
        calls.getPosts().enqueue(new Callback<ArrayList<Posts>>() {
            @Override
            public void onResponse(Call<ArrayList<Posts>> call, Response<ArrayList<Posts>> response) {
                for (Posts post : response.body()){
                    posts.add(post);
                }
                adapter.setPosts(posts);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
            @Override
            public void onFailure(Call<ArrayList<Posts>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}