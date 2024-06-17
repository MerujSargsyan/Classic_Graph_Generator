/**
 * A classic graph that has a specific name where every vertex is connected to
 * every other vertex. 
 *
 * Ex: V = {1, 2, 3} E = {{1,2}, {1,3}, {2,3}}
 *
 * @author Meruzhan Sargsyan
 */
import java.util.ArrayList;

class CompleteGraph extends Graph {
    private int numVertecies;
    private final int STARTING_ROW = 50;
    private final int STARTING_COL = 50;
    private final int OFFSET = 50;
    private final int MAX_COL = Display.WINDOW_SIZE_X - OFFSET;

    /**
     * uses superclass constructor to initialize vertex and edge ArrayLists
     * uses helper method to generate vertecies and edges and initializes the
     *    display
     *
     * @param numVertecies int number of vertecies in the vertex set
     */
    CompleteGraph(int numVertecies) {
        super();
        this.numVertecies = numVertecies;
        generateVertecies(numVertecies);
        generateEdges();
        displayGraph(new Display(this), this);
    }

    /** 
     * overrides the generateVertecies method of the Graph superclass
     * creates the vertex set by taking the numVertecies and arranging them on
     * the grid of display
     *
     * @param numVertecies int number of vertecies that should be in the vertex
     *    set
     */
    @Override
    void generateVertecies(int numVertecies) {
        int[] divisors = getDivisors(numVertecies);

        double currentClosest = Integer.MAX_VALUE; // aspect ratio closest to 1

        int rows = 0;
        int cols = 0;

        for(int i = 0; i < divisors.length; i++) {
            double tempR = numVertecies / divisors[i];
            double tempC = numVertecies / tempR;
            double aspectRatio = tempC / tempR;

            if(Math.abs(aspectRatio - 1) < currentClosest) {
                currentClosest = Math.abs(aspectRatio-1);
                rows = (int)Math.round(tempR);
                cols = (int)Math.round(tempC);
            }
        }

        //prime number of vertecies
        if(divisors[0] == 1 && divisors[1] == numVertecies && numVertecies != 2) 
        {
            vertecies.add(new Vertex(STARTING_COL + (cols + 
                (numVertecies / 10 + 1)) * OFFSET, + STARTING_ROW));
            generateVertecies(numVertecies - 1);
            return;
        }


        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                vertecies.add(new Vertex(STARTING_COL + j * OFFSET, 
                    STARTING_ROW + i * OFFSET));
            }
        }

    }

    /**
     * helper method for positioning vertecies
     * returns an array of the divisors of the parameter
     *
     * @param num int number to find all divisors of  
     */
    int[] getDivisors(int num) {
        ArrayList<Integer> listOut = new ArrayList<>();
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                listOut.add(i);
            }
        }
        

        int[] resultArray = new int[listOut.size()];
        for (int i = 0; i < listOut.size(); i++) {
            resultArray[i] = listOut.get(i);
        }

        return resultArray;
    }

    /** 
     * overrides the generateEdges method of the Graph superclass
     * creates edges from every vertex to every other vertex (without duplicates)
     */
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
}
