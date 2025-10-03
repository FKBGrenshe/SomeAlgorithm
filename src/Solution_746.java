import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution_746 {
    public int minCostClimbingStairs(int[] cost) {
        // dp初始化
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,0);
//        dp[0] = cost[0];
//        dp[1] = cost[1];
        // 递推
        for (int i = 2; i < dp.length; i++) {
            // [i-2] 爬 2个台阶
            int cost2 = cost[i-2] + dp[i-2];
            // [i-1] 爬 1个台阶
            int cost1 = cost[i-1] + dp[i-1];
            dp[i] = Math.min(cost2, cost1);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        Solution_746 solution746 = new Solution_746();
        System.out.println(solution746.minCostClimbingStairs(new int[]{
                10,15,20
        }));
    }

}
