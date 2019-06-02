/*
 PHILIP ROMIN
 */

import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item> {
	private Node first; 
	private Node last; 
	private int N = 0; 
	
	private class Node{ 
		Item item;
		Node next;
		Node prev;
	}
	
	public boolean isEmpty() { return first == null; }
	public int size() { return N; }
	
	public void enqueue(Item item){ 
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldlast;
		
		if (isEmpty()) {
			first = last;
		}
		else {
			oldlast.next = last;
		}
		N++;
	}
	
	public Item dequeue(){ 
		Item item = first.item;
		first = first.next;
		//first.prev = null;
		if (isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = first;
		while (tmp != null) {
			sb.append("[" + tmp.item + "]").append(", ");
			tmp = tmp.next;
		}
		return sb.toString();
	}
	
	private class NodeIterator implements Iterator<Item>{
		private Node current = first;
		 
		public boolean hasNext(){
			return current != null; 
		}
		
		public boolean hasPrev() {
			return current != null;
		}
		 
		public void remove() { }
		 
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
		
	@Override
	public Iterator<Item> iterator() {
		return new NodeIterator();
	} 
	
	
	public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<String>();

        queue.enqueue("Kalle");
        queue.enqueue("Peter");
        queue.enqueue("Philip");
        System.out.println(queue.toString());
        queue.dequeue();
        queue.dequeue();
        
        System.out.println("Jag heter " + queue.dequeue());   
    }
}
