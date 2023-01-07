package main.objects;

public class FlightsStats
{
    private int flightID;
    private String wheelsOnTime;
    private String wheelsOffTime;
    private String taxiInTime;
    private String taxiOutTime;
    private String departureTime;
    private String departureDelay;
    private String departureDelay15;
    private String arrivalTime;
    private String arrivalDelay;
    private String arrivalDelay15;
    private String airTime;
    private String elapsedTime;

    public FlightsStats(int flightID, String wheelsOnTime, String wheelsOffTime, String taxiInTime, String taxiOutTime, String departureTime, String departureDelay, String departureDelay15, String arrivalTime, String arrivalDelay, String arrivalDelay15, String airTime, String elapsedTime)
    {
        this.flightID = flightID;
        this.wheelsOnTime = wheelsOnTime;
        this.wheelsOffTime = wheelsOffTime;
        this.taxiInTime = taxiInTime;
        this.taxiOutTime = taxiOutTime;
        this.departureTime = departureTime;
        this.departureDelay = departureDelay;
        this.departureDelay15 = departureDelay15;
        this.arrivalTime = arrivalTime;
        this.arrivalDelay = arrivalDelay;
        this.arrivalDelay15 = arrivalDelay15;
        this.airTime = airTime;
        this.elapsedTime = elapsedTime;
    }

    public void setFlightID(int flightID)
    {
        this.flightID = flightID;
    }

    @Override
    public boolean equals(Object obj)
    {
        return wheelsOnTime.equals(((FlightsStats) obj).wheelsOnTime) &&
                wheelsOffTime.equals(((FlightsStats) obj).wheelsOffTime) &&
                taxiInTime.equals(((FlightsStats) obj).taxiInTime) &&
                taxiOutTime.equals(((FlightsStats) obj).taxiOutTime) &&
                departureTime.equals(((FlightsStats) obj).departureTime) &&
                departureDelay.equals(((FlightsStats) obj).departureDelay) &&
                departureDelay15.equals(((FlightsStats) obj).departureDelay15) &&
                arrivalTime.equals(((FlightsStats) obj).arrivalTime) &&
                arrivalDelay.equals(((FlightsStats) obj).arrivalDelay) &&
                arrivalDelay15.equals(((FlightsStats) obj).arrivalDelay15) &&
                airTime.equals(((FlightsStats) obj).airTime) &&
                elapsedTime.equals(((FlightsStats) obj).elapsedTime);
    }

    public int getFlightID()
    {
        return flightID;
    }
}
