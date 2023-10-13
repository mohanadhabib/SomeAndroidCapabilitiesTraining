package com.mohanad.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.mohanad.myapplication.ApiService.Firebase;
import com.mohanad.myapplication.Model.User;
import com.mohanad.myapplication.R;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText email = view.findViewById(R.id.email);
        EditText password = view.findViewById(R.id.password);
        ImageView imageView = view.findViewById(R.id.profile_image);
        MaterialButton button = view.findViewById(R.id.submit);
        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            imageView.setImageURI(result.getData().getData());
            imageView.setBackground(null);
            Firebase.getStorage().getReference().child("image").putFile(result.getData().getData());
        });
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            launcher.launch(intent);
        });
        button.setOnClickListener(v -> {
            String emailTxt = email.getText().toString();
            String passwordTxt = password.getText().toString();
            signUp(emailTxt,passwordTxt);
        });
    }

    private void signUp(String email,String password){
        Firebase.getAuth().createUserWithEmailAndPassword(email,password).addOnSuccessListener(
                e ->{
                    String id = e.getUser().getUid();
                    storeData(id,email,password);
                }
        ).addOnFailureListener(
                e -> Toast.makeText(getActivity().getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show()
        );
    }
    private void storeData(String id, String email, String password){
        Firebase.getStorage().getReference().child("image").getDownloadUrl()
                .addOnSuccessListener(uri -> {
                    User user = new User(id,email,password,uri.toString());
                    Firebase.getFirestore().collection("Users").document(id).set(user)
                            .addOnSuccessListener(unused -> Toast.makeText(getActivity().getApplicationContext(),"Sign Up Done",Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(getActivity().getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show());
                })
                .addOnFailureListener(e -> Toast.makeText(getActivity().getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show());
    }
}
