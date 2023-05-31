class IsSubsequence {
    
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        // 创建一个记录子问题最优解的二维数组
        int[][] dp = new int[m + 1][n + 1];
        // 初始化矩阵第一行和第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        // 计算矩阵中其他位置的最优解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 判断 s 是否为 t 的子序列
        return dp[m][n] == m;
    }
}