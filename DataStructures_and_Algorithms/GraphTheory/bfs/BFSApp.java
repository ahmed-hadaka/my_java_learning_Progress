package bfs;

/*
 * demonstrates breadth-first search (undirected, unweighted)
 *
 * @ Ahmed_Hadaka
 * */
public class BFSApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 (start for dfs)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(3, 4); // DE
		System.out.println("Visits: ");
		theGraph.bfs(); // depth-first search
	}
}
