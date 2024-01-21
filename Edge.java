class Edge {
    Vertex start;
    Vertex end;

    Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Edge)) {
            return false;
        }
        Edge e = (Edge)o;
        return start.equals(e.start) && end.equals(e.end) || 
            end.equals(e.start) && start.equals(e.end);
    }

    @Override
    public String toString() {
        return start.toString() + " --> " + end.toString();
    }
}