
package saidurrahman.practice_get_req_retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("wind_cdir")
    @Expose
    private String windCdir;

    @SerializedName("rh")
    @Expose
    private Double rh;

    @SerializedName("wind_spd")
    @Expose
    private Double windSpd;

    @SerializedName("pop")
    @Expose
    private Integer pop;

    @SerializedName("wind_cdir_full")
    @Expose
    private String windCdirFull;

    @SerializedName("slp")
    @Expose
    private Double slp;

    @SerializedName("app_max_temp")
    @Expose
    private Double appMaxTemp;

    @SerializedName("pres")
    @Expose
    private Double pres;

    @SerializedName("dewpt")
    @Expose
    private Double dewpt;

    @SerializedName("snow")
    @Expose
    private Integer snow;

    @SerializedName("uv")
    @Expose
    private Integer uv;

    @SerializedName("wind_dir")
    @Expose
    private Integer windDir;

    @SerializedName("weather")
    @Expose
    private Weather weather;

    @SerializedName("ts")
    @Expose
    private Double ts;

    @SerializedName("max_temp")
    @Expose
    private Double maxTemp;

    @SerializedName("app_min_temp")
    @Expose
    private Double appMinTemp;

    @SerializedName("precip")
    @Expose
    private Double precip;

    @SerializedName("max_dhi")
    @Expose
    private Double maxDhi;

    @SerializedName("datetime")
    @Expose
    private String datetime;

    @SerializedName("temp")
    @Expose
    private Double temp;

    @SerializedName("min_temp")
    @Expose
    private Double minTemp;

    @SerializedName("clouds")
    @Expose
    private Integer clouds;

    @SerializedName("vis")
    @Expose
    private Integer vis;

    public String getWindCdir() {
        return windCdir;
    }

    public void setWindCdir(String windCdir) {
        this.windCdir = windCdir;
    }

    public Double getRh() {
        return rh;
    }

    public void setRh(Double rh) {
        this.rh = rh;
    }

    public Double getWindSpd() {
        return windSpd;
    }

    public void setWindSpd(Double windSpd) {
        this.windSpd = windSpd;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    public String getWindCdirFull() {
        return windCdirFull;
    }

    public void setWindCdirFull(String windCdirFull) {
        this.windCdirFull = windCdirFull;
    }

    public Double getSlp() {
        return slp;
    }

    public void setSlp(Double slp) {
        this.slp = slp;
    }

    public Double getAppMaxTemp() {
        return appMaxTemp;
    }

    public void setAppMaxTemp(Double appMaxTemp) {
        this.appMaxTemp = appMaxTemp;
    }

    public Double getPres() {
        return pres;
    }

    public void setPres(Double pres) {
        this.pres = pres;
    }

    public Double getDewpt() {
        return dewpt;
    }

    public void setDewpt(Double dewpt) {
        this.dewpt = dewpt;
    }

    public Integer getSnow() {
        return snow;
    }

    public void setSnow(Integer snow) {
        this.snow = snow;
    }

    public Integer getUv() {
        return uv;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public Integer getWindDir() {
        return windDir;
    }

    public void setWindDir(Integer windDir) {
        this.windDir = windDir;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Double getTs() {
        return ts;
    }

    public void setTs(Double ts) {
        this.ts = ts;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getAppMinTemp() {
        return appMinTemp;
    }

    public void setAppMinTemp(Double appMinTemp) {
        this.appMinTemp = appMinTemp;
    }

    public Double getPrecip() {
        return precip;
    }

    public void setPrecip(Double precip) {
        this.precip = precip;
    }

    public Double getMaxDhi() {
        return maxDhi;
    }

    public void setMaxDhi(Double maxDhi) {
        this.maxDhi = maxDhi;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Integer getVis() {
        return vis;
    }

    public void setVis(Integer vis) {
        this.vis = vis;
    }

}
