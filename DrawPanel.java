import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

class DrawPanel extends JPanel {
    ArrayList<Vertex> vertecies;
    ArrayList<Edge> edges;
    
    private JLabel text;
    private final int TEXT_WIDTH = 100;
    private final int TEXT_HEIGHT = 50;
    private final int TEXT_POSITION = 50; //X and Y offset

    private final int VERTEX_SIZE = 25;
    private final int CENTER_ADJUSTMENT = 12; //adjust circle around vertex

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

    void paintVertex(Vertex v, Graphics g) {
        g.fillRoundRect(v.x - CENTER_ADJUSTMENT, v.y - CENTER_ADJUSTMENT, 
            VERTEX_SIZE, VERTEX_SIZE, VERTEX_SIZE, VERTEX_SIZE);
    }

    void paintEdge(Edge e, Graphics g) {
        g.drawLine(e.start.x, e.start.y, e.end.x, e.end.y);
    }

}