import java.util.ArrayList;

class BipartiteGraph extends Graph {
    private int Asize;
    private int Bsize;

    private final int COL1POS = 100;
    private final int COL2POS = 200;
    private final int STARTING_ROW = 50;
    private final int ROW_SPACING = 50;

    BipartiteGraph(int Asize, int Bsize, ArrayList<Edge> edges) {
        super();
        this.Asize = Asize;
        this.Bsize = Bsize;
        this.edges = edges;
        generateVertecies(Asize + Bsize);
    }

    @Override
    void generateVertecies(int numVertecies) {
        int currentRow = STARTING_ROW;
        for(int i = 0; i < Asize; i++) {
            vertecies.add(new Vertex(COL1POS, currentRow));
            currentRow += ROW_SPACING;
        }
        currentRow = STARTING_ROW;
        for(int i = 0; i < Bsize; i++) {
            vertecies.add(new Vertex(COL2POS, currentRow));
            currentRow += ROW_SPACING;
        }

    } 

    @Override 
    void generateEdges() {}; // does nothing

}