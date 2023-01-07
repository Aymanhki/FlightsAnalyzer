package main.objects;

public class Date
{
    private String flightDate;
    private int dateYear;
    private int dateMonth;
    private int dateDay;
    private int quarter;
    private int weekDay;
    boolean holiday;
    public static Date[] holidays =
            {
                    new Date(1, 1),
                    new Date(1, 3),
                    new Date(1, 17),
                    new Date(2, 21),
                    new Date(4, 17),
                    new Date(5, 8),
                    new Date(5, 30),
                    new Date(6, 17),
                    new Date(6, 19),
                    new Date(6, 20),
                    new Date(7, 4),
                    new Date(9, 5),
                    new Date(10, 10),
                    new Date(11, 11),
                    new Date(11, 24),
                    new Date(11, 25),
                    new Date(12, 25),
                    new Date(12, 26)
            };

    public Date(String flightDate, int dateYear, int dateMonth, int dateDay, int quarter, int weekDay, boolean holiday)
    {
        this.flightDate = flightDate;
        this.dateYear = dateYear;
        this.dateMonth = dateMonth;
        this.dateDay = dateDay;
        this.quarter = quarter;
        this.weekDay = weekDay;
        this.holiday = holiday;
    }

    public Date(int dateMonth, int dateDay)
    {
        this.dateMonth = dateMonth;
        this.dateDay = dateDay;
    }



    @Override
    public boolean equals(Object obj)
    {
        return dateMonth == ((Date) obj).dateMonth && dateDay == ((Date) obj).dateDay;
    }

    public void setHoliday(boolean holiday)
    {
        this.holiday = holiday;
    }


}
