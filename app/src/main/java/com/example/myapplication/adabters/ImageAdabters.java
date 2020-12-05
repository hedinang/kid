package com.example.myapplication.adabters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.PaintActivity;
import com.example.myapplication.R;
import com.example.myapplication.ViewHolder.ImageViewHolder;
import com.example.myapplication.common.Common;

import java.util.ArrayList;
import java.util.List;

public class ImageAdabters extends RecyclerView.Adapter<ImageViewHolder> {

    Context mContext;
    List<Integer> listImages;

    public ImageAdabters(Context mContext) {
        this.mContext = mContext;
        this.listImages = getImages();
    }


    private List<Integer> getImages() {
        List<Integer> results = new ArrayList<>();
        results.add(R.drawable.a);
        results.add(R.drawable.b);
        return results;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_images, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(listImages.get(position));
        holder.setImageOnClick(pos -> {
            Common.PICTURE_SELECT = listImages.get(pos);
            mContext.startActivity(new Intent(mContext, PaintActivity.class));
        });
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

}