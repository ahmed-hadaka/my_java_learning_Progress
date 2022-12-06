package graphRepresentation_Practicing;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		PrintChains printChains = new PrintChains(nodes);
		int from, to;
		while (edges-- > 0) {
			from = sc.nextInt();
			to = sc.nextInt();
			printChains.addDirectedEdge(from, to);
		}
		printChains.printPathLength2();
		sc.close();

	}
}
