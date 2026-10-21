class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        // Initialize the first row
        dp[0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // Process the remaining rows
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];

            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] +
                        Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[n - 1];
    }
}