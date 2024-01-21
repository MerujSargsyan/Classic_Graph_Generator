import java.util.ArrayList;

class CompleteGraph extends Graph {
    private int numVertecies;
    private final int STARTING_ROW = 50;
    private final int STARTING_COL = 50;
    private final int OFFSET = 50;
    private final int MAX_COL = Display.WINDOW_SIZE_X - OFFSET;
    private final int AVAILABLE_SPACES = MAX_COL/OFFSET;

    private int currentCol;
    private int currentRow;

    CompleteGraph(int numVertecies) {
        super();
        this.numVertecies = numVertecies;
        this.currentCol = STARTING_COL;
        this.currentRow = STARTING_ROW;
        this.generateVertecies(numVertecies);
        this.generateEdges();
        this.displayGraph(new Display(this));
        System.out.println(AVAILABLE_SPACES);
    }

    @Override
    void generateVertecies(int numVertecies) {
        int totalCount = numVertecies;
        double neccRowCount = totalCount / AVAILABLE_SPACES;
        double countPerRow = totalCount / Math.floor(neccRowCount);

        int[] rowCounts = new int[(int)neccRowCount];
        if(countPerRow % 10 > 0) {
            rowCounts[0] = (int)Math.ceil(countPerRow);
        } else {
            rowCounts[0] = (int)Math.floor(countPerRow);
        }
        for(int i = 1; i < neccRowCount; i++) {
            rowCounts[i] = (int)Math.floor(countPerRow);
        }
        
        for(int i = 0; i < neccRowCount; i++) {
            int rowSize = rowCounts[i];
            for(int j = 0; j < rowSize; j++) {
                vertecies.add(new Vertex(currentCol + j * OFFSET, 
                    STARTING_ROW + i * OFFSET));
            }
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