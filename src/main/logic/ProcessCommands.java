package main.logic;

import main.application.Services;

import java.sql.SQLException;
import java.util.Scanner;

public class ProcessCommands
{
    public static void process() throws SQLException
    {
        Scanner console = new Scanner(System.in);
        System.out.print("\nWelcome to Flights Analyzer\nType help to show the application manual and get started\n");
        System.out.print("\nFlightsAnalyzer > ");
        String line = console.nextLine();
        String[] parts;

        while (line != null && !line.equalsIgnoreCase("quit") && !line.equalsIgnoreCase("exit"))
        {
            parts = line.trim().split("\\s+");

            if (parts.length > 0)
            {
                if (parts[0].equalsIgnoreCase("help"))
                {
                    System.out.println(getHelp());
                }
                else if (parts[0].equals("airlines"))
                {
                    if(parts.length == 1)
                    {
                        airlines();
                    }
                    else if(parts[1].equalsIgnoreCase("Top"))
                    {
                        airlinesTop();
                    }
                    else
                    {
                        System.out.println("\nerror parsing 'airlines command,\nplease try again\n");
                    }
                }
                else if (parts[0].equals("holidays"))
                {
                    holidays();
                }
                else if (parts[0].equals("rainy"))
                {
                    System.out.println("\nPlease note: due to the size of the dataset, generating the requested table will take up 1 hour as it will join millions of rows on multiple values\n");
                    rainy();
                }
                else if (parts[0].equals("airports"))
                {
                    topFiveAirports();
                }
                else if (parts[0].equals("from"))
                {
                    if (parts.length >= 6 && parts[2].equalsIgnoreCase("to") && parts[4].equalsIgnoreCase("on") && parts[5].split("-").length == 3)
                    {
                        String from = parts[1];
                        String to = parts[3];
                        String date = parts[5];
                        String[] dateSplit = date.split("-");

                        if(Integer.parseInt(dateSplit[0]) == 2019 && Integer.parseInt(dateSplit[1]) >= 5 && Integer.parseInt(dateSplit[1]) <= 12 && Integer.parseInt(dateSplit[2]) >= 1 && Integer.parseInt(dateSplit[2]) <= 31)
                        {
                            flightsFromInput(from, to, date);
                        }
                        else
                        {
                            System.out.println("\nThe date you entered is not within the dataset\nTry again\n");
                        }
                    }
                    else
                    {
                        System.out.println("\nIncorrect format for 'from' command please use \"from AUS to PHL on 2019-05-05\" as reference\n");
                    }
                }
                else if (parts[0].equals("view"))
                {
                    if (parts.length >= 3)
                    {
                        if (parts[1].equals("table"))
                        {
                            if (parts[2].equalsIgnoreCase("planes"))
                            {
                                planesTable();
                            }
                            else if (parts[2].equalsIgnoreCase("airlines"))
                            {
                                airlineTable();
                            }
                            else if (parts[2].equalsIgnoreCase("airports"))
                            {
                                airportTable();
                            }
                            else if (parts[2].equalsIgnoreCase("colors"))
                            {
                                colourTable();
                            }
                            else if (parts[2].equalsIgnoreCase("routes"))
                            {
                                routeTable();
                            }
                            else if (parts[2].equalsIgnoreCase("flights"))
                            {
                                if (getConfirmation())
                                {
                                    System.out.println("\nRoger That, printing now\n");
                                    flightTable();
                                }
                                else
                                {
                                    System.out.println("\nOk not going to print this table\n");
                                }

                            }
                            else if (parts[2].equalsIgnoreCase("flightsStats"))
                            {
                                if (getConfirmation())
                                {
                                    System.out.println("\nRoger That, printing now\n");
                                    flightsStatsTable();
                                }
                                else
                                {
                                    System.out.println("\nOk not going to print this table\n");
                                }
                            }
                            else if (parts[2].equalsIgnoreCase("weather"))
                            {
                                if (getConfirmation())
                                {
                                    System.out.println("\nRoger That, printing now\n");
                                    weatherTable();
                                }
                                else
                                {
                                    System.out.println("\nOk not going to print this table\n");
                                }
                            }
                            else if (parts[2].equalsIgnoreCase("locations"))
                            {
                                locationTable();
                            }
                            else if (parts[2].equalsIgnoreCase("operate"))
                            {
                                operateTable();
                            }
                            else if (parts[2].equalsIgnoreCase("dates"))
                            {
                                dateTable();
                            }
                            else
                            {
                                System.out.println(parts[2] + " is not a table within the dataset");
                            }

                        }
                        else
                        {
                            System.out.println("Incorrect format for command please use \"view table planes\" as reference");
                        }
                    }
                    else
                    {
                        System.out.println("Incorrect format for command please use \"view table planes\" as reference");
                    }
                }
                else
                {
                    System.out.println("\nNot a valid input\nPlease type help to see the application manual\n");
                }
            }
            else
            {
                System.out.println("\nDidn't get your input there\nTry again\n");
            }

            System.out.print("\nFlightsAnalyzer > ");
            line = console.nextLine();
        }
    }

