/**
 * The purpose of this class is to set up a basis for other graphs. It creates
 * arrays of vertecies and edges that describe the graph. Further children
 * implement how to add edges and vertecies
 *
 * @author Meruzhan Sargsyan  
 */

import java.util.ArrayList;

abstract class Graph {
    ArrayList<Vertex> vertecies;
    ArrayList<Edge> edges;

    /** 
     * simply initalizes the arrays
     */
    Graph() {
        vertecies = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
    }

    /** 
     * abstract method which children must implement to generate the vertecies
     * of the graph
     *
     * @param numVertecies number of vertecies the graph needs 
     */
    abstract void generateVertecies(int numVertecies);

    /** 
     * abstract method which chidlren must implement to generate the edges
     * of the graph
     */
    abstract void generateEdges();

    /**
     * basic method to display a Graph, using a Display object 
     *
     * @param Display to use to show graph
     * @param Graph graph to show on display
     */
    void displayGraph(Display d, Graph g) {
        d.display(g);
    }

    /** 
     * method to help with debugging
     * prints out vertecies using its individual toString method 
     */
    void printVertecies() {
        for(Vertex v : vertecies) {
            System.out.println(v);
        }
    }

    /** 
     * method to help with debugging
     * prints out edges using its individual toString method
     */
    void printEdges() {
        for(Edge e : edges) {
            System.out.println(e);
        }
    }
}