/*
 * 33. Search in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 	Example 1:
 * 		Input: nums = [4,5,6,7,0,1,2], target = 0
 * 		Output: 4
 * 	Example 2:
 * 		Input: nums = [4,5,6,7,0,1,2], target = 3
 * 		Output: -1
 */

import java.util.Scanner;

public class SearchInrotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		int[] arr = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			arr[i] = scn.nextInt();
		}
		int target = scn.nextInt();
		System.out.println(search(arr, target));
		scn.close();
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}

		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		int start = lo;
		lo = 0;
		hi = nums.length - 1;
		if (target >= nums[start] && target <= nums[hi]) {
			lo = start;
		} else {
			hi = start;
		}
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

}
