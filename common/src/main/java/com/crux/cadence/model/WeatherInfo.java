package com.crux.cadence.model;

public class WeatherInfo {

    private String weather;
    private double degrees;
    private String  city;

    public WeatherInfo(String weather, double degrees, String  city) {
        this.weather = weather;
        this.degrees = degrees;
        this.city = city;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String weather) {
        this.city = city;
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }
}
