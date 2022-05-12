package Demonstrates_Minimum_Spanning_Tree;

public class Graph {
    private final int MAX_VERTICES = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private PriorityQ priorityQ;
    private int currentVertex;
    private int nVertex;  // current number of vertex
    private int nTree;  // current number of vertices in the tree

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjMat = new int[MAX_VERTICES][MAX_VERTICES];
        priorityQ = new PriorityQ(MAX_VERTICES);
        nVertex = 0;
        nTree = 0;
        for (int i = 0; i < MAX_VERTICES; i++) // fill adjMat
            for (int j = 0; j < MAX_VERTICES; j++)
                adjMat[i][j] = INFINITY;
    }

    public void addVertex(char label) {
        vertexList[nVertex++] = new Vertex(label);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    public void mstw() {
        currentVertex = 0;
        while (nTree < nVertex - 1) {
            vertexList[currentVertex].setInTree(true);
            nTree++;
            for (int i = 0; i < nVertex; i++) { // insert edges adjacent to currentVert into PQ
                if (i == currentVertex)
                    continue;
                if (vertexList[i].isInTree())
                    continue;
                int distance = adjMat[currentVertex][i];
                if (distance == INFINITY)
                    continue;
                putInPQ(i, distance);
            } // end for loop
            if (priorityQ.getSize() == 0) {
                System.out.println("GRAPH NOT CONNECTED");
                return;
            }
            Edge min = priorityQ.removeMin();   // remove edge with minimum distance, from PQ
            int sourceVertex = min.getSrcVertex();
            currentVertex = min.getDesVertex();

            vertexList[sourceVertex].displayLabel(); // display edge from scr to dist
            vertexList[currentVertex].displayLabel();
            System.out.print(" ");
        }
        for (int j = 0; j < nVertex; j++) // unMark vertices
            vertexList[j].setInTree(false);
    }

    public void putInPQ(int newDisVertex, int newDistance) {
        int queueIndex = priorityQ.findDesInd(newDisVertex);
        if (queueIndex != -1) {
            int oldDistance = priorityQ.peekN(queueIndex).getDistance();
            if (oldDistance > newDistance) {
                priorityQ.removeN(queueIndex);  // remove old edge
                Edge newEdge = new Edge(currentVertex, newDisVertex, newDistance);
                priorityQ.insert(newEdge); // insert new edge
            }
        } else {
            Edge newEdge = new Edge(currentVertex, newDisVertex, newDistance);
            priorityQ.insert(newEdge);
        }
    }
}

