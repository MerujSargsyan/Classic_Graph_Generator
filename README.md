# Classic_Graph_Generator
Generates classic graphs in graph theory such as connected graphs, trees, de Brujin cycles, etc.

Brief Class explainations: 
    - Display.java:   Creates a square display with black background. Then uses DrawPanel.java to draw given vertecies and edges.
    - DrawPanel.java: Helper class for display which uses java swing Graphics to draw on Display
    - Graph.java:     Abstract class which sets a basis for all other child graphs. Stroes vertex and edge sets.
    - Vertex.java:    Simple way to store x and y position to draw on Display.
    - Edge.java:      Simple way to store connections between two vertecies

Graph explainations:
    - CompleteGraph.java: 
              A complete graph is a graph where given a certain number of vertecies, every vertex 
              is connected to every other vertex via and edge.
    - CompleteBipartiteGraph.java:
              A Complete Bipartite Graph is similar to a complete Graph, however, vertecies are separated 
              into two groups A and B. There are no edges between vertecies of the same group.
                
