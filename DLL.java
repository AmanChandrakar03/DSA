package com.LL;

public class DLL {

	Node head;
	private int size;
	
	public boolean isEmpty() {
		return head == null;	
	}
	
	//insertion at first
	public void insertFirst(int val) {
		Node node = new Node(val);
		
		if(isEmpty()) {
			head = node;
			return;
		}
		
		node.next = head;
		head.prev = node;
		
		if(head!=null) {
			head.prev=node;
		}
		head = node;
		
	}
	
	//Insertion at last
	public void insertLast(int val) {
		Node node = new Node(val);
		Node last = head;
		
		node.next = null;
		
		if(head==null) {
			node.prev=null;
			head=node;
			return;
		}
		
		while(last.next!=null) {
			last=last.next;
		}
		
		last.next = node;
		node.prev=last;
	}
	public Node find(int value) {
		Node node = head;
		while(node!=null) {
			if(node.value == value) {
				return node;
			}
			node = node.next;
		}
		return null;
	}
	//Insertinon after particular value
	public void insert(int after,int val) {
		Node p = find(after);
		
		//whata if this node dont exist
		if(p == null) {
			System.out.println("Does not exist");
			return;
		}
		Node node = new Node(val);
		node.next = p.next;
		p.next = node;
		node.prev = p;
		
		if(node.next != null) { //it means there is a node after the new node
			//it sets the prev pointer of the node after the new node to the new node 
			node.next.prev = node; //this may be null
		}
	}
	
	//To insert a new node at a specific position
	public void insertAtPosition(int val,int position) {
		
		if(position == 0) {
			insertFirst(val);
			return;
		}
		if(position == size) {
			insertLast(val);
			return;
		}
		
//		if(position<0 || position>size) {
//			System.out.println("Enter valid position");
//			return;
//		}
		
		Node temp = head;
		for(int i = 1;i<position;i++) {
			temp = temp.next;
		}
		Node node = new Node(val);
		node.next = temp.next;
		node.prev = temp;
		
		temp.next.prev = node;
		temp.next = node;
		
		size++;
		
		
	}
	
	
	public void display() {
		Node node = head;
		//keep track of the last node in the linked list during traversal.
		//Node last = null;
		while(node!=null) {
			System.out.print(node.value+"-->");
			//last = node; //it will traverse with node till last
			node = node.next;
			
		}
		System.out.println("End");
//		System.out.print(last.value); //8
//		System.out.print(last.next.value);
//		System.out.print(last.prev.value); //3
		
		
//		System.out.println("To print in reverse");
//		while(last!=null) {
//			System.out.print(last.value+"-->");
//			last = last.prev;
//		}
		System.out.println("start");

	}
	public void reverseDisplay() {
		Node trav = head;
		//if empty list;
		if(head==null) {
			return;
		}
		//trav till last node
		while(trav.next!=null) {
			trav=trav.next;
		}
		//to print all nodes in reverse
		while(trav!=null) {
			System.out.print(trav.value+"-->");
			trav = trav.prev;
		}
	}
	//delete at first
	public void deleteAtFirst() {
		//int val = head.value;
		if(head==null) {
			throw new RuntimeException("List is empty");
		}
		if(head.next == null) {
			deleteOnlyNode();
			return;
		}
		head = head.next;
		
		
		//return val;	
	}
	private void deleteOnlyNode() {
	    head = null;
	    size--;
	}
	
		//delete at last
	public int deleteAtLast() {
		if(head==null) {
			throw new RuntimeException("List is empty");
		}
		if(head.next==null) {
			 // Case when there's only one node in the list
			int val = head.value;
			head = null;
			return val;
		}
		Node last = head;
		int val = last.value;
		while(last.next!=null) {
			last = last.next;
		}
		//It then updates the next pointer of the second-to-last node (last.prev.next) to null
		last.prev.next = null;
		last.prev=null;
		
		return val;
	
	}
	
	//delte at position
	public void deleteAtPosition(int position) {
//		if (position < 0 || position >= size) {
//	        throw new IllegalArgumentException("Invalid position");
//	    }
	    
	    if (position == 0) {
	        deleteAtFirst();
	        return;
	    }
	    if (head == null) {
            // List is empty, nothing to delete
            return;
        }
//	    if (position == size - 1) {
//	        deleteAtLast();
//	        return;
//	    }
	    
	    Node current = head;
	    for(int i = 0;i<position;i++) {
	    	current = current.next;
	    }
	    
	    current.prev.next = current.next;
	    current.next.prev = current.prev;
	    
	    size--;
	}
	
	//delte all nodes
	public void deleteAll() {
		head = null;
		//all nodes willl be garbage collected
	}
	
	private class Node{
		 int value;
		 Node next;
		 Node prev;
		 
		 public Node(int val) {
			 this.value = val;
		}

		public Node(int value, Node next, Node prev) {
			super();
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		 
	}
}
