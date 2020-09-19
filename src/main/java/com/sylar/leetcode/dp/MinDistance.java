package com.sylar.leetcode.dp;

// https://leetcode-cn.com/problems/edit-distance/
public class MinDistance {
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		// 有一个字符串为空串
		if (n * m == 0) {
			return n + m;
		}

		// DP 数组
		int[][] dp = new int[n + 1][m + 1];
		// 边界状态初始化
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j < m + 1; j++) {
			dp[0][j] = j;
		}

		// 计算所有 DP 值
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]);
				}
			}
		}

		return dp[n][m];
	}
}
