package saidurrahman.practice_get_req_retrofit.Data_For_Hourly_Forecast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import saidurrahman.practice_get_req_retrofit.R;

import static saidurrahman.practice_get_req_retrofit.MainActivity.forecastDayList;

/**
 * Created by nurud on 9/22/2017.
 */

public class HourlyRecordAdapter extends RecyclerView.Adapter<HourlyRecordAdapter.HourlyRecordHolder>{

    private Context context;
    private ArrayList<HourlyRecord> hourlyRecords;
    Drawable drawable;

    public HourlyRecordAdapter(Context context, ArrayList<HourlyRecord> hourlyRecords) {
        this.context = context;
        this.hourlyRecords = hourlyRecords;
    }

    @Override
    public HourlyRecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.hourly_record_row, parent, false);

        HourlyRecordHolder hourlyRecordHolder = new HourlyRecordHolder(v);
        return hourlyRecordHolder;
    }

    @Override
    public void onBindViewHolder(HourlyRecordHolder holder, int position) {
        holder.timeTV.setText(hourlyRecords.get(position).getTime());
        holder.temperatureTV.setText(hourlyRecords.get(position).getTemperature());




        String icon = hourlyRecords.get(position).getWeatherImgIcon();
        int img = context.getResources().getIdentifier(icon, "drawable", context.getPackageName());
        drawable = context.getResources().getDrawable(img);

        holder.iconIV.setImageDrawable(drawable);

    }

    @Override
    public int getItemCount() {
        return hourlyRecords.size();

    }


    //Holder for Adapter
    public class HourlyRecordHolder extends RecyclerView.ViewHolder{

        TextView timeTV, temperatureTV;
        ImageView iconIV;

        public HourlyRecordHolder(View itemView) {
            super(itemView);

            timeTV= (TextView) itemView.findViewById(R.id.hourlyTimeTV);
            temperatureTV= (TextView) itemView.findViewById(R.id.hourlyTemperatureTV);
            iconIV= (ImageView) itemView.findViewById(R.id.hourlyIconIV);




        }
    }



}
