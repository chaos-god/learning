package com.sylar.leetcode.dp;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int R = obstacleGrid.length;
		int C = obstacleGrid[0].length;

		// If the starting cell has an obstacle, then simply return as there would be
		// no paths to the destination.
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		// Number of ways of reaching the starting cell = 1.
		obstacleGrid[0][0] = 1;

		// Filling the values for the first column
		for (int i = 1; i < R; i++) {
			obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
		}

		// Filling the values for the first row
		for (int i = 1; i < C; i++) {
			obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
		}

		// Starting from cell(1,1) fill up the values
		// No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
		// i.e. From above and left.
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (obstacleGrid[i][j] == 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				} else {
					obstacleGrid[i][j] = 0;
				}
			}
		}

		// Return value stored in rightmost bottommost cell. That is the destination.
		return obstacleGrid[R - 1][C - 1];
	}

	public static class InterleaveStr {
		public boolean isInterleave(String s1, String s2, String s3) {
			if (s3.length() != s1.length() + s2.length()) {
				return false;
			}

			boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
			for (int i = 0; i <= s1.length(); i++) {
				for (int j = 0; j <= s2.length(); j++) {
					if (i == 0 && j == 0) {
						dp[i][j] = true;
					} else if (i == 0) {
						dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
					} else if (j == 0) {
						dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
					} else {
						dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
								|| (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
					}
				}
			}
			return dp[s1.length()][s2.length()];
		}

		public boolean isInterleave2(String s1, String s2, String s3) {
			if (s3.length() != s1.length() + s2.length()) {
				return false;
			}
			boolean dp[] = new boolean[s2.length() + 1];
			for (int i = 0; i <= s1.length(); i++) {
				for (int j = 0; j <= s2.length(); j++) {
					if (i == 0 && j == 0) {
						dp[j] = true;
					} else if (i == 0) {
						dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
					} else if (j == 0) {
						dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
					} else {
						dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
								|| (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
					}
				}
			}
			return dp[s2.length()];
		}
	}
}
