package saidurrahman.practice_get_req_retrofit.Data_For_Hourly_Forecast;

/**
 * Created by nurud on 9/22/2017.
 */

public class HourlyRecord {
    private int elementNumber= 0;
    private String weatherImgIcon;
    private String time;
    private String temperature;

    public HourlyRecord(String  weatherImgIcon, String time, String temperature) {
        this.weatherImgIcon = weatherImgIcon;
        this.time = time;
        this.temperature = temperature;
    }

    public HourlyRecord(int elementNumber) {
        this.elementNumber = elementNumber;
    }

    public void setWeatherImgIcon(String weatherImgIcon) {
        this.weatherImgIcon = weatherImgIcon;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherImgIcon() {
        return weatherImgIcon;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }
}
