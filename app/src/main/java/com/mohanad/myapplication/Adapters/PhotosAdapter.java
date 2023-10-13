package com.mohanad.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohanad.myapplication.Model.Photo;
import com.mohanad.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosHolder> {
    private ArrayList<Photo> photos = new ArrayList<>();
    public void setPhotos(ArrayList<Photo> photos){
        this.photos = photos;
    }
    @NonNull
    @Override
    public PhotosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photos_item,parent,false);
        return new PhotosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosHolder holder, int position) {
        holder.title.setText(photos.get(position).getTitle());
        holder.description.setText(photos.get(position).getDescription());
        Picasso.get().load(photos.get(position).getUrl()).into(holder.image);
    }
    @Override
    public int getItemCount() {
        return photos.size();
    }

    static class PhotosHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView description;
        public ImageView image ;
        public PhotosHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            image = itemView.findViewById(R.id.image);
        }
    }
}
