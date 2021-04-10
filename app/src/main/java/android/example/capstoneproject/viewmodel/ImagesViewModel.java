package android.example.capstoneproject.viewmodel;

import android.content.Entity;
import android.example.capstoneproject.imageui.Images;
import android.example.capstoneproject.imageui.ImagesRepo;
import android.graphics.ColorSpace;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.load.model.Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ImagesViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Images>> imagesMutableLiveData;

    public void init() {
        if (imagesMutableLiveData != null) {
            return;
        }
        imagesMutableLiveData = ImagesRepo.getInstance().getImages();
    }

    public LiveData<ArrayList<Images>> getLiveData() {
        return imagesMutableLiveData;
    }

}
