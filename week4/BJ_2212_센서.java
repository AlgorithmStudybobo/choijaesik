package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_2212_센서 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for(int i = n - 1; i >= 1 ; i--) {
			pq.add(arr[i] - arr[i-1]); 
		}
		
		while(--k > 0) pq.poll();
		
		int sum = 0;
		while(!pq.isEmpty()) sum += pq.poll();
		
		System.out.println(sum);
		
	}

}