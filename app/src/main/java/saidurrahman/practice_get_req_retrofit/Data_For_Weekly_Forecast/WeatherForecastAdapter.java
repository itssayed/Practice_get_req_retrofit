package saidurrahman.practice_get_req_retrofit.Data_For_Weekly_Forecast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import saidurrahman.practice_get_req_retrofit.R;

/**
 * Created by Saidur Rahman on 9/23/2017.
 */

public class WeatherForecastAdapter extends ArrayAdapter<ForecastObject> {


    private Context context;
    private ArrayList<ForecastObject> forecastDayList;
    Drawable drawable;


    public WeatherForecastAdapter(@NonNull Context context, @NonNull ArrayList<ForecastObject> forecastDayList) {
        super(context, R.layout.weekly_record_row, forecastDayList);
        this.context = context;
        this.forecastDayList = forecastDayList;
    }


    private class ViewHolder{
        TextView weeklyDayNameTV;
        ImageView weaklyIconIV;
        TextView weeklyHighTemperatureTV;
        TextView weeklyLowTemperatureTV;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){


            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.weekly_record_row,parent,false);

            viewHolder = new ViewHolder();

            viewHolder.weeklyDayNameTV = (TextView) convertView.findViewById(R.id.weaklyDayNameTV);
            viewHolder.weaklyIconIV = (ImageView) convertView.findViewById(R.id.weaklyIconIV);
            viewHolder.weeklyHighTemperatureTV = (TextView) convertView.findViewById(R.id.weaklyHighTemperatureTV);
            viewHolder.weeklyLowTemperatureTV = (TextView) convertView.findViewById(R.id.weaklyLowTemperatureTV);


            String icon = forecastDayList.get(position).getIconOfTheDaysTemp();
            int img = context.getResources().getIdentifier(icon, "drawable", context.getPackageName());
            drawable = context.getResources().getDrawable(img);





            convertView.setTag(viewHolder);

        }

        else {

            viewHolder = (ViewHolder) convertView.getTag();

        }


        viewHolder.weeklyDayNameTV.setText(forecastDayList.get(position).getDayOfTheWeek());

        viewHolder.weeklyHighTemperatureTV.setText(forecastDayList.get(position).getMaximumTemp());
        viewHolder.weeklyLowTemperatureTV.setText(forecastDayList.get(position).getMinimumTemp());
        viewHolder.weaklyIconIV.setImageDrawable(drawable);









        return convertView;
    }







}
