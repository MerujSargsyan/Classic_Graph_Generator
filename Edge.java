/** 
 * simple base class to create edges between vertecies
 *
 * @author Meruzhan Sargsyan
 */
class Edge {
    Vertex start;
    Vertex end;

    /** 
     * sets instance fields to parameters
     * Note: the start and end can be swapped since it is not a digraph
     * 
     * @param start starting vertex of the edge
     * @param end ending vertex of the edge
     */
    Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    /** 
     * overrides the .equals method of the superclass Object
     *
     *
     * @param Object o to compare to
     * @return true if the vertecies are equal or start = end and end = start
     */
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Edge)) {
            return false;
        }
        Edge e = (Edge)o;
        return start.equals(e.start) && end.equals(e.end) || 
            end.equals(e.start) && start.equals(e.end);
    }

    /** 
     * overrides the .toString method of the superclass Object
     *
     * @return String of the form: <startX, startY> --> <endX, endY>
     */
    @Override
    public String toString() {
        return start.toString() + " --> " + end.toString();
    }
}