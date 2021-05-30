package com.sylar.leetcode.dp;

//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长为 1000 。
// 示例 1:
// 输入: "bbbab"
// 输出:4
// 一个可能的最长回文子序列为 "bbbb"。
// 示例 2:
// 输入:"cbbd"
// 输出: 2
// 一个可能的最长回文子序列为 "bb"。
// 提示：
// 1 <= s.length <= 1000
// s 只包含小写英文字母
//
// Related Topics 动态规划
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1; // 初始化
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
