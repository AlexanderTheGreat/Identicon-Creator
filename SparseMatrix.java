import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class SparseMatrix<anyType> implements Sparseable<anyType>
{
    ArrayList <SparseNode<anyType>> Matrix;

    private anyType value;
    private final int rows;
    private final int cols;
    private boolean drawable;

    public SparseMatrix(int numRows, int numCols)
    {
        rows = numRows;
        cols = numCols;
        Matrix = new ArrayList();
    }

    @Override
    public int size()
    {
        return rows*cols;
    }

    @Override
    public int numRows()
    {
        return rows;
    }

    @Override
    public int numCols()
    {
        return cols;
    }

    @Override
    public boolean add(int rows, int cols, anyType x)
    {
        SparseNode<anyType> Node = new SparseNode<>(rows, cols, x);
        if(Matrix.size() == 0)
            Matrix.add(Node);
        for(int i=0; i<Matrix.size(); i++)
            if(get(rows,cols) != null)
                return false;
            else
                if(Matrix.get(i).compareTo(Node) > 0)
                {
                    Matrix.add(i,Node);
                    return true;
                }
                else
                    if(i == Matrix.size()-1 && Matrix.get(i).compareTo(Node) < 0)
                    {
                        Matrix.add(Node);
                        return true;
                    }

        return false;
    }

    @Override
    public anyType get(int rows, int cols)
    {
        for (SparseNode<anyType> matrix : Matrix)
        {
            if (matrix.getRow() == rows && matrix.getCol() == cols)
                return matrix.getVal();
        }

        return null;
    }

    @Override
    public anyType set(int rows, int cols, anyType x)
    {
        anyType temp=x;
        for (SparseNode<anyType> matrix : Matrix)
            if (matrix.getRow() == rows && matrix.getCol() == cols)
            {
                temp = matrix.getVal();
                matrix.setVal(x);
            }

        return temp;
    }

    @Override
    public anyType remove(int rows, int cols)
    {
        anyType oldVal = null;
        for(int i=0; i<Matrix.size(); i++)
        {
            if(Matrix.get(i).getRow() == rows && Matrix.get(i).getCol() == cols)
            {
                oldVal = Matrix.get(i).getVal();
                Matrix.remove(i);
                break;
            }
        }

        return oldVal;
    }

    @Override
    public boolean isEmpty()
    {
        boolean notEmpty = false;
        for(int r=0; r<rows; r++)
            for(int c=0; c<cols; c++)
            {
                if(get(r,c) != null)
                {
                    notEmpty = true;
                    break;
                }
            }
        return notEmpty;
    }

    @Override
    public boolean contains(anyType x)
    {
        boolean contains = false;
        for(int r=0; r<rows; r++)
            for(int c=0; c<cols; c++)
            {
                anyType temp = get(r,c);

                if(temp != null && temp.equals(x))
                {
                    contains = true;
                    break;
                }
            }

        return contains;
    }

    public String toString()
    {
        String matrix = "";
        for(int r=0; r<rows; r++)
        {
            for(int c=0; c<cols; c++)
            {
                anyType temp=get(r,c);
                if(temp != null)
                    matrix += temp.toString();
                else
                    matrix += "-";
            }
            matrix += "\n";
        }

        return(matrix);
    }
}
