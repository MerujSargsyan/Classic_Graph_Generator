/**
 * Cusom implementation of a JPanel used to draw vertecies and edges to a 
 * display in a custom way
 *
 * @author Meruzhan Sargsyan
 */
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.Path2D;


class DrawPanel extends JPanel {
    ArrayList<Vertex> vertecies;
    ArrayList<Edge> edges;
    
    private JLabel text;
    private final int TEXT_WIDTH = 100;
    private final int TEXT_HEIGHT = 50;
    private final int TEXT_POSITION = 50; //X and Y offset

    private final int VERTEX_SIZE = 25;
    private final int CENTER_ADJUSTMENT = 12; //adjust circle around vertex
    private final int CURVE_FACTOR = 12;


    /** 
     * Creates a panel to draw on, creating the settings based on the above
     * constants.
     * Sets the instance fields vertecies and edges to those of the graph
     *
     * @param Graph g to draw on the Panel
     */
    DrawPanel(Graph g) {
        this.vertecies = g.vertecies;
        this.edges = g.edges;
        
        text = new JLabel("|V| = " + vertecies.size() + " |E| = " + 
            edges.size());
        text.setSize(TEXT_HEIGHT, TEXT_WIDTH);
        text.setLocation(TEXT_POSITION, TEXT_POSITION);
        text.setVisible(true);
        text.setForeground(Color.WHITE);
        this.add(text);

        this.repaint();
    }

    /** 
     * Overrides the paintComponent method of the JPanel superclass
     * simply uses helper methods to print edges and vertecies
     *
     * @param Graphics g graphic component to use to draw
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        for(Vertex v : vertecies) {
            paintVertex(v, g);
        }
        for(Edge e : edges) {
            paintEdge(e, g);
        }
    }

    /**
     * helper method for paint component
     * draws a circle on the panel centered at a vertex using size constants
     *
     * @param Vertex v to center the point at
     * @param Graphics g used to draw the point
     */
    void paintVertex(Vertex v, Graphics g) {
        g.fillRoundRect(v.x - CENTER_ADJUSTMENT, v.y - CENTER_ADJUSTMENT, 
            VERTEX_SIZE, VERTEX_SIZE, VERTEX_SIZE, VERTEX_SIZE);
    }

    /**
     * helper method for paint component
     * draws a line on the panel from starting point of edge to ending point
     *
     * @param Edge e that connect its starting point to ending point
     * @param Graphics g used to draw the line
     */
    void paintEdge(Edge e, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Path2D path = new Path2D.Double();
        Vertex firstControlPoint = new Vertex(e.start.x + CURVE_FACTOR, 
            e.start.y + CURVE_FACTOR);
        Vertex secondControlPoint = new Vertex(e.end.x - CURVE_FACTOR, 
            e.end.y + CURVE_FACTOR);
        path.moveTo(e.start.x, e.start.y);
        path.curveTo(firstControlPoint.x, firstControlPoint.y, 
                secondControlPoint.x, secondControlPoint.y,
                e.end.x, e.end.y);

        g2d.draw(path); // Draw the path onto the graphics context
    }

}