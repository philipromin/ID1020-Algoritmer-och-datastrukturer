/*
 PHILIP ROMIN
 */

import java.util.Scanner;

public class StackofStrings {
	private String[] s;
	private int N = 0;
	
	public StackofStrings (int capacity) {
		s = new String[capacity];
	}
	
	public void push (String item) {
		s[N++] = item;
	}
	
	public String pop () {
		String item = s[--N];
		s[N] = null;
		return item;
	}
	
	public boolean isEmpty () {
		return N == 0;
	}
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		in.useDelimiter("");
		StackofStrings stack = new StackofStrings(50);
		
		while (!in.hasNext("\n")) {
			stack.push(in.next());
		}	
		
		in.close();
					
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
