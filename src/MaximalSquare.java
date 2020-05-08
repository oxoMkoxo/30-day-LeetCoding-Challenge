
/*
 * 221. Maximal Square
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * 
 * 	Example:
 * 		Input:
 * 			1 0 1 0 0
 * 			1 0 1 1 1
 * 			1 1 1 1 1
 * 			1 0 0 1 0
 * 		Output: 4
 * 
 * 
 */
import java.util.Scanner;

public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int noOfRows = scn.nextInt();
		int noOfCols = scn.nextInt();
		char[][] arr = new char[noOfRows][noOfCols];
		for (int i = 0; i < noOfRows; i++) {
			String lineOfChar = scn.next();
			for (int j = 0; j < noOfCols; j++) {
				arr[i][j] = lineOfChar.charAt(j);
			}
		}
		System.out.println(maximalSquare((arr)));
		scn.close();
	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int[][] strg = new int[matrix.length + 1][matrix[0].length + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < strg.length; i++) {
			for (int j = 1; j < strg[i].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					strg[i][j] = Math.min(Math.min(strg[i][j - 1], strg[i - 1][j]), strg[i - 1][j - 1]) + 1;
					if (strg[i][j] > max) {
						max = strg[i][j];
					}
				} else {
					strg[i][j] = 0;
				}

			}
		}
		return max * max;
	}

}
