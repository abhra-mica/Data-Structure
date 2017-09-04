package Linked_List;

public class LinkedList<T> {
	public  Node head;

	public static class Node<T> {
		T data;
		Node next;
		Node(T data) {
			this.data = data;
		}
	}

	//No argument constructor
	public LinkedList() {
		super();
	}

	//Argumented constructor
	public LinkedList(Node head) {
		this.head = head;
	}

	// 1> add new node at the end of the linked list
	public void add(T newData) {
		Node temp = new Node(newData);
		if (head == null)
			head = temp;
		else {
			Node node = head;
			while (node.next != null)
				node = node.next;
			node.next = temp;
		}
	}

	// 1a> recursively add nodes
	void addRecursive(T data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node node = head;
		recursiveSupport(node, data);
	}

	// Suportive method for addRecursive
	void recursiveSupport(Node node, T data) {
		if (node.next == null) {
			node.next = new Node(data);
			return;
		}
		recursiveSupport(node.next, data);
	}

	// 1b> add node in particular position
	void add(T data, int position) {
		Node node = head;
		int count = 0;
		while (count != position) {
			node = node.next;
			count++;
		}
		Node temp = node.next;
		node.next = new Node(data);
		node.next.next = temp;
	}

	// 2> display linked list
	public static void display(Node node) {
		if (node != null)
			System.out.print(node.data);
		else
			return;
		if (node.next != null)
			System.out.print(" --> ");
		display(node.next);
	}

	// 3> delete a node from last
	void delete() {
		if (head == null) {
			System.out.println("Empty list");
			return;
		}

		if (head.next == null)
			head = null;
		Node node = head;
		while (node.next.next != null) {
			node = node.next;
		}
		node.next = null;
	}

	// 4> Reverse a linked list in a iterative way
	Node reverseItr(Node node) {
		Node prev = null;
		Node current = head;
		Node nextEle = null;
		while (current != null) {
			nextEle = current.next;
			current.next = prev;
			prev = current;
			current = nextEle;
		}
		head = prev;
		return head;
	}

	// 5> Reverse A linked list in a recursive way
	public  Node reverseRec(Node node) {
		if (node.next == null) {
			head = node;
			return head;
		}
		reverseRec(node.next);
		Node temp = node.next;
		temp.next = node;
		node.next = null;
		return head;
	}

	// 6>Size of linked list
	public int size() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

}
