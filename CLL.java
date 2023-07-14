package com.LL;

public class CLL {

	private Node head;
	private Node tail;

	public CLL() {
		this.head = null;
		this.tail = null;
	}

	// Insertion at first
	public void insert(int val) {
		Node node = new Node(val);
		Node temp = head;
		if (head == null) {
			head = node;
			//tail = node;
			node.next = node;
			return;
		}
		// tail.next = node;
		while (temp.next != head) {
			temp = temp.next;
		}
		node.next = head;
		temp.next = node;
		head = node;
	}

	// Insertion at last
	public void insertionLast(int val) {

		Node node = new Node(val);

		// if list is empty, newnode is the first node and make it circular
		if (isEmpty()) {
			head = node;
			node.next = head;
		}

		Node temp = head;

		while (temp.next != head) {
			temp = temp.next;
		}
		node.next = head;
		temp.next = node;

	}

	// Insert at position
	public void insertAtPos(int val, int pos) {

		Node node = new Node(val);
		System.out.println("Hii");
		// if list is empty, add node at start
		// if pos<=1, add node at start
		if (head == null || pos <= 1) {
			System.out.println("Hii");
			insert(val);
		} else {
			Node temp = head;
			for (int i = 0; i < pos - 1; i++) {
				// if pos>length of list, add node at the end
				//it stops if either the end of the list is reached
				// if the desired position exceeds the length of the list.
				if (temp.next == head)
					break;

				
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
		}
	}

	private boolean isEmpty() {
		return head == null;
	}
	
	public void deleteFirst() {
	
		//if list is empty
		if(isEmpty()) {
			throw new RuntimeException("list is empty");
		}
		//if there is single node them make head = null
		if(head.next==head) {
			head=null;
		}
		Node trav = head;
		//traverse till last node
		while(trav.next!=head) {
			trav = trav.next;
		}
		head = head.next; //take head to next node
		trav.next = head;
		
	}
	
	//Delete at Position
	public void deletePosition(int pos) {
		Node temp = null;
		Node trav = head;
		
		//if first node , delte first node
		if(pos==1) {
			deleteFirst();
		}
		
		//if list is empty or pos<1, then throw exception
		if(head==null || pos<1) {
			throw new RuntimeException("List is empty or invald positon");
		}
		
		for(int i = 1;i<pos;i++) {
			temp = trav;
			trav = trav.next;
			//if position beyond list length throw exc
			if(trav.next==head) {
				throw new RuntimeException("Invalid position");
			}
		}
		temp.next = trav.next;
	}
	
	//Delete at last
	public void deleteLast() {
		
		if(isEmpty()) {
			throw new RuntimeException("List is empty nothing to delete");
		}
		//if there is only single node
		if(head.next==head) {
			head=null;
			return;
		}
		
		Node trav = head;
		Node temp = null;
		while(trav.next!=head) {
			temp = trav;
			trav = trav.next;
		}
		temp.next = head;	
	}
	
	//delete all3
	public void deleteAll() {
		head.next = null;
		head=null;
	
	//	tail=null;
	}
	

	// Display
	public void display() {
		Node node = head;
		if (head == null) {
			throw new RuntimeException("List is empty, pls add element");
		}
		// The do-while loop ensures that the loop body is executed at least once,
//			allowing us to print the value of the head node before checking the 
//			condition
		do {
			System.out.print(node.val + "-->");
			node = node.next;
		} while (node != head);

	}

	private class Node {
		private int val;
		private Node next;

		public Node(int val) {

			this.val = val;
		}

	}
}
