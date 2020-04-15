//136. Single Number

//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//			Note:
//			Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//		Example 1:
//
//				Input: [2,2,1]
//				Output: 1
//		Example 2:
//
//				Input: [4,1,2,1,2]
//				Output: 4


import java.util.Scanner;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		int[] nums = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			nums[i] = scn.nextInt();
		}
		scn.close();
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			ans = ans ^ nums[i];
		}
		return ans;
	}

}
