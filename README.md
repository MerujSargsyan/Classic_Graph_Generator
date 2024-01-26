# Classic_Graph_Generator
<h3>Generates classic graphs in graph theory such as connected graphs, trees, de Brujin cycles, etc.</h3>

<p>
Brief Class explainations: <br>
    - Display.java:   Creates a square display with black background. Then uses DrawPanel.java to draw given vertecies and edges. <br>
    - DrawPanel.java: Helper class for display which uses java swing Graphics to draw on Display. <br>
    - Graph.java:     Abstract class which sets a basis for all other child graphs. Stroes vertex and edge sets. <br>
    - Vertex.java:    Simple way to store x and y position to draw on Display. <br>
    - Edge.java:      Simple way to store connections between two vertecies. <br>
<br>
Graph explainations: <br>
    - CompleteGraph.java: <br> 
              A complete graph is a graph where given a certain number of vertecies, every vertex <br>
              is connected to every other vertex via and edge. <br>
    - CompleteBipartiteGraph.java: <br>
              A Complete Bipartite Graph is similar to a complete Graph, however, vertecies are separated <br>
              into two groups A and B. There are no edges between vertecies of the same group. <br>
</p>
