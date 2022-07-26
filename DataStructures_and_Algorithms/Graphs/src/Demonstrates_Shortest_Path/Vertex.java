package Demonstrates_Shortest_Path;

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

    public char getLabel() {
        return LABEL;
    }

    public void displayLabel() {
        System.out.print(this.LABEL);
    }
}
