package graphRepresentation_Practicing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* 
  In the airports, there are many flights (from, to, cost)
 Where from and to are strings (no spaces) and cost is an integer value
 Represent the directed graph based on adjacency style
 There are multiple edges
 Your print function must do the following:
 Flights from are printed sorted (alphabetical order)
 For each from airport: print the to cities based on
 alphabetical order
 If there is a tie, the one with smaller cost first

*/
public class AdjacencyBasedRepr_Flights {

	private class Edge implements Comparable<Edge> {
		String to;
		int cost;

		public Edge(String to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e1) {
			if (this.to.compareTo(e1.to) == 0) {
				if (this.cost > e1.cost)
					return 1;
				return -1;
			} else {
				return this.to.compareTo(e1.to);
			}
		}
	}

	Map<String, List<Edge>> adjList;

	public AdjacencyBasedRepr_Flights() {
		adjList = new TreeMap<>();
	}

	public void addDirectedEdgeWeighted(String from, String to, int cost) {
		if (adjList.containsKey(from)) {
			adjList.get(from).add(new Edge(to, cost));
		} else {
			List<Edge> list = new ArrayList<>();
			list.add(new Edge(to, cost));
			adjList.put(from, list);
		}
	}

	public void printAdjListWeighted() {
		for (Map.Entry<String, List<Edge>> entry : adjList.entrySet()) {
			String key = entry.getKey();
			List<Edge> val = entry.getValue();
			Collections.sort(val);
			System.out.println("Flight from " + key + " : ");
			for (Edge edge : val) {
				System.out.println("\t To " + edge.to + " with cost " + edge.cost);
			}
		}
	}
//
// input:

	// 9
// California Texas 30
// California Texas 10
// Florida California 70
// California Florida 75
// NewYork California 35
//Pennsylvania Florida 18
//Pennsylvania Florida 28
//California Texas 35
//California Pennsylvania 37

	// output:

//Flight from California : 
//	 To Florida with cost 75
//	 To Pennsylvania with cost 37
//	 To Texas with cost 10
//	 To Texas with cost 30
//	 To Texas with cost 35
//Flight from Florida : 
//	 To California with cost 70
//Flight from NewYork : 
//	 To California with cost 35
//Flight from Pennsylvania : 
//	 To Florida with cost 18
//	 To Florida with cost 28	
//
}
