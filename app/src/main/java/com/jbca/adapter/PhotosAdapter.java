package com.jbca.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jbca.R;

/**
 * Created by supriyamitra on 20/09/17.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>{

    Context mContext;
    int[] all_photos = new int[]{
            R.drawable.jbca_pic_11,
            R.drawable.jbca_pic_ten,
            R.drawable.jbca_pic_four,
            R.drawable.jbca_pic_eight,
            R.drawable.jbca_pic_seven,
            R.drawable.jbca_pic_six,
            R.drawable.jbca_pic_one,
            R.drawable.jbca_pic_three,
            R.drawable.jbca_pic_two,
            R.drawable.jbca_pic_five,
            R.drawable.jbca_pic_nine,
            R.drawable.jbca_pic_12,
            R.drawable.jbca_pic_13,
            R.drawable.jbca_pic_14,
            R.drawable.jbca_pic_15,
            R.drawable.jbca_pic_16,
            R.drawable.jbca_pic_18};

    public class PhotosViewHolder extends RecyclerView.ViewHolder{
        public ImageView photos;

    public PhotosViewHolder(View view) {
            super(view);
            photos = (ImageView) view.findViewById(R.id.jbca_photos);
        }
    }

    public PhotosAdapter(Context context){
        mContext = context;
    }

    @Override
    public PhotosAdapter.PhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photos_child_layout, parent, false);

        return new PhotosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotosAdapter.PhotosViewHolder holder, int position) {
        Glide.with(mContext).load(all_photos[position]).into(holder.photos);
    }

    @Override
    public int getItemCount() {
        return all_photos.length;
    }
}
