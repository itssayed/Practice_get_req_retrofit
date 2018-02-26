package saidurrahman.practice_get_req_retrofit;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import saidurrahman.practice_get_req_retrofit.Data_For_Hourly_Forecast.HourlyRecord;
import saidurrahman.practice_get_req_retrofit.Data_For_Weather_Details.WeatherDetails;
import saidurrahman.practice_get_req_retrofit.Data_For_Weekly_Forecast.ForecastObject;
import saidurrahman.practice_get_req_retrofit.Data_For_Weekly_Forecast.WeatherForecastActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout currentWeatherParentLayout;
    TextView locationTV;
    TextView timeTV;
    TextView countryCodeTV;
    Button   addLocationBtn;
    ImageView weatherLogoIV;
    TextView weatherDescriptionTV;
    TextView maximumTempTV;
    TextView minimumTempTV;
    TextView averageTempTV;


    private  String dayOfTheWeek;


    public static ArrayList<ForecastObject> forecastDayList;
    public static ArrayList<HourlyRecord> hourlyRecords;



    public   String city = "dhaka,bd";
    private  ForecastServiceApi forecastServiceApi;
    private static final String BASE_URL = "https://api.weatherbit.io/v2.0/forecast/";
    private  String urlString;
    private  String urlStringForHourly;




    String weatherImageIV;
    String feelsLikeTV;
    String  humidityTV;
    String  visibilityTV;
    String uvIndexTV;
    String windspdTV;
    String pressureTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentWeatherParentLayout = (LinearLayout) findViewById(R.id.currentWeatherParentLayout);
        locationTV =        (TextView) findViewById(R.id.locationTV);
        timeTV =            (TextView) findViewById(R.id.timeTV);
        countryCodeTV =     (TextView) findViewById(R.id.countryCodeTV);

        addLocationBtn =        (Button) findViewById(R.id.addLocationBtn);
        weatherLogoIV =         (ImageView) findViewById(R.id.weatherLogoIV);
        weatherDescriptionTV =  (TextView) findViewById(R.id.weatherDescriptionTV);
        maximumTempTV =         (TextView) findViewById(R.id.maximumTempTV);
        minimumTempTV =         (TextView) findViewById(R.id.minimumTempTV);
        averageTempTV =         (TextView) findViewById(R.id.averageTempTV);

        libraryInitializer();
        getData();
        getDataHourly();
    }

    private void getDataHourly() {

        urlStringForHourly = String.format("hourly?city=%s&key=%s",city,getResources().getString(R.string.weather_api_key));
        Call<ForecastWeatherResponse> responseCall = forecastServiceApi.getForecastWeatherResponseHourly(urlStringForHourly);

        responseCall.enqueue(new Callback<ForecastWeatherResponse>() {
            @Override
            public void onResponse(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {

                if(response.code() == 200){
                    setDataForHourlyForecast(call,response);
                }
            }

            @Override
            public void onFailure(Call<ForecastWeatherResponse> call, Throwable t) {
                Log.d("url", "onResponse: "+t.getMessage());
            }
        });

    }




    public void showForecastPage(View view) {
        Intent intent = new Intent(this, WeatherForecastActivity.class);
        startActivity(intent);
    }

    private void libraryInitializer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        forecastServiceApi = retrofit.create(ForecastServiceApi.class);
    }


    public void getData() {

        urlString = String.format("daily?city=%s&key=%s",city,getResources().getString(R.string.weather_api_key));

        Call<ForecastWeatherResponse> responseCall = forecastServiceApi.getForecastWeatherResponse(urlString);
        responseCall.enqueue(new Callback<ForecastWeatherResponse>() {

            @Override
            public void onResponse(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {

                if(response.code() == 200){

                    setData(call,response);
                    setDataForWeeklyForecast(call,response);
                    setDataForForecastDetails(call,response);

                }
            }
            @Override
            public void onFailure(Call<ForecastWeatherResponse> call, Throwable t) {
                Log.d("url", "onResponse: "+t.getMessage());
                onRestart();
            }
        });
    }

    private void setDataForForecastDetails(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
        ForecastWeatherResponse forecastWeatherResponse = response.body();

        feelsLikeTV = forecastWeatherResponse.getData().get(0).getAppMaxTemp().toString();
          humidityTV = forecastWeatherResponse.getData().get(0).getRh().toString();
          visibilityTV = forecastWeatherResponse.getData().get(0).getVis().toString();
         uvIndexTV = forecastWeatherResponse.getData().get(0).getUv().toString();
         windspdTV = forecastWeatherResponse.getData().get(0).getWindSpd().toString();
         pressureTV = forecastWeatherResponse.getData().get(0).getPres().toString();
        weatherImageIV = forecastWeatherResponse.getData().get(0).getWeather().getIcon();

    }


    private  void setData(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
        ForecastWeatherResponse forecastWeatherResponse = response.body();



        locationTV.setText(forecastWeatherResponse.getCityName());

        countryCodeTV.setText(forecastWeatherResponse.getCountryCode());
        weatherDescriptionTV.setText(forecastWeatherResponse.getData().get(0).getWeather().getDescription());

        maximumTempTV.setText("Max Temp "+forecastWeatherResponse.getData().get(0).getMaxTemp().toString() + " \u2103");
        minimumTempTV.setText("Min Temp "+forecastWeatherResponse.getData().get(0).getMinTemp().toString() + " \u2103");
        averageTempTV.setText(forecastWeatherResponse.getData().get(0).getTemp().toString() + " \u2103");


        String icon = forecastWeatherResponse.getData().get(0).getWeather().getIcon();
        int img = getResources().getIdentifier(icon, "drawable", getPackageName());
        Drawable drawable = getResources().getDrawable(img);
        weatherLogoIV.setImageDrawable(drawable);



        Date date;
        String datetimeFromApi = forecastWeatherResponse.getData().get(0).getDatetime();

        try {

            date = new SimpleDateFormat("yyyy-MM-dd").parse(datetimeFromApi);

            String dateToView = new SimpleDateFormat("dd-MM-yyyy").format(date);

            dayOfTheWeek = (String) DateFormat.format("EEEE", date); // Thursday
            timeTV.setText(dayOfTheWeek + " " + dateToView);
        }catch (ParseException e) {e.printStackTrace();}


    }

    public void setDataForWeeklyForecast(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
        ForecastWeatherResponse forecastWeatherResponse = response.body();

        forecastDayList = new ArrayList<>();
        forecastDayList.add(new ForecastObject(0));
        forecastDayList.add(new ForecastObject(1));
        forecastDayList.add(new ForecastObject(2));
        forecastDayList.add(new ForecastObject(3));
        forecastDayList.add(new ForecastObject(4));
        forecastDayList.add(new ForecastObject(5));
        forecastDayList.add(new ForecastObject(6));
        forecastDayList.add(new ForecastObject(7));


        for(int k=0; k<8; k++){
            forecastDayList.get(k).setIconOfTheDaysTemp(forecastWeatherResponse.getData().get(k).getWeather().getIcon());
            forecastDayList.get(k).setMaximumTemp(forecastWeatherResponse.getData().get(k).getMaxTemp().toString()+" \u2103");
            forecastDayList.get(k).setMinimumTemp(forecastWeatherResponse.getData().get(k).getMinTemp().toString()+" \u2103");

            Date date;
            String datetimeFromApi = forecastWeatherResponse.getData().get(k).getDatetime();

            try {

                date = new SimpleDateFormat("yyyy-MM-dd").parse(datetimeFromApi);

                String dateToView = new SimpleDateFormat("dd-MM-yyyy").format(date);

                dayOfTheWeek = (String) DateFormat.format("EEEE", date);

                forecastDayList.get(k).setDayOfTheWeek(dayOfTheWeek);
            }catch (ParseException e) {e.printStackTrace();}

        }
    }

    private void setDataForHourlyForecast(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
        ForecastWeatherResponse forecastWeatherResponse = response.body();

        hourlyRecords = new ArrayList<>();
        hourlyRecords.add(new HourlyRecord(0));
        hourlyRecords.add(new HourlyRecord(1));
        hourlyRecords.add(new HourlyRecord(2));
        hourlyRecords.add(new HourlyRecord(3));
        hourlyRecords.add(new HourlyRecord(4));
        hourlyRecords.add(new HourlyRecord(5));
        hourlyRecords.add(new HourlyRecord(6));
        hourlyRecords.add(new HourlyRecord(7));

        for(int k=0; k<8; k++){
            hourlyRecords.get(k).setTemperature(forecastWeatherResponse.getData().get(k).getTemp().toString()+" \u2103");

            hourlyRecords.get(k).setWeatherImgIcon(forecastWeatherResponse.getData().get(k).getWeather().getIcon());




            Date date;
            String datetimeFromApi = forecastWeatherResponse.getData().get(k).getDatetime();

            try {

                date = new SimpleDateFormat("yyyy-MM-dd:HH").parse(datetimeFromApi);

                String TimeToView = new SimpleDateFormat("HH").format(date);



                hourlyRecords.get(k).setTime(TimeToView);
            }catch (ParseException e) {e.printStackTrace();}

        }

    }

    public void goToDetailsPage(View view) {
        Intent intent = new Intent(this, WeatherDetails.class);

        intent.putExtra("weather_icon",weatherImageIV);
        intent.putExtra("feels_like",feelsLikeTV);
        intent.putExtra("humidity",humidityTV);
        intent.putExtra("visibility",visibilityTV);
        intent.putExtra("uv_index",uvIndexTV);
        intent.putExtra("windspd",windspdTV);
        intent.putExtra("pressure",pressureTV);
        startActivity(intent);
    }

    public void changeCity(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter your city name and country code");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                city = input.getText().toString();

                libraryInitializer();
                getData();
                getDataHourly();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();



    }




}
