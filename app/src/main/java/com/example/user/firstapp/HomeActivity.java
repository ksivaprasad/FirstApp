package com.example.user.firstapp;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;
    private LinearLayout dotsLayout;
    private int customPostion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.id_img_slider);
        dotsLayout = findViewById(R.id.id_slider_dot);

        viewPageAdapter = new ViewPageAdapter(this);
        viewPager.setAdapter(viewPageAdapter);
        prepareDots(customPostion++);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                prepareDots(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void prepareDots(int customSlidePostion){
        if(dotsLayout.getChildCount() > 0){
            dotsLayout.removeAllViews();
        }
        ImageView dots[] = new ImageView[viewPageAdapter.getCount()];

        for(int i = 0; i < viewPageAdapter.getCount(); i++){
            dots[i] = new ImageView(this);
            if(i == customSlidePostion){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot));
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dot));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(4, 0, 4, 0);
            dotsLayout.addView(dots[i], layoutParams);
        }
    }
}
