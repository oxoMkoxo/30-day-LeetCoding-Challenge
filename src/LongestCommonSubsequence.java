import java.util.Scanner;

/*
 * 1143. Longest Common Subsequence
 * 
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string with some characters(can be none)
 * deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" 
 * while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * 
 * If there is no common subsequence, return 0.
 * 
 * 	Example 1:
 * 		Input: text1 = "abcde", text2 = "ace" 
 * 		Output: 3 
 * 		Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * 	Example 2:
 * 		Input: text1 = "abc", text2 = "abc"
 * 		Output: 3
 * 		Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * 	Example 3:
 * 		Input: text1 = "abc", text2 = "def"
 * 		Output: 0
 * 		Explanation: There is no such common subsequence, so the result is 0.
 * 
 *	Constraints:
 *		1 <= text1.length <= 1000
 *		1 <= text2.length <= 1000
 *	The input strings consist of lowercase English characters only.
 * 
 * 
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String text1 = scn.next();
		String text2 = scn.next();
		System.out.println(longestCommonSubsequence(text1, text2));
		scn.close();
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int[] strg = new int[text2.length() + 1];
		char[] t1 = text1.toCharArray();
		char[] t2 = text2.toCharArray();
		int diagElement = 0;
		for (int i = text1.length() - 1; i >= 0; i--) {
			diagElement = 0;
			for (int j = text2.length() - 1; j >= 0; j--) {
				if (t1[i] == t2[j]) {
					strg[j] = diagElement + 1;
					diagElement = strg[j] - 1;
				} else {
					diagElement = strg[j];
					strg[j] = Math.max(strg[j], strg[j + 1]);
				}
			}
		}
		return strg[0];
	}

}
