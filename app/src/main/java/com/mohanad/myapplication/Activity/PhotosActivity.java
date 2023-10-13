package com.mohanad.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.mohanad.myapplication.Adapter.PhotosAdapter;
import com.mohanad.myapplication.ApiService.ApiCalls;
import com.mohanad.myapplication.ApiService.RetrofitServiceForImage;
import com.mohanad.myapplication.Model.Photo;
import com.mohanad.myapplication.Model.Photos;
import com.mohanad.myapplication.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        ArrayList<Photo> photos = new ArrayList<>();
        PhotosAdapter adapter = new PhotosAdapter();
        RecyclerView recyclerView = findViewById(R.id.photos_recycler);
        ApiCalls calls = RetrofitServiceForImage.getRetrofit().create(ApiCalls.class);
        calls.getPhotos().enqueue(new Callback<Photos>() {
            @Override
            public void onResponse(Call<Photos> call, Response<Photos> response) {
                photos.addAll(response.body().getPhotos());
                adapter.setPhotos(photos);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
            @Override
            public void onFailure(Call<Photos> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}