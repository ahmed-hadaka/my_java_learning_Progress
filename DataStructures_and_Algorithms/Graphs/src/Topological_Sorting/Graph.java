package Topological_Sorting;

public class Graph {
    private final int MAX_VERTEX = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVertex;
    private char[] sortedArray;

    public Graph() {
        vertexList = new Vertex[MAX_VERTEX];
        adjMat = new int[MAX_VERTEX][MAX_VERTEX];
        nVertex = 0;
        for (int i = 0; i < MAX_VERTEX; i++) // fill adjMat
            for (int j = 0; j < MAX_VERTEX; j++)
                adjMat[i][j] = 0;
        sortedArray = new char[MAX_VERTEX];
    }

    public void addVertex(char label) {
        vertexList[nVertex++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void topologicalSort() {
        int org_nVertex = nVertex;
        while (nVertex > 0) {
            int vertex = noSuccessor();
            if (vertex == -1) {
                System.out.println("ERROR:Graph has cycles");
                return;
            }
            sortedArray[nVertex - 1] = vertexList[vertex].getLabel();
            deleteVertex(vertex);
        }
        System.out.print("Topologically sorted order: ");
        for (int j = 0; j < org_nVertex; j++)
            System.out.print(sortedArray[j]);
        System.out.println();
    }

    public int noSuccessor() {
        boolean flag;
        for (int row = 0; row < nVertex; row++) {
            flag = false;
            for (int column = 0; column < nVertex; column++) {
                if (adjMat[row][column] == 1) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return row;
        }
        return -1;
    }

    public void deleteVertex(int vertex) {
        if (vertex != nVertex - 1) {
            for (int i = vertex; i < nVertex - 1; i++)  // delete from vertexList
                vertexList[i] = vertexList[i + 1];
            for (int i = vertex; i < nVertex - 1; i++)   // shift rows
                moveRowUp(vertex, nVertex);
            for (int i = 0; i < nVertex - 1; i++)  // shift columns
                moveColumnLeft(vertex, nVertex - 1);
        }
        nVertex--;
    }

    public void moveRowUp(int vertex, int length) {
        for (int column = 0; column < length; column++)
            adjMat[vertex][column] = adjMat[vertex + 1][column];
    }

    public void moveColumnLeft(int vertex, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][vertex] = adjMat[row][vertex + 1];
        }
    }

}

