import java.util.ArrayList;

class CompleteGraph extends Graph {
    private int numVertecies;
    private final int STARTING_ROW = 50;
    private final int STARTING_COL = 50;
    private final int OFFSET = 50;
    private final int MAX_COL = Display.WINDOW_SIZE_X - OFFSET;

    CompleteGraph(int numVertecies) {
        super();
        this.numVertecies = numVertecies;
        this.generateVertecies(numVertecies);
        this.generateEdges();
        this.displayGraph(new Display(this));
    }

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

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                vertecies.add(new Vertex(STARTING_COL + j * OFFSET, 
                    STARTING_ROW + i * OFFSET));
            }
        }
    }

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