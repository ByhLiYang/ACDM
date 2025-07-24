package com.hq.acdm.model.index;

import java.util.Date;

public class Weather {
    private Date updatedatetime;

    private String airportiata;

    private Date weatherdate;

    private String temperature;

    private String weather;

    private String winddirection;

    private String windforce;

    private String visibility;

    private String cloutheight;

    private String humidity;

    public Date getUpdatedatetime() {
        return updatedatetime;
    }

    public void setUpdatedatetime(Date updatedatetime) {
        this.updatedatetime = updatedatetime;
    }

    public String getAirportiata() {
        return airportiata;
    }

    public void setAirportiata(String airportiata) {
        this.airportiata = airportiata == null ? null : airportiata.trim();
    }

    public Date getWeatherdate() {
        return weatherdate;
    }

    public void setWeatherdate(Date weatherdate) {
        this.weatherdate = weatherdate;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public String getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(String winddirection) {
        this.winddirection = winddirection == null ? null : winddirection.trim();
    }

    public String getWindforce() {
        return windforce;
    }

    public void setWindforce(String windforce) {
        this.windforce = windforce == null ? null : windforce.trim();
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility == null ? null : visibility.trim();
    }

    public String getCloutheight() {
        return cloutheight;
    }

    public void setCloutheight(String cloutheight) {
        this.cloutheight = cloutheight == null ? null : cloutheight.trim();
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity == null ? null : humidity.trim();
    }
}