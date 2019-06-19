package com.example.zxy.weather;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    ViewPager vp;
    ViewPagerAdapter vpAdapter;
    List<View> views;
    ImageView[] dots;
    int [] ids=new int[]{R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4};
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initdots();
        vp.addOnPageChangeListener(this);
        btnStart=views.get(3).findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(GuideActivity.this,WeatherActivity.class);
                startActivity(i);
            }
        });
    }
    private void initdots() {
        dots=new ImageView[views.size()];
        for(int i=0;i<views.size();i++){
            dots[i]=findViewById(ids[i]); //ImageView dot1=findViewById(R.id.iv1)
        }


    }


    private void initView() {
        vp=findViewById(R.id.vp);
        LayoutInflater inflater=LayoutInflater.from(this);
        views=new ArrayList<View>();
        views.add(inflater.inflate(R.layout.one,null));
        views.add(inflater.inflate(R.layout.two,null));
        views.add(inflater.inflate(R.layout.three,null));
        views.add(inflater.inflate(R.layout.four,null));
        vpAdapter=new ViewPagerAdapter(views,this);
        vp.setAdapter(vpAdapter);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int k=0;k<ids.length;k++){
            if(k==position){
                dots[k].setImageResource(R.drawable.login_point_selected);
            }else{
                dots[k].setImageResource(R.drawable.login_point);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
