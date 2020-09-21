package com.example.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bean.ImageBean;
import com.example.textview.R;
import com.example.util.PictureUtil;

import java.util.ArrayList;


public class ImageRvAdapter extends RecyclerView.Adapter<ImageRvAdapter.ViewHolder> {
    private static final String TAG = "ImageRvAdapter";
    Context context;
    ArrayList<ImageBean> imageList = new ArrayList<>();
    PictureUtil pictureUtil;

    public ImageRvAdapter(Context context, ArrayList<ImageBean> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ImageRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rv_fg_first, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageRvAdapter.ViewHolder holder, int position) {
        pictureUtil = new PictureUtil();
        holder.title.setText(imageList.get(position).getTitle());
        Log.e(TAG, "onBindViewHolder: " + imageList.get(position).getUrl());
        holder.image.setBackgroundResource(R.drawable.ic_launcher_foreground);
//        pictureUtil.load(holder.image, imageList.get(position).getUrl());
        Glide.with(context).load(imageList.get(position).getUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_im_fg_first);
            title = itemView.findViewById(R.id.item_tv_fg_first_title);
        }
    }
}
