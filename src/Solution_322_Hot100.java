import java.util.Arrays;

public class Solution_322_Hot100 {
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        // dp initialize
//        dp[0] = 0;
//        int minCoin = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            minCoin = Math.min(minCoin,coin);
//        }
//        for (int i = 1; i < minCoin && i <= amount; i++) {
//            dp[i] = -1;
//        }
//        // status transfer function
//        for (int i = minCoin; i <= amount; i++) {
//            int minNumbers = Integer.MAX_VALUE;
//            for (int j = 0; j < coins.length; j++) {
//                if (i - coins[j] >= 0 ){
//                    int prev = dp[i - coins[j]];
//                    if (prev != -1){
//                        minNumbers = Math.min(minNumbers, prev);
//                    }
//                }
//            }
//            if (minNumbers != -1 && minNumbers != Integer.MAX_VALUE){
//                dp[i] = minNumbers + 1;
//            }else{
//                dp[i] = -1;
//            }
//
//        }
//        return dp[amount];
//    }


    public int coinChange(int[] coins, int amount) {
        // dp[i] : 用硬币凑金额i，需要的最小的硬币数, -1表示不可凑
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;

        //
        for (int curMoney = 1; curMoney <= amount; curMoney++) {
            int coinNumber = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = curMoney - coin;
                if (res >= 0){
                    if (dp[res] != -1){
                        coinNumber = Math.min(coinNumber, dp[res]+1);
                    }
                }
            }
            dp[curMoney] = coinNumber == Integer.MAX_VALUE ? -1 : coinNumber;
        }
        return dp[amount];

    }

    public static void main(String[] args) {
        Solution_322_Hot100 solution322Hot100 = new Solution_322_Hot100();
        System.out.println(solution322Hot100.coinChange(
                new int[]{6},
                5
        ));
    }
}
