/*
 * COMP 3380                Section A01
 * Instructor               Dr. Patrick M. Dubois
 * Group Project Phase      2
 * Author                   Ayman Agamy, 7884236
 * Version                  Nov 22, 2022
 */

package main.application;
import main.logic.ProcessCommands;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;


public class FlightsAnalyzer
{
    public static Connection db;
    public static String[] queries;

    public static void main(String[] args) throws SQLException
    {
        launch();
    }

    public static void launch() throws SQLException
    {
        db = getConnection();
        queries = getQueries();
        ProcessCommands.process();
    }

    public static String getDBPath()
    {
        Properties prop = new Properties();
        String fileName = "main/assets/auth.cfg";


        try
        {
            InputStream configFile = FlightsAnalyzer.class.getClassLoader().getResourceAsStream(fileName);
            prop.load(configFile);
            configFile.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Could not find config file.");
            System.exit(1);
        }
        catch (IOException ex)
        {
            System.out.println("Error reading config file.");
            System.exit(1);
        }
        String username = (prop.getProperty("username"));
        String password = (prop.getProperty("password"));

        if (username == null || password == null)
        {
            System.out.println("Username or password not provided.");
            System.exit(1);
        }

        String connectionUrl =
                "jdbc:sqlserver://uranium.cs.umanitoba.ca:1433;"
                        + "database=cs3380;"
                        + "user=" + username + ";"
                        + "password=" + password + ";"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        return connectionUrl;
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(getDBPath());
    }

    public static String[] getQueries()
    {
        String fileName = "main/assets/queries.sql";
        InputStream queriesFile = FlightsAnalyzer.class.getClassLoader().getResourceAsStream(fileName);
        String queriesText = queriesFile.toString();
        Scanner scanner = new Scanner(queriesFile);
        scanner.useDelimiter("\r\n---NEXT QUERY---\r\n");
        ArrayList<String> queriesList = new ArrayList<>();

        while (scanner.hasNext())
        {
            queriesList.add(scanner.next());
        }

        String[] queriesSplit = new String[queriesList.size()];

        for (int i = 0; i < queriesList.size(); i++)
        {
            queriesSplit[i] = queriesList.get(i);
        }

        return queriesSplit;
    }

}