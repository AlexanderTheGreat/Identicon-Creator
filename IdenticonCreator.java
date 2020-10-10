import javax.swing.*;
import java.awt.*;

public class IdenticonCreator extends JPanel
{
    private static Grid identicon;
    private final int height = 5;
    private final int width = 5;

    public IdenticonCreator()
    {
        identicon = new Grid(height, width);
        generateBoard();
    }

    // Renders the new board
    public void renderBoard(Graphics g, int height, int width)
    {
        for (int r = 0; r < identicon.grid.numRows(); r++)
        {
            for (int c = 0; c < identicon.grid.numCols(); c++)
            {
                Box b = identicon.grid.get(r, c);
                if(b.isOn())
                {
                    g.setColor(b.getColor());
                }
                else
                {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(r * (height), c * (width), height, width);
            }
        }
    }

    // generates a new random identicon
    public void generateBoard()
    {
        // getting a random color
        identicon = new Grid(height, width);

        float h = (float) Math.random() * 360;    // hue 0-360
        float s = (float) Math.random() * 100;    // saturation 0-100
        float b = (float) Math.random() * 100;    // brightness 0-100

        for (int r = 0; r < identicon.grid.numRows(); r++)
        {
            for (int c = 0; c < identicon.grid.numCols(); c++)
            {
                // Initializing the HSB values here, instead, causes all blocks to have a random color
                /*float h = (float) Math.random() * 360;    // hue 0-360
                float s = (float) Math.random() * 100;    // saturation 0-100
                float b = (float) Math.random() * 100;    // brightness 0-100
                */

                boolean isOn = Math.random() >= 0.5;
                Box box = new Box(isOn, Color.getHSBColor(h, s, b), r, c);
                identicon.addBox(box);
            }
        }
    }

    //post: paints grid
    public void paint(Graphics g)
    {
        renderBoard(g, (getWidth()+4) / width, (getHeight()+3) / height);
    }
}
