package main.persistence.SQL;


import main.persistence.RoutePersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class RoutePersistenceSQL implements RoutePersistence
{
    private final Connection db;

    public RoutePersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printRoutesTable()
    {
        System.out.println("Now printing the routes table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from routes"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
