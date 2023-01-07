package main.objects;

public class Airline
{
    private int operatingDotID;
    private int marketingDotID;
    private String airlineName;
    private String operatingAirline;
    private String operatingCodeIATA;
    private String partnersCode;
    private String marketingCodeIATA;
    private String marketingNetwork;

    public Airline(int operatingDotID, int marketingDotID, String airlineName, String operatingAirline, String operatingCodeIATA, String partnersCode, String marketingCodeIATA, String marketingNetwork)
    {
        this.operatingDotID = operatingDotID;
        this.marketingDotID = marketingDotID;
        this.airlineName = airlineName;
        this.operatingAirline = operatingAirline;
        this.operatingCodeIATA = operatingCodeIATA;
        this.partnersCode = partnersCode;
        this.marketingCodeIATA = marketingCodeIATA;
        this.marketingNetwork = marketingNetwork;
    }


}
