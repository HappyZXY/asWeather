package com.example.zxy.weather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WeatherActivity extends AppCompatActivity {
    TextView tv1,tv2,tvCar,tvDress,tvHot,tvBlood,tvSick,tvPollute;
    ImageView iv1;
    LinearLayout layout01;
    Elements elements;
    Elements elements1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        init();
        String url="http://www.weather.com.cn/weather/101240701.shtml";
        new AsyncTask<String,Void,Boolean>(){

            @Override
            protected Boolean doInBackground(String... strings) {
                try {
                    String url0=strings[0];
                    Document document=Jsoup.connect(url0).get();
                    elements=document.getElementsByTag("p");
                    elements1=document.getElementsByTag("span");
                    return true;


                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                tv1.setText(elements.get(3).text());
                tv2.setText(elements.get(4).text());
                System.out.println("elements.get(0)="+elements.get(0).text());
                System.out.println("elements.get(0)="+elements.get(1).text());
                System.out.println("elements.get(0)="+elements.get(2).text());
                System.out.println("elements.get(0)="+elements.get(3).text());
                System.out.println("elements.get(0)="+elements.get(4).text());

                String str=elements.get(3).text();
                if (str.equals("晴")){
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.sun));
                    layout01.setBackgroundResource(R.drawable.sun1);
                }
                if (str.equals("阴")){
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.overcast));
                    layout01.setBackgroundResource(R.drawable.overcast1);
                }
                if (str.equals("雨")){
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.rain));
                    layout01.setBackgroundResource(R.drawable.rain1);
                }
                if (str.equals("多云")){
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.cloud));
                    layout01.setBackgroundResource(R.drawable.cloud1);
                }

                tvCar.setText(elements1.get(38).text());
                tvDress.setText(elements1.get(37).text());
                tvHot.setText(elements1.get(34).text());
                tvBlood.setText(elements1.get(35).text());
                tvSick.setText(elements1.get(36).text());
                tvPollute.setText(elements1.get(39).text());

                for(int i=0;i<40;i++){
                    System.out.println("elements.get()"+elements1.get(i).text());
                }

            }
        }.execute(url);
    }

    private void init() {
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        layout01=findViewById(R.id.layout01);
        iv1=findViewById(R.id.iv1);
        tvCar=findViewById(R.id.tvCar);
        tvBlood=findViewById(R.id.tvBlood);
        tvDress=findViewById(R.id.tvDress);
        tvHot=findViewById(R.id.tvHot);
        tvPollute=findViewById(R.id.tvPollute);
        tvSick=findViewById(R.id.tvSick);
    }
}
