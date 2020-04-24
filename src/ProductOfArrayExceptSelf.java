
/*
 * 238. Product of Array Except Self
 * 
 *  Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 *  of all the elements of nums except nums[i].
 *  
 *  	Example:
 *  		Input:  [1,2,3,4]
 *  		Output: [24,12,8,6]
 *  	
 *  	Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the 
 *  	whole array) fits in a 32 bit integer.
 *  
 *  Note: Please solve it without division and in O(n).
 *  
 *  Follow up:
 *  	Could you solve it with constant space complexity? (The output array does not count as extra space
 *  	for the purpose of space complexity analysis.)
 */

import java.util.Scanner;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		int[] nums = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			nums[i] = scn.nextInt();
		}
		System.out.println(productExceptSelf(nums));
		scn.close();

	}

	public static int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int prod = 1;
		for (int i = 0; i < left.length; i++) {
			left[i] = prod;
			prod *= nums[i];
		}
		prod = 1;
		for (int i = right.length - 1; i >= 0; i--) {
			right[i] = prod;
			prod *= nums[i];
		}
		for (int i = 0; i < left.length; i++) {
			nums[i] = left[i] * right[i];
		}

		return nums;
	}

}
