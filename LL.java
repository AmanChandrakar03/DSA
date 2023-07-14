package com.LL;

public class LL {

	private Node head;
	private Node tail;
	
	private int size;
	public LL() {
		this.size=0;
	}
	
	//Insertion at first
	public void insertFirst(int val) {
		Node node = new Node(val); //create a new node
		node.next = head; //this node point to head
		head = node; //head always point to first node
		
		if(tail==null) {  //empty list so
			tail = head; 
		}
		size++;
	}
	//insertion at last
	public void insertLast(int val) {
		if(head==null) { //if list is empty
			insertFirst(val);
			return;
		}
//		Node temp = head; //we can also do like this w/o using tail
//		while(temp.next!=null) {
//			temp = temp.next;
//		}
		Node node = new Node(val);
		//temp.next = node;
		tail.next = node;
		tail = node;
		size++;
	}
	public void insertAtPosition(int val,int position) {
		if(position==0) {
			insertFirst(val);
			return;
		}
		if(position==size) {
			insertLast(val);
			return;
		}
		Node temp = head; //0 is it itself
		for(int i = 1;i<position;i++) {
			temp = temp.next;
		}
		Node node = new Node(val);  //next is reference pointing to temp.next
		node.next = temp.next;
		temp.next = node;
		
		size++;
		
	}
	
	public int deleteAtFirst() {
		int val = head.value;
		head = head.next;
		
		if(head == null) {
//			tail=null;
			throw new RuntimeException("List is Empty");
		}
		size--;
		return val;
	}
	
	public void deleteLast() {
//		if(size<=1) {
//			 deleteAtFirst();
//			 return;
//		}
		int val ;
		//if list is empty
		if(head==null) {
			throw new RuntimeException("List is empty");
		}
		// Handle deletion when the list contains only one node
        if (head.next == null) {
            deleteOnlyNode();
            return;
        }
		
		Node secondLast = get(size-2); //ref to sencondlast node obtain from get
		
		Node last = secondLast.next;
		secondLast.next = null;
		size--;
		
	}
	private void deleteOnlyNode() {
        head = null;
        size--;
    }
	public void deleteAll() {
		head = null;
		//all nodes willl be garbage collected
	}
	//Deletion at Particular index
	public int deleteAtIndex(int index) {
		if(index==0) {
			return deleteAtFirst();
		}
		if(index == size-1) {
			 deleteLast();
		}
		//if list is empty or pos<1, then throw exception
		if(head==null || index<0) {
			throw new RuntimeException("List is empty or invalid position");
		}
		Node prev = get(index-1);
		int val = prev.next.value;
		prev.next = prev.next.next;
		
		return val;
	}
	
	public void deleteAtPos(int pos) {
		
		//take temp pointer runnign behind trav
		Node temp = null;
		Node trav = head;
		
		//traverse till pos(trav)
		for(int i = 1;i<pos;i++) {
			temp = trav;
			trav = trav.next;
		}
		
		//trav is node to be deleted and temp is node before that
		temp.next = trav.next;
		//trav node will be gc
		
	}
	
	
	//to find node by value
	public Node find(int value) {
		Node node = head;
		while(node!=null) {
			if(node.value==value) {
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	//use to retreive a reference to node at given index in LL
	public Node get(int index) { //put any index here it will return ref pointer to that node
		Node node = head;
		for(int i = 0;i<index;i++) { //traverse LL until desired index is reached
			node = node.next;
		}
		//System.out.println(node);
		return node;
	}
	public void display() {
		Node temp = head; //changing temp will not change head
		while(temp!=null) { 
			System.out.print(temp.value+"-->");
			temp = temp.next;
		}
		System.out.println("End");
	}
	
	private class Node{
		private int value; //every node will having value
		private Node next; //pointer to next node
	
		public Node(int value) {
			this.value = value;
		}
		public Node(int value,Node next) {
			this.value=value;
			this.next = next;
		}
	}
}
