package com.example.zxy.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    GridView gv;
    ImageSwitcher is;
    int [] imageIds=new int[]{R.drawable.guide_a,R.drawable.guide_a,R.drawable.guide_a,R.drawable.guide_a};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gv=findViewById(R.id.gv);
        is=findViewById(R.id.is);
        List<Map<String,Object>> listItems =new ArrayList<Map<String, Object>>();
        for(int i=0;i<imageIds.length;i++){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("image",imageIds[i]);
            listItems.add(item);
        }
        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView iv=new ImageView(HomeActivity.this);
                iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                iv.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT

                ));
                return iv;
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                is.setImageResource(imageIds[i]);

            }
        });
        gv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                is.setImageResource(imageIds[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,
                R.layout.cell,new String[]{"image"},new int[]{R.id.image1});

        gv.setAdapter(simpleAdapter);


    }
}
