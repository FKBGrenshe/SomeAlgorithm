package DynamicProgram;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-07
 * @Description: 完全平方数
 */
public class Solution_279_Hot100 {

    int[] dp;

    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            if (i*i > n) break;
            dp[i*i] = 1;
        }

        for (int idx = 2; idx <= n; idx++) {
            //
            if (dp[idx] != Integer.MAX_VALUE) continue;
            //
//            dp[idx] = findMin(idx);
            for (int squares = 1; squares <= idx; squares++) {
                if (squares*squares > idx) break;
                dp[idx] = Math.min(dp[idx-squares*squares] + dp[squares*squares], dp[idx]);
            }
        }
        return dp[n];
    }

    /*private int findMin(int idx) {
        for (int curVal = 0; curVal < idx; curVal++) {
            dp[idx] = Math.min(dp[curVal] + dp[idx-curVal], dp[idx]);
        }
    }*/

    public static void main(String[] args) {
        Solution_279_Hot100 solution279Hot100 = new Solution_279_Hot100();
        System.out.println(solution279Hot100.numSquares(15));
    }

}
