package java_DS;

/**
 *
 * @AhmedHadaka
 */
public class DoublyLinkedListApp {

	public static void main(String[] args) {
		DoublyLinkedList theList = new DoublyLinkedList();
		theList.insertLast(10);
		theList.insertLast(20);
		theList.insertLast(30);
//
//		theList.insertLast(40);
//		theList.insertLast(50);
//		theList.insertLast(55);

		DoublyLinkedList l1 = new DoublyLinkedList();
		l1.insertLast(15);
		l1.insertLast(17);
		l1.insertLast(22);

		l1.insertLast(24);
		l1.insertLast(35);
		l1.insertLast(46);
		l1.insertLast(49);

		System.out.println(theList.toString());
		System.out.println(l1.toString());

		theList.merge_2SortedLists(l1);

		System.out.println(theList.toString());
		System.out.println(l1.toString());
	}
}
