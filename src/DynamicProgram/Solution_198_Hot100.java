package DynamicProgram;

import java.util.Map;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-07
 * @Description: 打家劫舍
 */
public class Solution_198_Hot100 {

    // dp[i] = Math.max( dp[i-2]+nums[i], dp[i-1] )
    int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];

        dp[0] = nums[0];
        if(nums.length == 1) return dp[0];
        dp[1] = Math.max(dp[0],nums[1]);
        if (nums.length == 2) return dp[1];

        for (int idx = 2; idx < nums.length; idx++) {
            dp[idx] = Math.max(
                    dp[idx-2]+nums[idx],
                    dp[idx-1]
            );
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        Solution_198_Hot100 solution198Hot100 = new Solution_198_Hot100();
        System.out.println(solution198Hot100.rob(
                new int[]{
                        2,1,1,2
                }
        ));
    }

}
