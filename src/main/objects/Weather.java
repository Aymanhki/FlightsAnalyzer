package main.objects;

public class Weather
{
    private int weatherTimeStart;
    private int weatherTimeEnd;

    private String weatherDate;
    private String stationN;

    private float hourlyDryBulbTemperature;
    private float hourlyPrecipitation;
    private float hourlyStationPressure;
    private float hourlyVisibility;
    private float hourlyWindSpeed;

    public Weather(int weatherTimeStart, int weatherTimeEnd, String weatherDate, String stationN, float hourlyDryBulbTemperature, float hourlyPrecipitation, float hourlyStationPressure, float hourlyVisibility, float hourlyWindSpeed)
    {
        this.weatherTimeStart = weatherTimeStart;
        this.weatherTimeEnd = weatherTimeEnd;
        this.weatherDate = weatherDate;
        this.stationN = stationN;
        this.hourlyDryBulbTemperature = hourlyDryBulbTemperature;
        this.hourlyPrecipitation = hourlyPrecipitation;
        this.hourlyStationPressure = hourlyStationPressure;
        this.hourlyVisibility = hourlyVisibility;
        this.hourlyWindSpeed = hourlyWindSpeed;
    }



}
