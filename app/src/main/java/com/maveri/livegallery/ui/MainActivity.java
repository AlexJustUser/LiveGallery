package com.maveri.livegallery.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.maveri.livegallery.api.model.GifResponse;
import com.maveri.livegallery.databinding.ActivityMainBinding;
import com.maveri.livegallery.presenter.GifPresenter;
import com.maveri.livegallery.presenter.IGifPresenter;

public class MainActivity extends AppCompatActivity implements MainView{

    private ActivityMainBinding binding;
    private IGifPresenter presenter;

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
        presenter.getDefaultGifs("SVBkGciuiJJucO12lztv14fJ7lIdcGJ8", 20, 5, "g", "e826c9fc5c929e0d6c6d423841a282aa");
    }

    @Override
    public void displayMapsList(GifResponse gifResponse) {

    }
}