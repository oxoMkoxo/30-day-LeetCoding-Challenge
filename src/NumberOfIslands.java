/*
 * Number of Islands

 * 	Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by
 *  water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of 
 *  the grid are all surrounded by water.
 *  	
 *  	Example 1:
 *  		Input:
 *  			11110
 *  			11010
 *  			11000
 *  			00000
 *  		Output: 1
 *  
 *  	Example 2:
 *  		Input:
 *  			11000
 *  			11000
 *  			00100
 *  			00011
 *  		Output: 3
 *   
 */

import java.util.Scanner;

public class NumberOfIslands {

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
		System.out.println(numIslands(arr));
		scn.close();
	}

	public static int numIslands(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					dfs(i, j, grid, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int row, int col, char[][] grid, boolean[][] visited) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
			return;
		}
		if (grid[row][col] == '0') {
			return;
		}
		if (visited[row][col]) {
			return;
		}
		int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		visited[row][col] = true;
		for (int i = 0; i < moves.length; i++) {
			dfs(row + moves[i][0], col + moves[i][1], grid, visited);
		}
	}

}
