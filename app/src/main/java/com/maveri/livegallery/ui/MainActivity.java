package com.maveri.livegallery.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.maveri.livegallery.api.model.Gif;
import com.maveri.livegallery.api.model.GifResponse;
import com.maveri.livegallery.databinding.ActivityMainBinding;
import com.maveri.livegallery.presenter.GifPresenter;
import com.maveri.livegallery.presenter.IGifPresenter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, MyRecyclerViewAdapter.ItemClickListener{

    private ActivityMainBinding binding;
    private IGifPresenter presenter;
    private EndlessRecyclerViewScrollListener scrollListener;
    private MyRecyclerViewAdapter adapter;

    private static final int DEFAULT_PAGE_NUMBER  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init(){

        presenter = new GifPresenter(this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.listOfGifs.setLayoutManager(linearLayoutManager);

        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadNextDataFromApi(++page);
            }
        };
        binding.listOfGifs.addOnScrollListener(scrollListener);

        presenter.getDefaultGifs("SVBkGciuiJJucO12lztv14fJ7lIdcGJ8", 10, DEFAULT_PAGE_NUMBER, "g", "e826c9fc5c929e0d6c6d423841a282aa");

        binding.gifSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (binding.gifSearch.getRight() - binding.gifSearch.getCompoundDrawables()[2].getBounds().width())) {

                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void loadNextDataFromApi(int pageNum) {
        presenter.getDefaultGifs("SVBkGciuiJJucO12lztv14fJ7lIdcGJ8", 10, pageNum, "g", "e826c9fc5c929e0d6c6d423841a282aa");
    }

    @Override
    public void displayMapsList(GifResponse gifResponse) {
        //if(dataResponse.getPage().equals("1")){
            //mapsList = dataResponse.getData();
            List<Gif> gifs = Arrays.asList(gifResponse.getData());
            adapter = new MyRecyclerViewAdapter(this, gifs);
            adapter.setClickListener(this);
            try {
                binding.listOfGifs.setAdapter(adapter);
            }catch (Exception e){
                e.printStackTrace();
            }

//        }
//        else{
//            for(MapResponse map: dataResponse.getData()){
//                mapsList.add(map);
//            }
//            adapter.updateData(mapsList);
//            adapter.notifyItemInserted(mapsList.size()-dataResponse.getData().size());
//        }
    }

    @Override
    public void onItemClick(View view, Gif gifItem) {

    }
}