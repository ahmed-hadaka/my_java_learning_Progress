package topologicalSortingLeetcode;

public class test {

	public static void main(String[] args) {
		int[][] targetGrid = { { 1, 1, 1, 1 }, { 1, 2, 2, 1 }, { 1, 2, 2, 1 }, { 1, 1, 1, 1 } };
		StrangegePrinterII strangegePrinterII = new StrangegePrinterII();
		System.out.println(strangegePrinterII.isPrintable(targetGrid));
	}
}
