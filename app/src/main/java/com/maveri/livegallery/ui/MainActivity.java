package com.maveri.livegallery.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.maveri.livegallery.R;
import com.maveri.livegallery.api.model.Gif;
import com.maveri.livegallery.api.model.GifResponse;
import com.maveri.livegallery.databinding.ActivityMainBinding;
import com.maveri.livegallery.db.DBService;
import com.maveri.livegallery.db.model.GifRealmModel;
import com.maveri.livegallery.presenter.GifPresenter;
import com.maveri.livegallery.presenter.IGifPresenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements MainView, MyRecyclerViewAdapter.ItemClickListener{

    private ActivityMainBinding binding;
    private IGifPresenter presenter;
    private EndlessRecyclerViewScrollListener scrollListener;
    private MyRecyclerViewAdapter adapter;
    private DBService dBservise;
    private GifRealmModel gifRealmModel;
    private boolean search=false;
    private List<Gif> gifs = new ArrayList();

    private static final int DEFAULT_OFFSET = 0;
    private static final String DEFAULT_RAITING = "g";
    private static final String DEFAULT_LANG = "ru";
    private static final String DEFAULT_ID = "e826c9fc5c929e0d6c6d423841a282aa";
    private static final int DEFAULT_LIMIT = 10;

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

        Realm.init(this);
        dBservise = new DBService();

        presenter = new GifPresenter(this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.listOfGifs.setLayoutManager(linearLayoutManager);

        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadNextDataFromApi(page, search);
            }
        };
        binding.listOfGifs.addOnScrollListener(scrollListener);

        binding.favouriteMenuButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        getDefaultGifs(DEFAULT_OFFSET);

        binding.gifSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (binding.gifSearch.getRight() - binding.gifSearch.getCompoundDrawables()[2].getBounds().width())) {
                        if(!search) {
                            if (!binding.gifSearch.getText().toString().trim().equals("")) {
                                getSearchGifs(DEFAULT_OFFSET, binding.gifSearch.getText().toString());
                                hideSoftKeyboard();
                                search = true;
                                binding.gifSearch.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_cross, 0);
                            }
                        }else{
                            search=false;
                            binding.gifSearch.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_search, 0);
                            binding.gifSearch.setText("");
                            getDefaultGifs(DEFAULT_OFFSET);
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public void loadNextDataFromApi(int offsetNum, boolean search) {
        if(search){
            getSearchGifs(offsetNum, binding.gifSearch.getText().toString());
        }else {
            getDefaultGifs(offsetNum);
        }
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager =
                (InputMethodManager) this.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    this.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }

    @Override
    public void displayMapsList(GifResponse gifResponse) {
        if(gifResponse.getPagination().getOffset()==0){
            gifs.clear();
            gifs.addAll(Arrays.asList(gifResponse.getData()));
            adapter = new MyRecyclerViewAdapter(this, gifs);
            adapter.setClickListener(this::onItemClick);
            binding.listOfGifs.setAdapter(adapter);
        }
        else{
            gifs.addAll(Arrays.asList(gifResponse.getData()));
            adapter.notifyItemInserted(gifs.size()-Arrays.asList(gifResponse.getData()).size());
        }
    }

    @Override
    public void onItemClick(View view, Gif gifItem) {

        gifRealmModel = new GifRealmModel();
        //gifRealmModel.setGifUrl(gifItem.getImages().getFixed_height().toString().split(",")[3].substring(5));
        gifRealmModel.setGif(gifItem);

        dBservise.save(gifRealmModel, GifRealmModel.class)
                .subscribe(taskRealModel1 -> {
                    Toast.makeText(getBaseContext(),"Сохранено в бд",Toast.LENGTH_SHORT).show();
                });
    }

    public void getSearchGifs(int offset, String searchWord){
        presenter.getSearchGifs("SVBkGciuiJJucO12lztv14fJ7lIdcGJ8", searchWord, DEFAULT_LIMIT, offset, DEFAULT_RAITING, DEFAULT_LANG, DEFAULT_ID);
    }

    public void getDefaultGifs(int offset){
        presenter.getDefaultGifs("SVBkGciuiJJucO12lztv14fJ7lIdcGJ8", DEFAULT_LIMIT, offset, DEFAULT_RAITING, DEFAULT_ID);
    }

}