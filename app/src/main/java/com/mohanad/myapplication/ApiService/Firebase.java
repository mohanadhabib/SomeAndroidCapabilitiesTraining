package com.mohanad.myapplication.ApiService;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class Firebase {
    private static FirebaseAuth auth;
    private static FirebaseStorage storage;
    private static FirebaseFirestore firestore;
    public static FirebaseAuth getAuth(){
        if(auth == null){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }
    public static FirebaseStorage getStorage(){
        if(storage == null){
            storage = FirebaseStorage.getInstance();
        }
        return storage;
    }
    public static FirebaseFirestore getFirestore(){
        if(firestore == null){
            firestore = FirebaseFirestore.getInstance();
        }
        return firestore;
    }
}
