package saidurrahman.practice_get_req_retrofit.Data_For_Weekly_Forecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

import saidurrahman.practice_get_req_retrofit.Data_For_Hourly_Forecast.HourlyRecord;
import saidurrahman.practice_get_req_retrofit.Data_For_Hourly_Forecast.HourlyRecordAdapter;
import saidurrahman.practice_get_req_retrofit.MainActivity;
import saidurrahman.practice_get_req_retrofit.R;

public class WeatherForecastActivity extends AppCompatActivity {

    ListView forecastLV;

    ArrayList<ForecastObject> forecastDayList;
    ArrayList<HourlyRecord>hourlyRecords;



    //for hourly record>>>>>
    RecyclerView hourlyReportRV;
    HourlyRecordAdapter hourlyRecordAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);

        getIntent();

        forecastDayList = MainActivity.forecastDayList;
        hourlyRecords = MainActivity.hourlyRecords;

        //for hourly record>>>>>
        forecastLV = (ListView) findViewById(R.id.weahterForecastLV);
        hourlyReportRV = (RecyclerView) findViewById(R.id.hourlyReportRV);



        WeatherForecastAdapter weatherForecastAdapter  = new WeatherForecastAdapter(this,forecastDayList);
        forecastLV.setAdapter(weatherForecastAdapter);




        //for hourly record>>>>>
        hourlyRecordAdapter = new HourlyRecordAdapter(this, hourlyRecords);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        hourlyReportRV.setLayoutManager(llm);
        hourlyReportRV.setAdapter(hourlyRecordAdapter);




    }
}
