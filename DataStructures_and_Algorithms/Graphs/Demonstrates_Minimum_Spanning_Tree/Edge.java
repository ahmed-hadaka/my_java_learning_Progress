package Demonstrates_Minimum_Spanning_Tree;

public class Edge {
    private final int SRC_VERTEX;
    private final int DEST_VERTEX;
    private final int DISTANCE;

    public Edge(int srcVertex, int desVertex, int distance) {
        this.SRC_VERTEX = srcVertex;
        this.DEST_VERTEX = desVertex;
        this.DISTANCE = distance;
    }

    public int getSrcVertex() {
        return SRC_VERTEX;
    }

    public int getDesVertex() {
        return DEST_VERTEX;
    }

    public int getDistance() {
        return DISTANCE;
    }

}
