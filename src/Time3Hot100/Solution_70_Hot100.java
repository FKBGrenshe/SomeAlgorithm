package Time3Hot100;

public class Solution_70_Hot100 {

    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution_70_Hot100 solution70Hot100 = new Solution_70_Hot100();
        System.out.println(solution70Hot100.climbStairs(2));
    }
}
