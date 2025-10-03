public class Solution_279_Hot100 {
    public int numSquares(int n) {
        // dp[i] & initialize
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        // status transfer function
        for (int i = 2; i <= n; i++) {
            int minJ = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                minJ = Math.min(minJ,dp[i - j*j]);
            }
            dp[i] = 1 + minJ;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution_279_Hot100 solution279Hot100 = new Solution_279_Hot100();
        System.out.println(solution279Hot100.numSquares(
                12
        ));
    }
}
