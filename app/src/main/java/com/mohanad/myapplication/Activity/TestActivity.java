package com.mohanad.myapplication.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import com.google.android.material.button.MaterialButton;
import com.mohanad.myapplication.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        MaterialButton sendEmail = findViewById(R.id.send_email);
        MaterialButton takePhoto = findViewById(R.id.take_photo);
        MaterialButton pickPhoto = findViewById(R.id.pick_photo);
        MaterialButton goToPosts = findViewById(R.id.go_to_posts);
        MaterialButton goToPhotos = findViewById(R.id.go_to_photos);
        ImageView image = findViewById(R.id.image);
        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> image.setImageURI(result.getData().getData()));
        ActivityResultLauncher<Intent> capture = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
            image.setImageBitmap(bitmap);
        });
        sendEmail.setOnClickListener(v -> { 
            Intent i = new Intent(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_EMAIL,new String[]{"1234@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT,"Testing of Sending Email");
            i.putExtra(Intent.EXTRA_TEXT,"Hello from first email");
            i.setType("message/rfc822");
            startActivity(i);
        });
        takePhoto.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            capture.launch(intent);
        });
        pickPhoto.setOnClickListener(v -> {
            // another method :
            // Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            launcher.launch(intent);
        });
        goToPosts.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PostsActivity.class);
            startActivity(intent);
        });
        goToPhotos.setOnClickListener(v ->{
            Intent intent = new Intent(getApplicationContext(), PhotosActivity.class);
            startActivity(intent);
        });
    }
}