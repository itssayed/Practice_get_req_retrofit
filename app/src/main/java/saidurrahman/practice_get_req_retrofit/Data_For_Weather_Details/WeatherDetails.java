package saidurrahman.practice_get_req_retrofit.Data_For_Weather_Details;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import saidurrahman.practice_get_req_retrofit.R;

public class WeatherDetails extends AppCompatActivity {

    ImageView weatherImageIV;
    TextView feelsLikeTV;
    TextView  humidityTV;
    TextView  visibilityTV;
    TextView uvIndexTV;
    TextView windspdTV;
    TextView pressureTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);


         weatherImageIV = (ImageView) findViewById(R.id.weatherImageIV);
        feelsLikeTV = (TextView) findViewById(R.id.feelsLikeTV);
         humidityTV = (TextView) findViewById(R.id.humidityTV);
         visibilityTV = (TextView) findViewById(R.id.visibilityTV);
         uvIndexTV = (TextView) findViewById(R.id.uvIndexTV);
         windspdTV = (TextView) findViewById(R.id.windspdTV);
         pressureTV = (TextView) findViewById(R.id.pressureTV);


        feelsLikeTV.setText("Feels like     "+getIntent().getStringExtra("feels_like"));
        humidityTV.setText("Humidity     "+getIntent().getStringExtra("humidity"));
        visibilityTV.setText("Visibility     "+getIntent().getStringExtra("visibility"));
        uvIndexTV.setText("UV Index     "+getIntent().getStringExtra("uv_index"));
        windspdTV.setText("Wind Speed     "+getIntent().getStringExtra("windspd"));
        pressureTV.setText("Pressure     "+getIntent().getStringExtra("pressure"));



        String icon = getIntent().getStringExtra("weather_icon");
        int img = getResources().getIdentifier(icon, "drawable", getPackageName());
        Drawable drawable = getResources().getDrawable(img);
        weatherImageIV.setImageDrawable(drawable);
    }











}

