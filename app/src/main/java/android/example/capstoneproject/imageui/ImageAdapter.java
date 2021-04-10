package android.example.capstoneproject.imageui;

import android.example.capstoneproject.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.*;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private ArrayList<Images> imagesArrayList = new ArrayList<>();

    public ImageAdapter(ArrayList<Images> mImages) {
        this.imagesArrayList = mImages;
    }

    @NonNull
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageViewHolder holder, int position) {

        Images images = imagesArrayList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(images.getUrl())
                .fitCenter()
                .into(holder.mImage);
        holder.mCode.setText(images.getCode());

    }

    @Override
    public int getItemCount() {
        return imagesArrayList.size();
    }

    public static class ImageViewHolder extends ViewHolder {

        ImageView mImage;
        TextView mCode;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.iv_image_fragment);
            mCode = itemView.findViewById(R.id.tv_image_fragment);
        }
    }
}
