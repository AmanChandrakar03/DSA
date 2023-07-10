package com.queue;

import java.util.Scanner;

import javax.sound.sampled.Line;

class LinearQueue{
	private int[] arr;
	private int rear,front;
	
	public LinearQueue(int size) {
		arr = new int[size];
		rear = -1;
		front = -1;
	}
	public boolean isFull() {
		return rear==arr.length-1;
	}
	public boolean isEmpty() {
		return front == rear;
	}
	public void push(int val) {
		if(isFull()) {
			throw new RuntimeException("Stack is full");
		}
		rear = (rear+1)%arr.length;
		arr[rear] = val;
	}
	public void pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		front++;
	}
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return arr[front+1];
	}
}

public class QueueMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinearQueue lq = new LinearQueue(6);
		int choice ,val;
		do {
			System.out.println("\n0.Exit \n1.Push \n2.Pop \n3.Peek \nEnter choice");
			choice = sc.nextInt();
			
			switch (choice) {
			
			case 1://Push
				try {
					System.out.println("Enter value to push");
					val = sc.nextInt();
					lq.push(val);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2://Pop
				try {
					val = lq.peek();
					lq.pop();
					System.out.println("Popped"+val);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3://Peek
				try {
					val = lq.peek();
					System.out.println("Peek"+val);
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			}
		while(choice!=0);
		sc.close();
		
				

	}

}
