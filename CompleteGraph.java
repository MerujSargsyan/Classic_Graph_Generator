import java.util.ArrayList;

class CompleteGraph extends Graph {
    private int numVertecies;
    private final int startingRow = 50;
    private final int startingCol = 50;
    private final int offset = 50;

    private int currentCol;
    private int currentRow;

    CompleteGraph(int numVertecies) {
        super();
        this.numVertecies = numVertecies;
        this.currentCol = 50;
        this.currentRow = 50;
        this.generateVertecies();
        this.generateEdges();
        this.displayGraph(new Display(this));
    }

    @Override
    void generateVertecies() {
        int resetColumn = currentCol;
        int topHalf = numVertecies/2;
        for(int i = 0; i < topHalf; i++) {
            vertecies.add(new Vertex(currentCol, currentRow));
            currentCol += offset;
        }
        currentRow += 50;
        for(int i = 0; i < numVertecies - topHalf; i++) {
            vertecies.add(new Vertex(resetColumn, currentRow));
            resetColumn += offset;
        }
    }

    @Override 
    void generateEdges() {
        for(Vertex v0 : vertecies) {
            for(Vertex vi : vertecies) {
                if(!v0.equals(vi)) {
                    Edge newEdge = new Edge(v0, vi);
                    if(!edges.contains(newEdge)) {
                        edges.add(new Edge(v0, vi));
                    }
                }
            }
        }
    }

    @Override
    void displayGraph(Display d) {
        d.showDisplay();
    }
}