    public static String getHelp()
    {
        String toReturn = "";
        toReturn += "\nHi,\nthe application can perform the following:\n";
        toReturn += "1. Show a table of airlines and # of their planes when you enter 'airlines' or the same table with top 5 results when you enter 'airlines top'\n";
        toReturn += "2. Show a table of the number flights delayed more than 15 minutes on holidays per month when you enter 'holidays'\n";
        toReturn += "3. Show a table of number of flights delayed on rainy days compared to non rainy days per month when you enter 'rainy'\n";
        toReturn += "4. Show a table of flightsStats given origin, destination, and date when you enter 'from <origin airport> to <destination airport> on <date>', for example \"from AUS to PHL on 2019-05-05\"\n";
        toReturn += "5. Show a table of within the dataset when you enter 'view table <table name>', for example \"view table planes\", The available tables are\n";
        toReturn += "        airports\n";
        toReturn += "        airlines\n";
        toReturn += "        locations\n";
        toReturn += "        operate\n";
        toReturn += "        planes\n";
        toReturn += "        colors\n";
        toReturn += "        dates\n";
        toReturn += "        flights\n";
        toReturn += "        routes\n";
        toReturn += "        flightsStats\n";
        toReturn += "        weather\n";
        toReturn += "6. Show a table of the most popular (visited) airports (top 5) when you enter 'airports'\n";
        toReturn += "7. Show this manual when you type 'help'\n";
        toReturn += "8. Exit when you type 'quit' or 'exit'";
        return toReturn;
    }

    public static void airlines() throws SQLException
    {
        Services.getAirlinePersistence().printAirlinesPlanes(false);
    }

    public static void holidays() throws SQLException
    {
        Services.getDatePersistence().printDelayed15PerMonth();
    }

    public static void rainy() throws SQLException
    {
        Services.getDatePersistence().printRainyDaysFlights();
    }

    public static void flightsFromInput(String from, String to, String date) throws SQLException
    {
        Services.getDatePersistence().printFlightStatsForInput(from, to, date);
    }

    public static void weatherTable() throws SQLException
    {
        Services.getWeatherPersistence().printWeatherTable();
    }

    public static void operateTable() throws SQLException
    {
        Services.getOperatePersistence().printOperateTable();
    }

    public static void locationTable() throws SQLException
    {
        Services.getLocationPersistence().printLocationsTables();
    }

    public static void airportTable() throws SQLException
    {
        Services.getAirportPersistence().printAirportsTable();
    }

    public static void airlineTable() throws SQLException
    {
        Services.getAirlinePersistence().printAirlinesTable();
    }

    public static void colourTable() throws SQLException
    {
        Services.getColourPersistence().printColoursTable();
    }

    public static void routeTable() throws SQLException
    {
        Services.getRoutePersistence().printRoutesTable();
    }

    public static void flightTable() throws SQLException
    {
        Services.getFlightPersistence().printFlightsTable();
    }

    public static void flightsStatsTable() throws SQLException
    {
        Services.getFlightStatsPersistence().printFlightsStatsTable();
    }

    public static void dateTable() throws SQLException
    {
        Services.getDatePersistence().printDatesTable();
    }

    public static void planesTable() throws SQLException
    {
        Services.getPlanePersistence().printPlanesTable();
    }

    public static boolean getConfirmation()
    {
        boolean toReturn = false;
        String confirmationMsg = "The table you want to print is very large (millions of rows)\n" +
                "and will probably print too fast for you to see the headers\n" +
                "Are you sure you want to print this table?\n" +
                "Type yes/y or No/n";
        System.out.println(confirmationMsg);
        Scanner confirmationScan = new Scanner(System.in);
        String confirmationLine = confirmationScan.nextLine();

        while (!confirmationLine.equalsIgnoreCase("No") && !confirmationLine.equalsIgnoreCase("N") && !toReturn)
        {
            if (confirmationLine.equalsIgnoreCase("yes") || confirmationLine.equalsIgnoreCase("y"))
            {
                toReturn = true;
            }
            else if (confirmationLine.equalsIgnoreCase("No") || confirmationLine.equalsIgnoreCase("no"))
            {
                toReturn = false;
            }
            else
            {
                System.out.println("\nSo the thing is, computers don't understand philosophy, try again\n");
                System.out.println(confirmationMsg);
                confirmationLine = confirmationScan.nextLine();
            }
        }
        return toReturn;
    }

    public static void topFiveAirports() throws SQLException
    {
        Services.getAirportPersistence().printTopFiveAirports();
    }

    public static void airlinesTop() throws SQLException
    {
        Services.getAirlinePersistence().printAirlinesPlanes(true);
    }
}
