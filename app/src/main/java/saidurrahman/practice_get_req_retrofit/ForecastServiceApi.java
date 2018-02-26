package saidurrahman.practice_get_req_retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Saidur Rahman on 9/19/2017.
 */

public interface ForecastServiceApi {

    @GET()
    Call<ForecastWeatherResponse> getForecastWeatherResponse(@Url String stringUrl);


    @GET()
    Call<ForecastWeatherResponse> getForecastWeatherResponseHourly(@Url String stringUrl);




}
