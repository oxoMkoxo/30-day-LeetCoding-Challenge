
// 283. Move Zeroes
//
//	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order
//	of the non-zero elements.
//
//	Example:
//		Input: [0,1,0,3,12]
//		Output: [1,3,12,0,0]
//
//	Note:
//		You must do this in-place without making a copy of the array.
//		Minimize the total number of operations.
import java.util.Scanner;

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		int[] nums = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			nums[i] = scn.nextInt();
		}
		moveZeroes(nums);
		System.out.print("[");
		for (int i = 0; i < sizeOfArray; i++) {
			System.out.print(nums[i] + ", ");
		}
		System.out.print("]");
		scn.close();
	}

	public static void moveZeroes(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length && j < nums.length; i++) {

			while (i < nums.length && nums[i] != 0) {
				i++;
			}
			if (j == 0) {
				j = i + 1;
			}
			while (j < nums.length && nums[j] == 0) {
				j++;
			}

			if (j != nums.length && j < nums.length) {
				nums[i] = nums[j];
				nums[j] = 0;
			}
			j = j + 1;
		}

	}
}
