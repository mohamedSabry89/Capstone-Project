package android.example.capstoneproject;

import android.example.capstoneproject.R;
import android.example.capstoneproject.imageui.Images;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentBranches extends Fragment {

    Images images;
    public FragmentBranches() {
        //empty constructor needed
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_branches, container, false);
        final TextView textView = root.findViewById(R.id.branch_text);
        //textView.setText(images.getCode());

        return root;
    }

}
