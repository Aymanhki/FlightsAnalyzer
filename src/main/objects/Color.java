package main.objects;

public class Color
{
    private String colorName;
    private String colorID;
    private String decimalCode;

    public Color(String colorName, String colorID, String decimalCode)
    {
        this.colorName = colorName;
        this.colorID = colorID;
        this.decimalCode = decimalCode;
    }

    public String getColorID()
    {
        return colorID;
    }


}
