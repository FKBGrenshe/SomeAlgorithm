package Time3Hot100;

import java.util.Arrays;

public class Solution_322_Hot100 {

    // 对于第j个硬币 -- value[j]
    // dp[i] = Integer.min(dp[i-value[0]]+1,..,dp[i-value[j]]+1)

    // 83 * 3 = 249
    // 249 + 5*3

    public int coinChange(int[] coins, int amount) {


        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        Arrays.sort(coins);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount){
                dp[coins[i]] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            if (dp[i] == 1){
                continue;
            }
            if (i == 83*2){
                System.out.println();
            }

            dp[i] = findmin(i, coins, dp);
        }
        return dp[amount];
    }

    private int findmin(int needVal, int[] coins, int[] dp) {
        int temp = Integer.MAX_VALUE;

        for (int curVal : coins) {
            int preVal = needVal - curVal;
            if (preVal < 0) {
                break;
            } else {
                if (dp[preVal] != -1) {
                    temp = Integer.min(temp, dp[preVal] + 1);
                }
            }

        }
        return temp == Integer.MAX_VALUE ? -1 : temp;
    }

    public static void main(String[] args) {
        Solution_322_Hot100 solution322Hot100 = new Solution_322_Hot100();
        System.out.println(solution322Hot100.coinChange(
                new int[]{
                        474,83,404,3
                },
                83*4
        ));
    }

}
