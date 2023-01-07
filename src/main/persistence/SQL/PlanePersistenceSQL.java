package main.persistence.SQL;

import main.persistence.PlanePersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class PlanePersistenceSQL implements PlanePersistence
{
    private final Connection db;

    public PlanePersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printPlanesTable()
    {
        System.out.println("Now printing the planes table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from planes"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
