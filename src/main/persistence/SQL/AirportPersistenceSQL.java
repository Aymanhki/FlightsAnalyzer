package main.persistence.SQL;

import main.application.FlightsAnalyzer;
import main.persistence.AirportPersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class AirportPersistenceSQL implements AirportPersistence
{
    private final Connection db;

    public AirportPersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printAirportsTable()
    {
        System.out.println("Now printing the airports table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from airports"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void printTopFiveAirports()
    {
        System.out.println("Now printing the most popular airports...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery(FlightsAnalyzer.queries[4]));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
