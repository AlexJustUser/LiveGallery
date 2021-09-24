package com.maveri.livegallery.favourite.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.maveri.livegallery.R;
import com.maveri.livegallery.api.model.Gif;

import java.util.List;

public class FavouriteRecyclerViewAdapter extends RecyclerView.Adapter<FavouriteRecyclerViewAdapter.ViewHolder> {

    private List<String> data;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    FavouriteRecyclerViewAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void updateData(List<String> data){
        this.data =data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_favourite_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String url = data.get(position);
        Glide
                .with(mInflater.getContext())
                .load(url)
                .into(holder.gif);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView gif;

        ViewHolder(View itemView) {
            super(itemView);
            gif = itemView.findViewById(R.id.gif_favourite_image);
        }

        @Override
        public void onClick(View view) {

        }
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, Gif gifItem);
    }
}