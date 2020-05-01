/*
 * Leftmost Column with at Least a One
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
 * 
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeftmostColumnWithAtleastaOne {
	class BinaryMatrix {
		private int[][] matrix;
		private List<Integer> dim;

		public BinaryMatrix(String s) {
			// TODO Auto-generated constructor stub
			Pattern brackCount = Pattern.compile("[\\[]");
			Matcher count = brackCount.matcher(s);
			int rows = (int) (count.results().count() - 1);
			StringTokenizer st = new StringTokenizer(s, "[^(\\\\[).*(\\\\]),]");
			int noOfDigits = st.countTokens();
			int cols = noOfDigits / rows;
			matrix = new int[rows][cols];
			int i = 0;
			int j = 0;
			while (st.hasMoreElements()) {
				if (j >= cols) {
					i++;
					j = 0;
				}
				matrix[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
			dim = new ArrayList<>();
			dim.add(rows);
			dim.add(cols);
//			for (i = 0; i < matrix.length; i++) {
//				for (j = 0; j < matrix[i].length; j++) {
//					System.out.print(matrix[i][j]);
//				}
//				System.out.println();
//			}
		}

		public int get(int x, int y) {
			return matrix[x][y];
		}

		public List<Integer> dimensions() {
			return dim;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		LeftmostColumnWithAtleastaOne obj = new LeftmostColumnWithAtleastaOne();
		BinaryMatrix binaryMatrix = obj.new BinaryMatrix(s);
		System.out.println(leftMostColumnWithOne(binaryMatrix));
		scn.close();
	}

	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dim = binaryMatrix.dimensions();
		int n = dim.get(0);
		int m = dim.get(1);
		int ans = m;
		for (int i = 0; i < n; i++) {
			int call = findColBinary(binaryMatrix, m, i);
			if (ans > call) {
				ans = call;
			}
		}
		if (ans == m) {
			return -1;
		} else {
			return ans;
		}

	}

	public static int findColBinary(BinaryMatrix binaryMatrix, int m, int row) {
		int lo = 0;
		int hi = m;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (binaryMatrix.get(row, mid) == 1) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
}
