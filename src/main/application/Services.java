package main.application;

import main.persistence.*;
import main.persistence.SQL.*;

import java.io.Serializable;
import java.sql.SQLException;

public class Services implements Serializable
{
    private static FlightPersistence flightPersistence = null;
    public static AirlinePersistence airlinePersistence = null;
    public static DatePersistence datePersistence = null;
    public static AirportPersistence airportPersistence = null;
    public static FlightStatsPersistence flightStatsPersistence = null;
    public static RoutePersistence routePersistence = null;
    public static OperatePersistence operatePersistence = null;
    public static ColourPersistence colourPersistence = null;
    public static WeatherPersistence weatherPersistence = null;
    public static LocationPersistence locationPersistence = null;
    public static PlanePersistence planePersistence = null;

    public static synchronized FlightPersistence getFlightPersistence() throws SQLException
    {
        if(flightPersistence == null )
        {
            flightPersistence = new FlightPersistenceSQL(FlightsAnalyzer.getConnection());
        }


        return flightPersistence;
    }

    public static synchronized AirlinePersistence getAirlinePersistence() throws SQLException
    {
        if(airlinePersistence == null )
        {
            airlinePersistence = new AirlinePersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return airlinePersistence;
    }

    public static synchronized DatePersistence getDatePersistence() throws SQLException
    {
        if(datePersistence == null )
        {
            datePersistence = new DatePersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return datePersistence;
    }

    public static synchronized AirportPersistence getAirportPersistence() throws SQLException
    {
        if(airportPersistence == null )
        {
            airportPersistence = new AirportPersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return airportPersistence;
    }

    public static synchronized FlightStatsPersistence getFlightStatsPersistence() throws SQLException
    {
        if(flightStatsPersistence == null )
        {
            flightStatsPersistence = new FlightStatsPersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return flightStatsPersistence;
    }

    public static synchronized RoutePersistence getRoutePersistence() throws SQLException
    {
        if(routePersistence == null )
        {
            routePersistence = new RoutePersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return routePersistence;
    }

    public static synchronized OperatePersistence getOperatePersistence() throws SQLException
    {
        if(operatePersistence == null )
        {
            operatePersistence = new OperatePersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return operatePersistence;
    }

    public static synchronized ColourPersistence getColourPersistence() throws SQLException
    {
        if(colourPersistence == null )
        {
            colourPersistence = new ColourPersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return colourPersistence;
    }

    public static synchronized WeatherPersistence getWeatherPersistence() throws SQLException
    {
        if(weatherPersistence == null )
        {
            weatherPersistence = new WeatherPersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return weatherPersistence;
    }

    public static synchronized LocationPersistence getLocationPersistence() throws SQLException
    {
        if(locationPersistence == null )
        {
            locationPersistence = new LocationPersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return locationPersistence;
    }

    public static synchronized PlanePersistence getPlanePersistence() throws SQLException
    {
        if(planePersistence == null )
        {
            planePersistence = new PlanePersistenceSQL(FlightsAnalyzer.getConnection());
        }

        return planePersistence;
    }


}
