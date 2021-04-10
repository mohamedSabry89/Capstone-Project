package android.example.capstoneproject.imageui;

import android.example.capstoneproject.R;
import android.example.capstoneproject.viewmodel.ImagesViewModel;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentImages extends Fragment {

    private static final String TAG = "FragmentImages";
    ImageAdapter imageAdapter;
    RecyclerView recyclerView;

    public FragmentImages() {
        //empty constructor needed
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_images, container, false);

        recyclerView = view.findViewById(R.id.rv_image_fragment);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        ImagesViewModel viewModel = ViewModelProviders.of(this).get(ImagesViewModel.class);
        viewModel.init();
        viewModel.getLiveData().observe(this.getActivity(), images -> {
            recyclerView.setAdapter(imageAdapter);
        });
        imageAdapter = new ImageAdapter(viewModel.getLiveData().getValue());
        recyclerView.setAdapter(imageAdapter);

        return view;
    }
}
