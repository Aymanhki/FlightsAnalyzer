package main.persistence.SQL;

import main.persistence.OperatePersistence;
import main.presentation.DBTablePrinter;

import java.sql.Connection;
import java.sql.SQLException;

public class OperatePersistenceSQL implements OperatePersistence
{
    private final Connection db;

    public OperatePersistenceSQL(Connection db) {this.db = db;}

    @Override
    public void printOperateTable()
    {
        System.out.println("Now printing the operate table...");

        try
        {
            DBTablePrinter.printResultSet(db.createStatement().executeQuery("Select * from operate"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
