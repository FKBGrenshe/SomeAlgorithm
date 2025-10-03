public class Solution_64_Hot100 {
    public int minPathSum(int[][] grid) {
        int Width = grid.length;
        int Long = grid[0].length;
        int[][] dp = new int[Width][Long];
        // 初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < Long; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < Width; i++) {
            dp[i][0] = dp[i-1][0]+ grid[i][0];
        }

        // 递推
        for (int i = 1; i < Width; i++) {
            /*从上到下*/
            for (int j = 1; j < Long; j++) {
                /*从左到右*/
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[Width-1][Long-1];
    }

    public static void main(String[] args) {
        Solution_64_Hot100 solution64Hot100 = new Solution_64_Hot100();
        System.out.println(solution64Hot100.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
}
