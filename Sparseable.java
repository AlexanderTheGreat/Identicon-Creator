import java.awt.*;

public interface Sparseable<anyType>
{
    public int size();		//return number of occupied elements
    public int numRows();	//return logical number of rows
    public int numCols();	//return logical number of columns

    public boolean add(int rows, int cols, anyType x);
    //adds x at rows, cols and returns true.  If element already exists, doesn't add it and returns false.

    public anyType get(int rows, int cols);
    //returns element at rows, cols.   returns null if no element there

    public anyType set(int rows, int cols, anyType x);
    //changes element at rows, cols to x  and returns old value.  If element no element exists, returns null.

    public anyType remove(int rows, int cols);
    //remove and return the element at rows, cols

    public boolean isEmpty();
    //true if there are no occupied elements

    public boolean contains(anyType x);
    //returns true if sparse matrix contains x
    //nice if SparseMatrix has a toString return elements in grid format
    //constructor:   SparseMatrix<anyType> sm = new SparseMatrix(int numRows, int NumCols);
}