public class Position implements Comparable<Position>
{
    private int x;
    private int y;

    public Position(int a, int b)
    {
        x = a;
        y = b;
    }

    public Position()
    {
        x = 0;
        y = 0;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX( int newX )
    {
        x =  newX;
    }

    public void setY( int newY )
    {
        y =  newY;
    }

    public int compareTo(Position a)
    {
        if(y > a.getY() || (y == a.getY() && x > a.getX()))
            return 1;

        if(y < a.getY() || (y == a.getY() && x < a.getX()))
            return -1;

        return 0;
    }
}
