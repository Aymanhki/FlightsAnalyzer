package main.objects;

public class Plane
{
    private String tailNumber;
    private int operatingDotID;
    private int marketingDotID;
    private String colorID;

    public Plane(String tailNumber, int operatingDotID, int marketingDotID)
    {
        this.tailNumber = tailNumber;
        this.operatingDotID = operatingDotID;
        this.marketingDotID = marketingDotID;
    }



    public void setColorID(String colorID)
    {
        this.colorID = colorID;
    }
}
