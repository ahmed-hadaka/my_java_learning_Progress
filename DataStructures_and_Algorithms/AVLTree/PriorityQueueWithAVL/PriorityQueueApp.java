package problems_java_DS.PriorityQueueWithAVL;

public class PriorityQueueApp {
	public static void main(String[] args) {
		PriorityQueue tree = new PriorityQueue();

		tree.enqueue(1131, 1);
		tree.enqueue(3111, 3);
		tree.enqueue(2211, 2);
		tree.enqueue(3161, 3);
		tree.enqueue(7761, 7);
		tree.enqueue(7761, 4);

		System.out.println(tree.dequeue());
		tree.display();
		System.out.println(tree.dequeue());
		tree.display();

		System.out.println();

		tree.enqueue(1535, 1);
		tree.enqueue(2815, 2);
		tree.enqueue(3845, 3);
		tree.enqueue(3154, 3);

		while (!tree.isEmpty())
			System.out.print(tree.dequeue() + " ");
	}
}
