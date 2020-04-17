
//122. Best Time to Buy and Sell Stock II
//
//	Say you have an array prices for which the ith element is the price of a given stock on day i.
//
//	Design an algorithm to find the maximum profit. You may complete as many transactions as you 
//	like (i.e., buy one and sell one share of the stock multiple times).
//
//	Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//
//	Example 1:
//
//		Input: [7,1,5,3,6,4]
//		Output: 7
//		Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//		             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//	Example 2:
//
//		Input: [1,2,3,4,5]
//		Output: 4
//		Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//		             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//		             engaging multiple transactions at the same time. You must sell before buying again.
//	Example 3:
//
//		Input: [7,6,4,3,1]
//		Output: 0
//		Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
//
//	Constraints:
//			1 <= prices.length <= 3 * 10 ^ 4
//			0 <= prices[i] <= 10 ^ 4

import java.util.Scanner;

public class BestTimeToBuyAndSellStockII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sizeOfArray = scn.nextInt();
		int[] prices = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			prices[i] = scn.nextInt();
		}
		System.out.println(maxProfit(prices));
		scn.close();
	}

	public static int maxProfit(int[] prices) {
		// return recurBackMaxProfit(prices, 0, 0, 0,-1);
		if (prices.length == 0) {
			return 0;
		}
		int[] dp = new int[prices.length];
		dp[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			if (dp[i - 1] + (prices[i] - prices[i - 1]) > dp[i - 1]) {
				dp[i] = dp[i - 1] + (prices[i] - prices[i - 1]);
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[prices.length - 1];

	}

//	Recursion solution
	public int recurBackMaxProfit(int[] prices, int indx, int profit, int nost, int indxOfLastBoughtStock) {
		if (indx == prices.length) {
			return profit;
		}
		int ans = Integer.MIN_VALUE;
		int bought = Integer.MIN_VALUE;
		int notBought = Integer.MIN_VALUE;
		int sold = Integer.MIN_VALUE;
		int notSold = Integer.MIN_VALUE;
		notBought = recurBackMaxProfit(prices, indx + 1, profit, nost, indxOfLastBoughtStock);

		if (nost == 0) {
			bought = recurBackMaxProfit(prices, indx + 1, profit, nost + 1, indx);
		}
		notSold = recurBackMaxProfit(prices, indx + 1, profit, nost, indxOfLastBoughtStock);
		if (nost == 1) {
			if (profit + prices[indx] - prices[indxOfLastBoughtStock] > profit) {
				sold = recurBackMaxProfit(prices, indx + 1, profit + prices[indx] - prices[indxOfLastBoughtStock],
						nost - 1, -1);
			}

		}
		ans = Math.max(Math.max(Math.max(bought, sold), notSold), notBought);
		return ans;

	}

}
