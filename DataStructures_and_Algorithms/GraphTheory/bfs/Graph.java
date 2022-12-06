package bfs;

public class Graph {
	private final int MAX_VERTEX = 20;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVertex;
	Queue theQueue;

	public Graph() {
		vertexList = new Vertex[MAX_VERTEX];
		adjMat = new int[MAX_VERTEX][MAX_VERTEX];
		nVertex = 0;
		theQueue = new Queue(MAX_VERTEX);
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

	public void bfs() {
		int v2;
		vertexList[0].setWasVisited(true);
		vertexList[0].displayLabel();
		theQueue.insert(0);

		while (!theQueue.isEmpty()) {
			int v1 = theQueue.remove();
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].setWasVisited(true);
				vertexList[v2].displayLabel();
				theQueue.insert(v2);
			}
		}
		for (int i = 0; i < nVertex; i++) // reset visited
			vertexList[i].setWasVisited(false);
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int i = 0; i < MAX_VERTEX; i++)
			if (adjMat[v][i] == 1 && !vertexList[i].isWasVisited())
				return i;
		return -1;
	}
}
