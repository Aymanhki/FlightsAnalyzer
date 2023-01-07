package main.persistence;

public interface DatePersistence
{
    void printDelayed15PerMonth();

    void printRainyDaysFlights();

    void printFlightStatsForInput(String from, String to, String date);
    void printDatesTable();
}