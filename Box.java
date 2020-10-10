// class for the individual box in the grid

import java.awt.*;

public class Box
{

    protected boolean colored; //checks if box is activated and colored
    protected Color color;
    protected int row;
    protected int col;

    public Box(boolean isOn, Color c, int row, int col)//, int Row, int Col)
    {
        this.colored = isOn;
        this.color = c;
        this.row = row;
        this.col = col;
    }

    //post: returns if box is activated and colored
    public boolean isOn()
    {
        return colored;
    }

    //returns color
    public Color getColor()
    {
        return color;
    }


    public String toString()
    {
        if(colored)
            return "colored";
        else
            return "uncolored";
    }
}