package graphRepresentation_Practicing;

/*
 * Space: o(v^2)
 * Time: check if there is an edge(u, v) or not -> o(1)
 * Time: list all the neighbors of node u -> o(v), iterate over the row
 * Time: traverse the whole graph -> o(v^2)
 * Good for Dense Graph
*/
public class GraphRepresentation_adjMatrix {
	int numVertices;
	int[][] adjMatrix;

	public GraphRepresentation_adjMatrix(int numVertices) {
		this.numVertices = numVertices;
		adjMatrix = new int[numVertices][numVertices];
	}

	// un_weighted graphs ( multi_edges)

	public void addDirectedEdge(int from, int to) {
		adjMatrix[from][to] += 1;
	}

	public void addUnDirectedEdge(int from, int to) {
		adjMatrix[from][to] += 1;
		adjMatrix[from][to] += 1;
	}

	public void printAdjMatrix() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[0].length; j++) {
				if (adjMatrix[i][j] != 0) {
					System.out.println("From " + i + " to " + j + " there are " + adjMatrix[i][j] + " edges .");
				}
			}
		}
		System.out.println();
	}

	// weighted graphs ( single edge )
	public void addDirectedEdgeWeighted(int from, int to, int cost) {
		adjMatrix[from][to] = cost;
	}

	public void addUnDirectedEdgeWeighted(int from, int to, int cost) {
		adjMatrix[from][to] = cost;
		adjMatrix[from][to] = cost;
	}

	public void printAdjMatrixWeighted() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[0].length; j++) {
				if (adjMatrix[i][j] != 0) {
					System.out.println("From " + i + " to " + j + " cost " + adjMatrix[i][j]);
				}
			}
		}
	}
}
