package graphRepresentation_Practicing;

import java.util.ArrayList;
import java.util.List;

/*
 * a program that reads a directed un_weighted graph
 * The graph represents a chain: a sequence of vertices from one vertex to another using the
 * edges
 * Then read integer Q, for number of queries, then read Q integers. Each query
 * is a node number; we want to list the path start from it until the last possible
 * node
*/
public class PrintChains {
	int numVertices;
	List<List<Integer>> adjList;

	public PrintChains(int numVertices) {
		this.numVertices = numVertices;
		adjList = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	public void addDirectedEdge(int from, int to) {
		adjList.get(from).add(to);
	}

	public void printAdjList() {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print("Node " + i + " has neibours ");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printChain(int from) {
		System.out.print(from);
		if (adjList.get(from).isEmpty())
			return;
		printChain(adjList.get(from).get(0));
	}

	/*
	 * 6 9 2 1 2 5 2 0 2 3 0 5 1 4 5 4 4 3 4 2 0 5 4 1 4 3 1 4 2 2 1 4 2 5 4 2 0 5 4
	 * 2 1 4 2 5 4 2 0 4 2 3 5 4 3 5 4 2
	 */
	// Print Paths of length 2
	public void printPathLength2() {
		for (int i = 0; i < adjList.size(); i++) {
			List<Integer> l1 = adjList.get(i);
			for (int j = 0; j < l1.size(); j++) {
				List<Integer> l2 = adjList.get(l1.get(j));
				if (!l2.isEmpty()) {
					for (int k = 0; k < l2.size(); k++) {
						System.out.println(i + " " + l1.get(j) + " " + l2.get(k));
					}
				}
			}
		}
	}
}
