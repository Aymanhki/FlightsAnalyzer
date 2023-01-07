package main.objects;

public class Location
{
    private String cityName;
    private String abbreviation;
    private int WAC;
    private int FIPS;
    private String stateName;

    public Location(String cityName, String abbreviation, int WAC, int FIPS, String stateName)
    {
        this.cityName = cityName;
        this.abbreviation = abbreviation;
        this.WAC = WAC;
        this.FIPS = FIPS;
        this.stateName = stateName;
    }

}
