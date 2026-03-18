package DynamicProgram;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-18
 * @Description: 零钱兑换
 */
public class Solution_322_Hot100 {

    int[] dp;

    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);

        // dp[i] = 每个coins的val_j, dp[i-val_j] + 1的最小值

        dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] >= dp.length) break;
            dp[coins[i]] = 1;
        }

        // dp start

        for (int curVal = coins[0]+1; curVal < dp.length; curVal++) {

            if (curVal == 419+408){
                System.out.printf("");
            }

            if (dp[curVal] != -1) continue;


            int minCoinsNum = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] >= curVal || dp[curVal - coins[i]] == -1) continue;
                minCoinsNum = Math.min(minCoinsNum, dp[curVal - coins[i]]+1);
            }
            dp[curVal] = minCoinsNum != Integer.MAX_VALUE? minCoinsNum : -1;
        }

        // dp end

        return dp[amount];
    }

    public static void main(String[] args) {


        int[] coins ={
//                2
//                1,2,5
//                1
                186,419,83,408
        };

        int amount = 6249;


        Solution_322_Hot100 solution322Hot100 = new Solution_322_Hot100();
        int result = solution322Hot100.coinChange(
                coins,
                amount
        );
        System.out.printf(""+result);
    }

}
