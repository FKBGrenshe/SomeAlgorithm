public class Solution_70 {
    public int climbStairs(int n) {

        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;

        Solution_70 solution70 = new Solution_70();
        System.out.println(solution70.climbStairs(n));
    }
}
