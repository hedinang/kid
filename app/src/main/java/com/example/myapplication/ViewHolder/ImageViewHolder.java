package com.example.myapplication.ViewHolder;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Interface.ImageOnClick;
import com.example.myapplication.R;

import lombok.NonNull;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public ImageOnClick imageOnClick;

    public void setImageOnClick(ImageOnClick imageOnClick) {
        this.imageOnClick = imageOnClick;
    }

    public ImageViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_outline);
        itemView.setOnClickListener(v -> {
            imageOnClick.onClick(getAdapterPosition());
        });
    }
}
