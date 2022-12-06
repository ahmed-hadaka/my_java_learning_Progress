package graphRepresentation_Practicing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphRepresentation_AdjHashSet {
	int numVertices;
	List<Set<Integer>> adjHashSet;

	public GraphRepresentation_AdjHashSet(int numVertices) {
		this.numVertices = numVertices;
		adjHashSet = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
			adjHashSet.add(new HashSet<>());
		}
	}

	// un_weighted graph (no multiple edges)

	public void addDirectedEdge(int from, int to) {
		adjHashSet.get(from).add(to);
	}

	public void addUnDirectedEdge(int from, int to) {
		adjHashSet.get(from).add(to);
		adjHashSet.get(to).add(from);
	}

	public void printAdjHashSet() {
		for (int i = 0; i < adjHashSet.size(); i++) {
			System.out.print("Node " + i + " has neibours ");
			for (Integer vertex : adjHashSet.get(i)) {
				System.out.print(vertex + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
