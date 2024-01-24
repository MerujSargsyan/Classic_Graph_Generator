/** 
 * A simple class used to position on a display using x and y
 *
 * @author Meruzhan Sargsyan
 */
class Vertex {
    int x;
    int y;

    /**
     * sets instance field to parameters
     *
     * @param int x to set field x to
     * @param int y to set field y to
     */
    Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * overrides the .equals method of superclass Object
     *
     * @param Object o to make comparison with
     * @return boolean if the x and y values of both vertecies are equal
     */
    @Override
    public boolean equals(Object o) {   
        if(o == null) {
            return false;
        }
        return this.x == ((Vertex)o).x && this.y == ((Vertex)o).y;
    }

    /** 
     * overrides the .toString method of superclass Object
     *
     * @return String of the form <x, y>
     */
    @Override
    public String toString() {
        return "<" + this.x + ", " + this.y + ">"; 
    }
}