package main.persistence.SQL;

import main.persistence.LocationPersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class LocationPersistenceSQL implements LocationPersistence
{
    private final Connection db;

    public LocationPersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printLocationsTables()
    {
        System.out.println("Now printing the locations table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from locations"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
