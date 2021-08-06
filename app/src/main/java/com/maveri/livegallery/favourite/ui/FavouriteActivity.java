package com.maveri.livegallery.favourite.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maveri.livegallery.databinding.ActivityFavouriteBinding;
import com.maveri.livegallery.favourite.presenter.FavouriteGifsPresenter;
import com.maveri.livegallery.favourite.presenter.IFavouriteGifsPresenter;

import java.util.List;

public class FavouriteActivity extends AppCompatActivity implements FavouriteView {

    private ActivityFavouriteBinding binding;
    private IFavouriteGifsPresenter presenter;
    private FavouriteRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavouriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        presenter = new FavouriteGifsPresenter(this, this);
        presenter.getFavouriteGifs();
    }

    @Override
    public void displayFavouriteGifs(List<String> gifs){
        RecyclerView recyclerView = binding.listOfFavouriteGifs;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FavouriteRecyclerViewAdapter(this, gifs);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
}
