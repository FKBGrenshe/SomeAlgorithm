import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-09-17
 * @Description: 零钱兑换Ⅱ
 */
public class Solution_518 {

    int[] coins = null;
    int ways = 0;
    // dp[i] -- 表示 当金额为i的时候，现有硬币有几种凑法
    int[] dp = null;

    public int change(int amount, int[] coins) {
        this.coins = coins;
        Arrays.sort(this.coins);
        dp = new int[amount+1];
        dp[0] = 1;


        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }



        /*for (int curAmount = 1; curAmount <= amount; curAmount++) {
            // 对当前金额curAmount：curAmount  = dp[curAmount-coins[i]] + coin[i]
            for (int i = 0; i < coins.length; i++) {
                int dpAmount = curAmount-coins[i];
                if (dpAmount >= 0 && dp[dpAmount] > 0){
                    dp[curAmount] += dp[dpAmount];
                }
            }
        }
*/
        return dp[amount];


        /*doSearch(amount,this.coins.length-1);
        System.out.printf("ways = " + ways);
        return ways;*/
    }

    /**
     *
     * @param resAmount 剩余需要找零的金额
     * @param currentCoinIdx 当前递归下最大值可用的硬币的索引位置
     */
    public void doSearch(int resAmount, int currentCoinIdx){
        if (resAmount == 0){
            ways++;
            return;
        }

        if (resAmount < 0){
            return;
        }

        for (int coinIdx = currentCoinIdx; coinIdx >= 0; coinIdx--) {
            doSearch(resAmount - coins[coinIdx],coinIdx);
        }

    }


    public static void main(String[] args) {
        Solution_518 solution518 = new Solution_518();

        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        System.out.println(solution518.change(amount, coins));
    }

}
