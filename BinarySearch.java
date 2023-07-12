package searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static int binSearch(int[] arr,int key) {
		int l = 0; //left index ie 0
		int r = arr.length-1; //right index will be last 
		while(l<=r) {  //repeat until l<=r
		int mid = (r+l)/2; //middle element
		
		if(key==arr[mid])  
			return mid;
		
		if(key<arr[mid]) {
			r=mid-1;  //agar key chota hai midlle element se to right ko middle-1 me leaao
		}
		else {
			l = mid+1; //ager key bada h middle se to l=m+1
		}
		}
		return -1;
	}
	public static int recursionBinSearch(int[] arr,int left,int right,int key) {
		
		if(right<left) {  //base condition
			return -1;
		}
		int mid = (right+left)/2;
		int index;
		if(key==arr[mid]) {
			return mid;
		}
		if(key<arr[mid]) {
			 index = recursionBinSearch(arr, left, mid-1, key);
		}
		else {
			index = recursionBinSearch(arr, mid+1, right, key);		
			}
		return index;
	}
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int[] arr = {88,33,66,99,44,77,22,55,11};

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("Enter key to search");;
		int key = sc.nextInt();
		//Binary Search
		int index = binSearch(arr, key);
		if(index != -1)
			System.out.println("Key found at index"+index);
		else 
			System.out.println("Key not found");
		
		
		//Binary search using Recursion
		index = recursionBinSearch(arr, 0, arr.length-1, key);
		if(index != -1)
			System.out.println("Key found at index"+index);
		else 
			System.out.println("Key not found");
	}

}
