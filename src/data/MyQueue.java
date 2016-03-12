package data;

public class MyQueue {

	private int Size;
	private Node Head;
	private Node Tail;
	
	private class Node {
		private int Num;
		private Node Next; 
	}
	
	public MyQueue() {
		this.Size = 0;
		this.Head = null;
		this.Tail = null;
	}
	
	public boolean isEmpty() {
		return this.Head == null;
		
	}
	
	public int getSize() {
		return this.Size;
	}
	
	public void setSize(int n) {
		this.Size = n;
	}
	
	public void enMyQueue(int n) {
		Node N = new Node();
		N.Num = n;
		if (isEmpty()) {
			this.Head = N;
			this.Tail = N;
			
		}
		else {
			this.Tail.Next = N;
			this.Tail = N;	
		}
		this.Size++;
		
	}
	
	public int deMyQueue() {
		Node N = new Node();
		if (isEmpty()) {
			return -1;
		}
		else {
			N = this.Head;
			this.Head = this.Head.Next;
			this.Size--;
		}
		return N.Num;
	}
	
	public int peek() {
		int r = 0;
		if (isEmpty()) {
			return -1;
		}
		else {
			r = this.Head.Num;
		}
		return r;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
