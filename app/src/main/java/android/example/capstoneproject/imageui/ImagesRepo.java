package android.example.capstoneproject.imageui;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ImagesRepo {

    private static ImagesRepo instance;
    private ArrayList<Images> imagesArrayList = new ArrayList<>();
    private MutableLiveData<ArrayList<Images>> mutableLiveData = new MutableLiveData<>();

    public static ImagesRepo getInstance() {
        if (instance == null) {
            instance = new ImagesRepo();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Images>> getImages() {
        if (imagesArrayList.size() == 0) {
            LoadImages();
        }
        mutableLiveData.setValue(imagesArrayList);
        return mutableLiveData;
    }

    private void LoadImages() {

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
        Query query = myRef.child("425 SHD");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Images images = ds.getValue(Images.class);
                    imagesArrayList.add(images);
                }
                mutableLiveData.postValue(imagesArrayList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }

        });


    }


}
