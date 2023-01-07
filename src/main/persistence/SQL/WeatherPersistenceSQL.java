package main.persistence.SQL;

import main.persistence.WeatherPersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class WeatherPersistenceSQL implements WeatherPersistence
{
    private final Connection db;

    public WeatherPersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printWeatherTable()
    {
        System.out.println("Now printing the weather table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from weather"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
