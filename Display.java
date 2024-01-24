/** 
 * Simple class used to create a display of constant size with black background
 *
 * @author Meruzhan Sargsyan
 */

import java.awt.*;
import javax.swing.*;

class Display extends JFrame{
    JFrame frame;
    JPanel panel;
    public static int WINDOW_SIZE_X = 500;
    public static int WINDOW_SIZE_Y = 500;
    private int BONUS_X_SPACE = 50;

    /** 
     * initializes frame and panel using constants and DrawPanel class
     */
    Display(Graph g) {
        frame = new JFrame();
        frame.setSize(WINDOW_SIZE_X + BONUS_X_SPACE, WINDOW_SIZE_Y);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        panel = new DrawPanel(g);
        panel.setSize(WINDOW_SIZE_X + BONUS_X_SPACE, WINDOW_SIZE_Y);
        panel.setBackground(Color.BLACK);

        frame.add(panel);
    }

    /** 
     * simple method that makes the display visible
     */
    void showDisplay() {
        frame.setVisible(true);
    }
}