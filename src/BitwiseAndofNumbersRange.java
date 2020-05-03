/*
 * 201. Bitwise AND of Numbers Range
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * 
 * 	Example 1:
 * 		Input: [5,7]
 * 		Output: 4
 * 
 * 	Example 2:
 * 		Input: [0,1]
 * 		Output: 0
 *  
 */

import java.util.Scanner;

public class BitwiseAndofNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		System.out.println(rangeBitwiseAnd(m, n));
		scn.close();
	}

	public static int rangeBitwiseAnd(int m, int n) {
		int shift = 0;
		while (m < n) {
			m >>= 1;
			n >>= 1;
			shift++;
		}
		return m << shift;
	}
}
