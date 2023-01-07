package main.objects;

public class Flight
{
    private int scheduleID;
    private int routeID;
    private int flightNumber;
    private int marketingFlightNumber;
    private String flightDate;
    private String tailNumber;
    private int operatingDotID;
    private int marketingDotID;
    private int flightID;
    private int weatherTimeStart;
    private int weatherTimeEnd;
    private boolean canceled;

    public Flight(int scheduleID, int routeID, int flightNumber, int marketingFlightNumber, String flightDate, String tailNumber, int operatingDotID, int marketingDotID, int flightID,  int weatherTimeStart, int weatherTimeEnd, boolean canceled)
    {
        this.scheduleID = scheduleID;
        this.routeID = routeID;
        this.flightNumber = flightNumber;
        this.marketingFlightNumber = marketingFlightNumber;
        this.flightDate = flightDate;
        this.tailNumber = tailNumber;
        this.operatingDotID = operatingDotID;
        this.marketingDotID = marketingDotID;
        this.flightID = flightID;
        this.weatherTimeStart = weatherTimeStart;
        this.weatherTimeEnd = weatherTimeEnd;
        this.canceled = canceled;
    }



}
