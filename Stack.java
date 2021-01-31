//-----------------------------------------------------
// Title: Stack
// Author: Ömer Görkem Canıdemir
// ID: 13177246034
// Section: 2
// Assignment: 1 Part_2
// Description: This class defines a Stack object.
//-------------------------------------------------

public class Stack<Item> {
	private Node first = null;
	private int size = 0;
        private int a ;
	protected class Node {
		Item item;
		Node next;

		public Item getItem() {
			return item;
		}

		public Node getNext() {
			return next;
		}

	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		size++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		size--;
		return item;
	}

	public int getSize() {
		return size;
	}

	public Node getFirst() {
		return first;
	}

}
