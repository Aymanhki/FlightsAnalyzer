package main.persistence.SQL;

import main.application.FlightsAnalyzer;
import main.persistence.AirlinePersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class AirlinePersistenceSQL implements AirlinePersistence
{
    private final Connection db;

    public AirlinePersistenceSQL(Connection db)
    {
        this.db = db;
    }





    @Override
    public void printAirlinesPlanes(boolean top)
    {
        System.out.println("Now printing airlines with their plane numbers...");

        try
        {
            if(top)
            {
                DBTablePrinter.printResultSet(db.createStatement().executeQuery(FlightsAnalyzer.queries[5]));
            }
            else
            {
                DBTablePrinter.printResultSet(db.createStatement().executeQuery(FlightsAnalyzer.queries[0]));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void printAirlinesTable()
    {
        System.out.println("Now printing the airlines table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from airlines"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
