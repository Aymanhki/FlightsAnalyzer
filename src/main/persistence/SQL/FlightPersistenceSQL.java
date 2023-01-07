package main.persistence.SQL;

import main.persistence.FlightPersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class FlightPersistenceSQL implements FlightPersistence
{
    private final Connection db;

    public FlightPersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printFlightsTable()
    {
        System.out.println("Now printing the flights table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from flights"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
