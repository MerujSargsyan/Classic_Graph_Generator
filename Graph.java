import java.util.ArrayList;

abstract class Graph {
    ArrayList<Vertex> vertecies;
    ArrayList<Edge> edges;

    Graph() {
        vertecies = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
    }

    abstract void generateVertecies(int numVertecies);
    abstract void generateEdges();
    abstract void displayGraph(Display d);

    void printVertecies() {
        for(Vertex v : vertecies) {
            System.out.println(v);
        }
    }

    void printEdges() {
        for(Edge e : edges) {
            System.out.println(e);
        }
    }
}