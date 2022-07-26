package Demonstrates_Minimum_Spanning_Tree;

public class Vertex {
    private final char LABEL;
    private boolean inTree;

    public Vertex(char LABEL) {
        this.LABEL = LABEL;
        this.inTree = false;
    }

    public boolean isInTree() {
        return inTree;
    }

    public void setInTree(boolean inTree) {
        this.inTree = inTree;
    }

    public void displayLabel() {
        System.out.print(this.LABEL);
    }
}
