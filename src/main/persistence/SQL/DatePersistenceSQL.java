package main.persistence.SQL;

import main.application.FlightsAnalyzer;
import main.persistence.DatePersistence;
import main.presentation.DBTablePrinter;

import java.sql.*;

public class DatePersistenceSQL implements DatePersistence
{
    private final Connection db;

    public DatePersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printDelayed15PerMonth()
    {
        System.out.println("Now printing airlines with their plane numbers");
        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery(FlightsAnalyzer.queries[1]));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void printRainyDaysFlights()
    {
        System.out.println("Now printing number of delayed flights on rainy days compared to non rainy days...");
        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery(FlightsAnalyzer.queries[2]));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void printFlightStatsForInput(String from, String to, String date)
    {
        System.out.println("Now printing flight stats from "+from+" to " + to + " given the date "+date);

        try
        {
            PreparedStatement preparedStatement = db.prepareStatement(FlightsAnalyzer.queries[3]);
            preparedStatement.setString(1, from);
            preparedStatement.setString(2, to);
            preparedStatement.setString(3, date);
            preparedStatement.executeQuery();
            DBTablePrinter.printResultSet(preparedStatement.executeQuery());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void printDatesTable()
    {
        System.out.println("Now printing the dates table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from dates"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
