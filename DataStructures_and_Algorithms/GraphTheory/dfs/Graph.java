package dfs;

public class Graph {
	private final int MAX_VERTEX = 20;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVertex;
	StackX theStack;

	public Graph() {
		vertexList = new Vertex[MAX_VERTEX];
		adjMat = new int[MAX_VERTEX][MAX_VERTEX];
		nVertex = 0;
		theStack = new StackX(MAX_VERTEX);
		for (int i = 0; i < MAX_VERTEX; i++) // fill adjMat
			for (int j = 0; j < MAX_VERTEX; j++)
				adjMat[i][j] = 0;
	}

	public void addVertex(char label) {
		vertexList[nVertex++] = new Vertex(label);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void dfs() {
		vertexList[0].setWasVisited(true);
		vertexList[0].displayLabel();
		theStack.push(0);

		while (!theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1)
				theStack.pop();
			else {
				vertexList[v].setWasVisited(true);
				theStack.push(v);
				vertexList[v].displayLabel();
			}
		}
		for (int i = 0; i < nVertex; i++) { // reset visited
			vertexList[i].setWasVisited(false);
		}
	}

	public void mst() {
		vertexList[0].setWasVisited(true);
		theStack.push(0);
		while (!theStack.isEmpty()) {
			int currentVertex = theStack.peek();
			int v = getAdjUnvisitedVertex(currentVertex);
			if (v == -1)
				theStack.pop();
			else {
				vertexList[v].setWasVisited(true);
				theStack.push(v);
				vertexList[currentVertex].displayLabel();
				vertexList[v].displayLabel();
				System.out.println();
			}
		}
		for (int i = 0; i < nVertex; i++) { // reset visited
			vertexList[i].setWasVisited(false);
		}
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int i = 0; i < MAX_VERTEX; i++)
			if (adjMat[v][i] == 1 && !vertexList[i].isWasVisited())
				return i;
		return -1;
	}
}
