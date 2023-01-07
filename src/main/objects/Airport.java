package main.objects;

public class Airport
{
    private int airportID;
    private int seqID;
    private int cityMarketID;
    private String cityName;
    private String abbreviation;
    private String stationN;

    public Airport(int airportID, int seqID, int cityMarketID, String cityName, String abbreviation, String stationN)
    {
        this.airportID = airportID;
        this.seqID = seqID;
        this.cityMarketID = cityMarketID;
        this.cityName = cityName;
        this.abbreviation = abbreviation;
        this.stationN = stationN;

    }


}
