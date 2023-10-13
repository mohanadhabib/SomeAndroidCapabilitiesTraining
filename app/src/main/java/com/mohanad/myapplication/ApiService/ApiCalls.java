package com.mohanad.myapplication.ApiService;

import com.mohanad.myapplication.Model.Comments;
import com.mohanad.myapplication.Model.Photos;
import com.mohanad.myapplication.Model.Posts;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCalls {
    @GET("posts")
    Call<ArrayList<Posts>> getPosts();
    @GET("comments")
    Call<ArrayList<Comments>> getComments();
    @GET("photos")
    Call<Photos> getPhotos();
}
