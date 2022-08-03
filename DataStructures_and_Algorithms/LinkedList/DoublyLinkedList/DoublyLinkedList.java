package java_DS;

/**
 *
 * @AhmedHadaka
 */
public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int length;

	public boolean isEmpty() {
		return (length < 1);
	}

	private Node getHead() {
		return this.head;
	}

	private Node getTail() {
		return this.tail;
	}

	private void link(Node first, Node second) {
		if (first != null)
			first.setNext(second);
		if (second != null)
			second.setPrevious(first);
	}

	public Node get_nth_front(int n) { // o(n)T, o(1)M
		int ind = 0;
		for (Node cur = head; cur != null; cur = cur.getNext(), ind++)
			if (ind == n)
				return cur;
		return null;
	}

	public void insertFirst(int iData) {
		Node newNode = new Node(iData);
		if (isEmpty()) {
			tail = newNode;
		} else {
			link(newNode, head);
		}
		head = newNode;
		length++;
	}

	public void insertLast(int iData) {
		Node newNode = new Node(iData);
		if (isEmpty()) {
			head = newNode;
		} else {
			link(tail, newNode);
		}
		tail = newNode;
		length++;
	}

	public boolean insertAfter(int key, int iData) {
		Node newNode = new Node(iData);
		Node current = head;
		while (current.getiData() != key) {
			current = current.getNext();
			if (current == null) {
				return false;
			}
		}
		if (current == tail) {
			tail = newNode;
		} else {
			link(newNode, current.getNext());
		}
		link(current, newNode);
		length++;
		return true;
	}

	private void empedAfter(Node before, int data) {
		Node newNode = new Node(data);
		Node after = before.getNext();

		link(before, newNode);
		link(newNode, after);
		length++;
	}

	public void insertSorted(int data) {
		if (isEmpty() || head.getiData() >= data) {
			insertFirst(data);
		} else if (tail.getiData() <= data) {
			insertLast(data);
		} else {
			for (Node cur = head; cur != null; cur = cur.getNext()) {
				if (cur.getiData() >= data) {
					empedAfter(cur.getPrevious(), data);
					break;
				}

			}

		}
	}

	public Node deleteFirst() {
		if (!isEmpty()) {
			Node temp = head;
			head = head.getNext();
			if (head == null) {
				tail = null;
			} else {
				head.setPrevious(null);
			}
			length--;
			return temp;
		}
		return null;
	}

	public Node deleteLast() {
		if (!isEmpty()) {
			Node temp = tail;
			tail = tail.getPrevious();
			if (tail == null) {
				head = null;
			} else {
				tail.setNext(null);
			}
			length--;
			return temp;
		}
		return null;
	}

	private Node delete_and_link(Node cur) {
		Node temp = cur.getPrevious();
		link(cur.getPrevious(), cur.getNext());
		length--;
		return temp;
	}

	public void deleteFirst_with_key(int key) {
		if (!isEmpty()) {
			Node current = head;
			while (current != null && current.getiData() != key) {
				current = current.getNext();
			}
			if (current == null) { // not found
				return;
			}
			if (current == head) { // it's the head
				deleteFirst();
			} else if (current == tail) { // it's the tail
				deleteLast();
			} else { // in the middle
				link(current.getPrevious(), current.getNext());
				length--;
			}
		}
		return;
	}

// *************************** homework easy to medium **************************
	public void deleteAll_with_key(int key) {
		if (isEmpty())
			return;
		for (Node cur = head; cur != null; cur = cur.getNext()) {
			if (cur.getiData() == key) {
				if (cur == head)
					deleteFirst();
				else if (cur == tail)
					deleteLast();
				else {
					cur = delete_and_link(cur);
				}
			}
		}
	}

	public void delete_even_pos() {
		if (this.length < 2)
			return;
		int idx = 1;
		for (Node cur = head; cur != null; cur = cur.getNext(), idx++) {
			if (idx % 2 == 0) {// even
				cur = delete_and_link(cur);
				if (cur.getNext() == null) // move the tail
					tail = cur;
			}
		}
	}

	public void delete_odd_pos() {
		// ********* first logic ***********//
		insertFirst(-1);
		delete_even_pos(); // which is actually odd positions
		deleteFirst();

		// ********* second logic ***********//

//		if (this.length < 2)
//			return;
//		int idx = 2;
//		head = head.getNext();
//		for (Node cur = head; cur != null; cur = cur.getNext(), idx++) {
//			if (idx % 2 != 0) {// even
//				cur = delete_and_link(cur);
//				if (cur.getNext() == null) // move the tail
//					tail = cur;
//			}
//		}
	}

	public boolean isPalindrome() {
		if (length < 2)
			return true;

		// ********* first logic ***********//

		int len = length / 2;
		Node curHead = head, curTail = tail;

		while (len-- > 0) {
			if (curHead.getiData() != curTail.getiData())
				return false;
			curHead = curHead.getNext();
			curTail = curTail.getPrevious();
		}
		return true;

		// ********* second logic ***********//

//		for (Node curHead = head, curTail = tail; curHead.getiData() == curTail.getiData(); curHead = curHead
//				.getNext(), curTail = curTail.getPrevious()) {
//			if (curHead == curTail || curTail.getNext() == curHead) {
//				return true;
//			}
//		}
//		return false;
	}

