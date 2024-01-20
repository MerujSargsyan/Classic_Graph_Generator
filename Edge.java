class Edge {
    Vertex start;
    Vertex end;

    Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        return start.equals(end) || end.equals(start);
    }
}