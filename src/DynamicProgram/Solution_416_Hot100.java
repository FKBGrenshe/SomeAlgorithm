package DynamicProgram;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-21
 * @Description: 分割等和子集
 */
public class Solution_416_Hot100 {

    int[][] dp;

    public boolean canPartition(int[] nums) {

        if (nums.length <= 1) return false;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) return false;

        dp = new int[nums.length][totalSum/2+1];

        // dp[i][0] = true
        for (int curRow = 0; curRow < nums.length; curRow++) {
            dp[curRow][0] = 1;
        }

        //dp[i][j] : 从 0~i 个元素任选，是否可以拼出 j
        // dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]

        for (int curRow = 0; curRow < nums.length; curRow++) {
            int curNum = nums[curRow];
            for (int curColumn = 1; curColumn < totalSum / 2 + 1; curColumn++) {

                if (curRow == 0){
                    dp[curRow][curColumn] = curNum == curColumn ? 1 : 0;
                }else {
                    if (curNum > curColumn){
                        dp[curRow][curColumn] = dp[curRow-1][curColumn];
                    }else {
                        dp[curRow][curColumn] = dp[curRow-1][curColumn] + dp[curRow-1][curColumn-curNum] >= 1?1:0;
                    }
                }
            }
        }

        for (int curRow = 0; curRow < nums.length; curRow++) {
            if (dp[curRow][totalSum/2] >= 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_416_Hot100 solution416Hot100 = new Solution_416_Hot100();
        System.out.println(solution416Hot100.canPartition(
                new int[]{
//                        1,5,11,5
//                        1,2,3,5
                        0,1,0,1
//                        1,2,5
                }
        ));
    }

}
