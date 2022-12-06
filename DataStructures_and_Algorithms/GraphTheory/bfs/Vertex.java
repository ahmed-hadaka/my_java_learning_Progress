package bfs;

public class Vertex {
	private final char label;
	private boolean wasVisited;

	public Vertex(char label) {
		this.label = label;
		wasVisited = false;
	}

	public boolean isWasVisited() {
		return wasVisited;
	}

	public void setWasVisited(boolean wasVisited) {
		this.wasVisited = wasVisited;
	}

	public void displayLabel() {
		System.out.print(this.label);
	}
}
