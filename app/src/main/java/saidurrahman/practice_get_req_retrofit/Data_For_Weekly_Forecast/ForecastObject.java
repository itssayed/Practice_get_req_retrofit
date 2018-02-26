package saidurrahman.practice_get_req_retrofit.Data_For_Weekly_Forecast;


/**
 * Created by Saidur Rahman on 9/23/2017.
 */

public class ForecastObject {

    private  int dayNumber = 0;
    private  String dayOfTheWeek;
    private  String iconOfTheDaysTemp;
    private  String maximumTemp;
    private  String minimumTemp;

     public ForecastObject(int dayNumber) {
         this.dayNumber = dayNumber;
     }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek){
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getIconOfTheDaysTemp() {
        return iconOfTheDaysTemp;
    }

    public void setIconOfTheDaysTemp(String iconOfTheDaysTemp) {
        this.iconOfTheDaysTemp = iconOfTheDaysTemp;
    }

    public String getMaximumTemp() {
        return maximumTemp;
    }

    public void setMaximumTemp(String maximumTemp) {
        this.maximumTemp = maximumTemp;
    }

    public String getMinimumTemp() {
        return minimumTemp;
    }

    public void setMinimumTemp(String minimumTemp) {
        this.minimumTemp = minimumTemp;
    }
}
