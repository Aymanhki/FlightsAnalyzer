package main.persistence.SQL;

import main.persistence.FlightStatsPersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class FlightStatsPersistenceSQL implements FlightStatsPersistence
{
    private final Connection db;

    public FlightStatsPersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printFlightsStatsTable()
    {
        System.out.println("Now printing the flightsStats table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from flightsStats"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
