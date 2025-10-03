import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *  示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *  提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */

public class Solution_416 {
    public boolean canPartition(int[] nums) {
        boolean canFlag = false;
        // 计算数组总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return canFlag;
        }

        // dp initialize
        boolean[][] dp = new boolean[nums.length][(sum/2)+1];
//        Arrays.fill(dp,false);
        for (int j = 0; j < (sum/2)+1; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j == nums[i]){
                    dp[i][j] = true;
                }
            }
        }

        // 第i行第j列
        for (int j = 0; j < (sum/2)+1; j++) {
            for (int i = 1; i < nums.length; i++) {
                // dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
                 dp[i][j] = dp[i-1][j] || (j >= nums[i] ? dp[i-1][j-nums[i]] : false);
            }
        }

        return dp[nums.length-1][sum/2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_416().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new Solution_416().canPartition(new int[]{1,2,3,5}));
    }

}
