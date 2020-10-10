public class Grid
{

    public SparseMatrix<Box> grid;

    public Grid(int height, int width)
    {
        grid = new SparseMatrix(height, width);
        setGrid();
    }

    public void setGrid() //sets the grid, true = colored box, false = uncolored box
    {
        //grid.add(1,1, new Box());
    }

    public void addBox(Box b)
    {
        grid.add(b.row, b.col, b);
    }

}