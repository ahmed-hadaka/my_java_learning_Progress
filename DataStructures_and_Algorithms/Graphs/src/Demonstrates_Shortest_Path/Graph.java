package Demonstrates_Shortest_Path;

public class Graph {
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private int nTree;
    private Distance_Parent[] sPath;
    private int currentVert;
    private int startToCurrent;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for (int j = 0; j < MAX_VERTS; j++)
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = INFINITY;
        sPath = new Distance_Parent[MAX_VERTS];
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
    }

    public void path() {
        int startTree = 0;
        vertexList[startTree].setInTree(true);
        nTree++;
        for (int i = 0; i < nVerts; i++) {      // transfer row of distances from adjMat to sPath  1
            int tempDest = adjMat[startTree][i];
            sPath[i] = new Distance_Parent(startTree, tempDest);
        }
        while (nTree < nVerts) {
            int indexMin = getMin();
            int minDist = sPath[indexMin].distance;
            if (minDist == INFINITY) {
                System.out.println("There are unreachable vertices");
                break;
            } else {            // reset currentVert to closest vert
                currentVert = indexMin;
                startToCurrent = sPath[indexMin].distance;
            }
            vertexList[currentVert].setInTree(true);
            nTree++;
            adjust_sPath();
        }
        displayPath();
        nTree = 0;          // clear tree
        for (int j = 0; j < nVerts; j++)
            vertexList[j].setInTree(false);
    }

    public int getMin() {
        int minDes = INFINITY;
        int indexMin = 0;
        for (int i = 0; i < nVerts; i++) {
            if (!vertexList[i].isInTree() && sPath[i].distance < minDes) {
                minDes = sPath[i].distance;
                indexMin = i;
            }
        }
        return indexMin;
    }

    public void adjust_sPath() {

        int column = 1;
        while (column < nVerts) {
            if (vertexList[column].isInTree()) {
                column++;
                continue;
            }
            int currentToFringe = adjMat[currentVert][column];
            int startToFringe = startToCurrent + currentToFringe;
            int sPathDist = sPath[column].distance;
            if (startToFringe < sPathDist) { // update sPath
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPath() {
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].getLabel() + "=");
            if (sPath[j].distance == INFINITY)
                System.out.print("inf");
            else
                System.out.print(sPath[j].distance);
            char parent = vertexList[sPath[j].parentVert].getLabel();
            System.out.print("(" + parent + ") ");
        }
    }
}

