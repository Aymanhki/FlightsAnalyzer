package main.persistence.SQL;

import main.persistence.ColourPersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class ColourPersistenceSQL implements ColourPersistence
{
    private final Connection db;

    public ColourPersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printColoursTable()
    {
        System.out.println("Now printing the colors table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from colors"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
