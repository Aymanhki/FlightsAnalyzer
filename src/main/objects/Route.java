package main.objects;

public class Route
{
    private int routeID;
    private int originAirportID;
    private int originAirportSeqID;
    private int destinationAirportID;
    private int destinationAirportSeqID;
    private int crsDepartureTime;
    private int crsArriveTime;
    private int distance;
    private int crsElapsedTime;
    private int departureTimeStart;
    private int departureTimeEnd;
    private int arrivalTimeStart;
    private int arrivalTimeEnd;

    public Route(int routeID, int originAirportID, int originAirportSeqID, int destinationAirportID, int destinationAirportSeqID, int crsDepartureTime, int crsArriveTime, int distance, int crsElapsedTime, int departureTimeStart, int departureTimeEnd, int arrivalTimeStart, int arrivalTimeEnd)
    {
        this.routeID = routeID;
        this.originAirportID = originAirportID;
        this.originAirportSeqID = originAirportSeqID;
        this.destinationAirportID = destinationAirportID;
        this.destinationAirportSeqID = destinationAirportSeqID;
        this.crsDepartureTime = crsDepartureTime;
        this.crsArriveTime = crsArriveTime;
        this.distance = distance;
        this.crsElapsedTime = crsElapsedTime;
        this.departureTimeStart = departureTimeStart;
        this.departureTimeEnd = departureTimeEnd;
        this.arrivalTimeStart = arrivalTimeStart;
        this.arrivalTimeEnd = arrivalTimeEnd;
    }

    public int getOriginAirportID()
    {
        return originAirportID;
    }

    public int getOriginAirportSeqID()
    {
        return originAirportSeqID;
    }

    public int getDestinationAirportID()
    {
        return destinationAirportID;
    }

    public int getDestinationAirportSeqID()
    {
        return destinationAirportSeqID;
    }

    public int getCrsDepartureTime()
    {
        return crsDepartureTime;
    }

    public int getCrsArriveTime()
    {
        return crsArriveTime;
    }

    public int getDistance()
    {
        return distance;
    }

    public int getCrsElapsedTime()
    {
        return crsElapsedTime;
    }

    public int getDepartureTimeStart()
    {
        return departureTimeStart;
    }

    public int getDepartureTimeEnd()
    {
        return departureTimeEnd;
    }

    public int getArrivalTimeStart()
    {
        return arrivalTimeStart;
    }

    public int getArrivalTimeEnd()
    {
        return arrivalTimeEnd;
    }


    public void setRouteID(int routeID)
    {
        this.routeID = routeID;
    }

    @Override
    public boolean equals(Object obj)
    {
        return originAirportID == ((Route) obj).originAirportID &&
                originAirportSeqID == ((Route) obj).originAirportSeqID &&
                destinationAirportID == ((Route) obj).destinationAirportID &&
                destinationAirportSeqID == ((Route) obj).destinationAirportSeqID &&
                crsDepartureTime == ((Route) obj).crsDepartureTime &&
                crsArriveTime == ((Route) obj).crsArriveTime &&
                distance == ((Route) obj).distance &&
                crsElapsedTime == ((Route) obj).crsElapsedTime &&
                departureTimeStart == ((Route) obj).departureTimeStart &&
                departureTimeEnd == ((Route) obj).departureTimeEnd &&
                arrivalTimeStart == ((Route) obj).arrivalTimeStart &&
                arrivalTimeEnd == ((Route) obj).arrivalTimeEnd;
    }

    public int getRouteID()
    {
        return routeID;
    }
}
