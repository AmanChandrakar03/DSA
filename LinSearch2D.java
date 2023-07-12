package searching;

import java.util.Arrays;
import java.util.Scanner;

public class LinSearch2D {

	public static int[] search(int[][] arr,int key) {
		for(int row = 0;row<arr.length;row++) {
			for(int col = 0;col<arr[row].length;col++) {
				if(arr[row][col]==key) {
					return new int[] {row,col};
				}
			}
		}
		return new int[] {-1,-1};
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] arr = {
				{1,2,78,4},
				{3,6,9,7},
				{23,35,4,8},
				{18,12}
		};
		System.out.println("Enter key to search");
		int key = sc.nextInt();
		int[] ans = search(arr, key);
		System.out.println(Arrays.toString(ans));
		
		
}}
