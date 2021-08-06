package com.maveri.livegallery.main.ui;

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
import com.maveri.livegallery.db.model.GifRealmModel;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Gif> data;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private List<String> favouritesGifsUrls;

    MyRecyclerViewAdapter(Context context, List<Gif> data, List<String> favouritesGifsUrls) {
        this.mInflater = LayoutInflater.from(context);
        this.data = data;
        this.favouritesGifsUrls = favouritesGifsUrls;
    }

    public void updateData(List<Gif> data){
        this.data =data;
    }
    public void updateUrls(String url){
        favouritesGifsUrls.add(url);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String url = data.get(position).getImages().getFixed_height().toString().split(",")[3].substring(5);
        for (String gifUrl: favouritesGifsUrls) {
            if(gifUrl.equals(url)){
                holder.favourite.setImageResource(R.drawable.ic_yellow_star);
                holder.favourite.setClickable(false);
                break;
            }else{
                holder.favourite.setImageResource(R.drawable.ic_dark_star);
                holder.favourite.setClickable(true);
            }
        }

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
        ImageButton favourite;
        ImageView gif;

        ViewHolder(View itemView) {
            super(itemView);
            gif = itemView.findViewById(R.id.gif_image);
            favourite = itemView.findViewById(R.id.favourite_gif);
            favourite.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, data.get(getAdapterPosition()));
        }
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, Gif gifItem);
    }
}