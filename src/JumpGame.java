import java.util.Scanner;

/*
 * 
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * 	Example 1:
 * 		Input: nums = [2,3,1,1,4]
 * 		Output: true
 * 		Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * 	Example 2:
 * 		Input: nums = [3,2,1,0,4]
 * 		Output: false
 * 		Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, 
 * 		which makes it impossible to reach the last index.
 * 
 * 	Constraints:
 * 		1 <= nums.length <= 3 * 10^4
 * 		0 <= nums[i][j] <= 10^5
 * 
 * 
 */
import java.util.*;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		int[] arr = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(canJump(arr));
		scn.close();
	}

	public static boolean canJump(int[] nums) {
//		return recur(nums, 0, new boolean[nums.length]);
		int lastPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}

// public boolean recur(int[] nums, int indx,boolean[] strg){
//     if(indx == nums.length-1){
//         return true;
//     }
//     if(nums[indx]==0){
//         return false;
//     }
//     if(strg[indx]==true){
//         return false;
//     }
//     int maxJump = nums[indx];
//     for(int i=1; i<=maxJump; i++){
//         if(recur(nums,indx+i, strg)){
//             return true;
//         }
//     }
//     strg[indx]=true;
//     return false;
// }

}
