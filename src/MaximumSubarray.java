
// 53. Maximum Subarray
//
//	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
//	sum and return its sum.
//
//	Example:
//
//		Input: [-2,1,-3,4,-1,2,1,-5,4],
//		Output: 6
//		Explanation: [4,-1,2,1] has the largest sum = 6.

import java.util.*;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		int[] nums = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			nums[i] = scn.nextInt();
		}
		System.out.println(maxSubArray(nums));
		scn.close();

	}

	public static int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int currSum = maxSum;
		for (int i = 1; i < nums.length; i++) {
			currSum = Math.max(currSum + nums[i], nums[i]);
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;

	}

}
