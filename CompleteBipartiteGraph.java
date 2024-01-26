/** 
* This graph extends the graph superclass to implement a unique type of classic
* graph. This graph has to parts: A and B. All vertecies in A is connected to
* all vertecies in B.
*
* HOWEVER: The key feature of this graph is that no two vertecies in A share an
*          edge and no two vertecies in B share an edge.
*
* @author Meruzhan Sargsyan
*/
import java.util.ArrayList;
import java.lang.Exception;

class CompleteBipartiteGraph extends Graph {
    private int Asize;
    private int Bsize;

    private final int COL1POS = 100;
    private final int COL2POS = 200;
    private final int STARTING_ROW = 50;
    private final int ROW_SPACING = 50;

    /** 
     * Constructor that creates an instance of superclass Graph and initializes
     * field variables. 
     *
     * Calls generateVertecies and generateEdges and displayGraph
     *
     * @param Asize int size of part A (left column)
     * @param Bsize int size of part B (right column)
     */
    CompleteBipartiteGraph(int Asize, int Bsize) throws Exception{
        super();
        if(Asize > 10 || Bsize > 10) {
            System.out.println("Please limit the groups to up to 10 vertecies");
            throw new Exception("Invalid Input");
        }
        this.Asize = Asize;
        this.Bsize = Bsize;
        generateVertecies(Asize + Bsize);
        generateEdges();
        displayGraph(new Display(this), this);
    }

    /** 
     * Generates vertecies into two separate columns.
     * Part A is on the left column, Part B is on the right column.
     *
     * @param numVertecies int irrelevent in this method
     */
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

    /** 
    * Connects all vertecies in Part A to all vertecies in Part B
    */
    @Override 
    void generateEdges() {
        for(int i = 0; i < Asize; i++) {
            for(int j = Asize; j < vertecies.size(); j++) {
                edges.add(new Edge(vertecies.get(i), vertecies.get(j)));
            }
        }
    }

}