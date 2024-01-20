class Vertex {
    int x;
    int y;

    Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {   
        if(o == null) {
            return false;
        }
        return this.x == ((Vertex)o).x && this.y == ((Vertex)o).y;
    }
}