// *************************** homework medium to hard **************************
	/*
	 * 1) considerations:- 1- don't use length variable 2- don't iterate more than
	 * one
	 * 
	 */
	public int findMiddle() { // with Doubly linked list

		if (isEmpty())
			return -1;
		if (head.getNext() == null) {
			return head.getiData();
		}
		for (Node curHead = head,
				curTail = tail; curHead != null; curHead = curHead.getNext(), curTail = curTail.getPrevious()) {
			if (curHead == curTail || curTail.getNext() == curHead) {
				return curHead.getiData();
			}
		}
		return -1;
	}

	/*
	 * second implementation the idea is simple but smarter:- (from graph theory)
	 * use 2 pointers the first one is slow (it moves one step in every iterate) the
	 * second one is the fast (it moves two steps in every iterate) when the faster
	 * one reach the tail (in the odd length) or null pointer (at the even length)
	 * we Know that the slow pointer now at the middle
	 */
	public int findeMiddle_v2() { // with singly linked list
		if (isEmpty())
			return -1;
		if (head.getNext() == null) {
			return head.getiData();
		}
		Node slow = head, fast = head;
		while (fast != tail && fast != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		return slow.getiData();

	}

// hard one //

	private void swapOverFlowConsecutive(Node lastPrevious, Node last, Node first, Node firstNext) {
		link(lastPrevious, first);
		link(last, firstNext);
		link(first, last);
	}

	private void swapConsecutive(Node firstPrevious, Node first, Node last, Node lastNext) {
		link(firstPrevious, last);
		link(first, lastNext);
		link(last, first);
	}

	private void swapHead_and_tail() {
		Node temp = head;
		link(tail.getPrevious(), head);
		link(tail, head.getNext());
		tail.setPrevious(null);
		head.setNext(null);
		head = tail;
		tail = temp;
	}

	public void swapForward_with_backward(int k) {
		if (k > length)
			return;
		int kthBack = length - k + 1;
		Node first = get_nth_front(k - 1);
		Node last = get_nth_front(kthBack - 1);

		Node firstPrevious = first.getPrevious();
		Node firstNext = first.getNext();

		Node lastPrevious = last.getPrevious();
		Node lastNext = last.getNext();

		if (k == length / 2 + 1) {
			if (length % 2 != 0) { // same node
			} else { // overflow consecutive
				swapOverFlowConsecutive(lastPrevious, last, first, firstNext);
			}
			return;
		}
		if (k == 1 || k == length) {
			swapHead_and_tail();
		} else if (k + 1 == kthBack) { // consecutive
			swapConsecutive(firstPrevious, first, last, lastNext);
		} else {
			firstPrevious.setNext(last);
			firstNext.setPrevious(last);
			last.setNext(firstNext);
			last.setPrevious(first);

			lastPrevious.setNext(first);
			lastNext.setPrevious(first);
			first.setNext(lastNext);
			first.setPrevious(lastPrevious);
		}
		return;
	}

	public void reverseList() {
		if (length < 2)
			return;
		Node temp = head, p2, p1, cur;
		for (p2 = null, p1 = head, cur = p1.getNext(); cur != null; p2 = p1, p1 = cur, cur = cur.getNext()) {
			p1.setNext(p2);
			p1.setPrevious(cur);
		}
		p1.setNext(p2);
		p1.setPrevious(cur);
		// update tail and head
		head = tail;
		tail = temp;
	}

	public void merge_2SortedLists(DoublyLinkedList l1) { // o(n+m) time, where n length of first list and m length of
															// second list
		Node newHead = null, next = null, cur1 = head, cur2 = l1.getHead();
		while (cur1 != null && cur2 != null) {
			if (cur1.getiData() <= cur2.getiData()) {
				if (newHead == null) {
					newHead = cur1;
				} else {
					link(next, cur1);
				}
				next = cur1;
				cur1 = cur1.getNext();

			} else {
				if (newHead == null) {
					newHead = cur2;
				} else {
					link(next, cur2);
				}
				next = cur2;
				cur2 = cur2.getNext();
			}
		}
		head = newHead;
		if (cur1 == null) {
			link(next, cur2);
			tail = l1.getTail();
		} else {
			link(next, cur1);
		}
		length += l1.length;
	}
//***********************************************************************

	@Override
	public String toString() {
		Node current = head;
		StringBuilder result = new StringBuilder("{ ");
		while (current != null) {
			result.append(current.toString());
			current = current.getNext();
		}

		result.append(" }");
		return result.toString();
	}
}
