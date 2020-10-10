public class SparseNode<anyType> implements Comparable
{
    private anyType val;
    private int row;
    private int col;

    public SparseNode(int Row, int Col,anyType value)
    {
        val=value;
        row=Row;
        col=Col;
    }

    //gets the value
    public anyType getVal()
    {
        return val;
    }

    //gets the row
    public int getRow()
    {
        return row;
    }

    //gets the column
    public int getCol()
    {
        return col;
    }

    //sets the value
    public anyType setVal(anyType newVal)
    {
        val=newVal;
        return val;
    }

    //sets the row
    public int setRow(int r)
    {
        row=r;
        return row;
    }

    //sets teh column
    public int setCol(int c)
    {
        col=c;
        return col;
    }

    public int compareTo(Object other)
    {
        SparseNode<anyType> x = (SparseNode<anyType>)other;
        if(row>x.getRow() || ( row == x.getRow() && col> x.getCol()))
            return 1;

        if(row<x.getRow() || ( row == x.getRow() && col< x.getCol()))
            return -1;
        return 0;
    }

}