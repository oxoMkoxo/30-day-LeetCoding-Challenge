/*
 * 
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
	direction can be 0 (for left shift) or 1 (for right shift). 
	amount is the amount by which string s is to be shifted.
	A left shift by 1 means remove the first character of s and append it to the end.
	Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
	Return the final string after all operations.

 
	Example 1:
		Input: s = "abc", shift = [[0,1],[1,2]]
		Output: "cab"
	Explanation: 
		[0,1] means shift to left by 1. "abc" -> "bca"
		[1,2] means shift to right by 2. "bca" -> "cab"
	Example 2:
		Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
		Output: "efgabcd"
	Explanation:  
		[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
		[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
		[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
		[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 

	Constraints:
		1 <= s.length <= 100
		s only contains lower case English letters.
		1 <= shift.length <= 100
		shift[i].length == 2
		0 <= shift[i][0] <= 1
		0 <= shift[i][1] <= 100
 */



import java.util.Scanner;

public class PerformStringShifts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String S = scn.next();
		int noOfOper = scn.nextInt();
		int[][] arr = new int[noOfOper][2];
		for (int i = 0; i < noOfOper; i++) {
			arr[i][0] = scn.nextInt();
			arr[i][1] = scn.nextInt();
		}
		System.out.println(stringShift(S, arr));
		scn.close();
	}

	public static String stringShift(String s, int[][] shift) {
		int shiftVal = 0;
//         ---------*1-----------
		for (int i = 0; i < shift.length; i++) {

			if (shift[i][0] == 0) {
				shiftVal -= shift[i][1];
			} else {
				shiftVal += shift[i][1];
			}

		}

//         --------------*2------------
		while (shiftVal < 0) {
			shiftVal = shiftVal + s.length();
		}

//         ----------------*3------------
		shiftVal = shiftVal % (s.length());

//          ---------------*4---------------------
		String ns = s.substring((s.length() - shiftVal)) + s.substring(0, (s.length() - shiftVal));
		return ns;

	}
}

// Explanation for *1
//          This will create a single number(shiftVal) which will represent the single operation to
//          be performed to get the similar result which we will get by performing every operation
//          of the shift matrix.
//      Ex: shiftVal = 0;
//          for [0,1] =>  0 - 1= -1 [sum(0)-1]  (- because of 0)
//          for [1,2] => -1 + 2 = 1 [sum(-1)+2] (+ because of 1)
//          hence we can do just right shift(because magnitude is +ve) 1 to get similar result.

// Explanation for *2
//          This is done because a left-shift-(x) operation can be replaced by right-shift-(y)
//      Ex:  on (ABCD) do right-shift-3
//          RIGHT SHIFTS                                        LEFT SHIFTS(one at at time)
//            +1 -- DABC                                 -------->  -1 -- BCDA
//            +1 -- CDAB       -------------------------/           -1 -- CDAB
//            +1 -- BCDA  ----/                                     -1 -- DABC
//            +1 -- ABCD                                            -1 -- ABCD

//      In the above example, the 3rd right shift is same as 1st left shift
//      So we had coverted any left shift to its equivalent right shift.

// Explanation for *3
//          Modulus is done because 
//        Ex: abc 
//              1st rigth shift --> cab
//              2nd rigth shift --> bca
//              3rd rigth shift --> abc
//              4th rigth shift --> cab
//          Here 4th right shift is same as 1st 
//          And, 1 can be obtained as (4%3) where 3 is length(abc).

// Explanation for *4
//          Now we have converted every query into just one shift operation
//      Ex: ALGO right-shift-1
//                  A L G O       ==> O A L G
//                  0 1 2 3       ==> 3 0 1 2
//       so we will take last character using substring(4-1), {O}
//       and then everything from begining till character at postion (4-1) using substring(0, 4-1). {ALG}
