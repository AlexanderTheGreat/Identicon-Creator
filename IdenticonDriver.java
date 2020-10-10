import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class IdenticonDriver
{
    public static IdenticonCreator identicon;

    public static void main(String[] args)
    {
        identicon = new IdenticonCreator();
        JFrame frame = new JFrame("Identicon Creator");
        frame.setSize(400, 425);
        frame.setLocation(200, 25);
        frame.setContentPane(identicon);
        JMenuItem screenshot = new JMenuItem("Save Image");
        JMenuItem newIdenticon = new JMenuItem("Re-generate");

        screenshot.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));    // Takes screenshot when pressing CTRL+S

        // adds function to newIdenticon button
        newIdenticon.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        identicon.generateBoard();
                        identicon.paint(identicon.getGraphics());
                    }
                });

        // adds function to screenshot button
        screenshot.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        BufferedImage img = getScreenShot(
                                frame.getContentPane());
                        JOptionPane.showMessageDialog(null, new JLabel(
                                        new ImageIcon(
                                                img.getScaledInstance(
                                                        img.getWidth(null) / 2,
                                                        img.getHeight(null) / 2,
                                                        Image.SCALE_SMOOTH)
                                        )));
                        try
                        {
                            // write the image as a PNG
                            ImageIO.write(
                                    img,
                                    "png",
                                    new File("screenshot.png"));
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                });

        // Re-generates Identicon when pressing space
        frame.addKeyListener(
               new KeyListener()
               {
                   @Override
                   public void keyTyped(KeyEvent e)
                   {

                   }

                   @Override
                   public void keyPressed(KeyEvent e)
                   {
                       if(e.getKeyCode() == KeyEvent.VK_SPACE)
                       {
                           identicon.generateBoard();
                           identicon.paint(identicon.getGraphics());
                       }
                   }

                   @Override
                   public void keyReleased(KeyEvent e)
                   {

                   }
               }
        );

        // adding menu bar
        JMenu menu = new JMenu("File");
        menu.add(screenshot);

        JMenuBar mb = new JMenuBar();
        mb.add(menu);
        mb.add(newIdenticon);
        frame.setJMenuBar(mb);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static BufferedImage getScreenShot(Component component)
    {
        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);

        // call the Component's paint method, using the Graphics object of the image.
        component.paint(image.getGraphics()); // alternately use .printAll(..)

        return image;
    }
}
