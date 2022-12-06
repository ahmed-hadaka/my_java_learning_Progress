package graphRepresentation_Practicing;

import java.util.ArrayList;
import java.util.List;

/*
 * Program to represent an Image (which is 2D array) as a graph
*/
public class ImageAsGraph {
	int numVertices;
	List<List<Integer>> adjList;

	public ImageAsGraph(int numVertices) {
		this.numVertices = numVertices;
		adjList = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	public void addDirectedEdge(int from, int to) {
		adjList.get(from).add(to);
	}

	public void printGraph() {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print("Node " + i + " has neibours ");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void buildGraphFrom2DArray(int rows, int cols) {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int curCell = i * cols + j; // flatten to 1D array
				buildHelper(curCell, i, j, cols, rows);
			}
		}

	}

	private void buildHelper(int from, int i, int j, int cols, int rows) {
		int[] dirI = { -1, 1, 0, 0 }; // up, down, right, left
		int[] dirJ = { 0, 0, 1, -1 };
		int tempI = i, tempJ = j, to;
		for (int k = 0; k < 4; k++) {
			i = tempI + dirI[k];
			j = tempJ + dirJ[k];
			if (i < rows && i >= 0 && j < cols && j >= 0) { // check boundaries
				to = i * cols + j;
				addDirectedEdge(from, to);
			}
		}
	}

}
