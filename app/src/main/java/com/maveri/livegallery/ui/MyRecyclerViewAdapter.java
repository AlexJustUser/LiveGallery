package com.maveri.livegallery.ui;

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
import com.maveri.livegallery.databinding.RecyclerviewRowBinding;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Gif> data;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    MyRecyclerViewAdapter(Context context, List<Gif> data) {
        this.mInflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void updateData(List<Gif> data){
        this.data =data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String url = data.get(position).getImages().getFixed_height().toString().split(",")[3].substring(5);
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
            itemView.setOnClickListener(this);
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