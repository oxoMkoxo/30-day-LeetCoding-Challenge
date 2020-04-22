
/*
 * 525. Contiguous Array
 * 	Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *		Example 1:
			Input: [0,1]
			Output: 2
			Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
		Example 2:
			Input: [0,1,0]
			Output: 2
		Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
			Note: The length of the given binary array will not exceed 50,000.
 * 
 */
import java.util.*;

public class ContiguousArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		int[] arr = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(findMaxLength(arr));
		scn.close();
	}

	public static int findMaxLength(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (nums[i] == 0) ? -1 : 1;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLength = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				if (maxLength < (i - map.get(sum))) {
					maxLength = i - map.get(sum);
				}
			} else {
				map.put(sum, i);
			}
			if (sum == 0) {
				maxLength = i + 1;
			}
		}
		return maxLength;

	}

}
