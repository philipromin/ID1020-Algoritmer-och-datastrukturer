/*
 * PHILIP ROMIN
 */

import java.lang.reflect.Array;

public class Selection {
	
	public static void sort(Comparable[] a) {
		
		int N = a.length;
		int swaps = 0;
		
		for (int i = 0; i < N; i++) {
			int min = i;
			for(int j = i+1; j < N; j++) {
				if(less(a[j], a[min])) {
					min = j;
				}
			}
			if(min != i) {
				exch(a, i, min);
				//UPPGIFT 3
				swaps++;
			}
		}
		System.out.println("Number of swaps: " + swaps);
	}
	
	private static boolean less(Comparable v, Comparable w){ 
		return v.compareTo(w) < 0; 
	}
	
	private static void exch(Comparable[] a, int i, int j){ 
		Comparable t = a[i]; 
		a[i] = a[j]; 
		a[j] = t;
	}
	
	public static void show(Comparable[] a){ 
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	//UPPGIFT 4
	public static void inversions (Comparable[] a) {
		int inversions = 0;
		
		for(int i = 0; i < a.length - 1; i++) {
			for(int j = i + 1; j < a.length; j++) {
				if(less(a[j], a[i])) {
					System.out.println("Inversion: [" + i + "," + a[i] + "], [" + j + "," + a[j] + "]");
					inversions++;
				}
			}
		}
		System.out.println("Number of inversions:" + inversions);
	}
	
	/*
	public static boolean isSorted(Comparable[] a){ 
		for (int i = 1; i < a.length; i++) {
			 if (less(a[i], a[i-1])) return false;
		}
		return true;
	}
	*/
	
	public static void main(String[] args){ 
		int N = Integer.parseInt(args[0]);		
		String[] a = new String[N];
		
		String s = args[1];
		a = s.split("");
		
		//UPPGIFT 4
		inversions(a);
		
		sort(a);
		show(a);
		
		//UPPGIFT 2
		for (int i = 0; i < a.length/2; i++) {
			String temp = a[i];
			a[i] = a[a.length -i -1];
			a[a.length -i -1] = temp;
		}	
		show(a);	
	 } 
}
