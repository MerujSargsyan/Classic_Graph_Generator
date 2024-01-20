import java.util.ArrayList;

abstract class Graph {
    ArrayList<Vertex> vertecies;
    ArrayList<Edge> edges;

    Graph() {
        vertecies = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
    }

    abstract void generateVertecies();
    abstract void generateEdges();
    abstract void displayGraph(Display d);
}