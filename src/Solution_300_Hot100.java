import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 *  示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 *  示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * 进阶：
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 */

public class Solution_300_Hot100 {
    /**
     * 思路：数组的最长严格递增子序列
     * 第i位置的最长严格递增子序列就是从[0,i-1]中,找出某个j位置，该位置的数小于i位置的数，且j位置的子序列长度+1（第i位置）是[0,i]上最长的递增子序列
     * dp[i] = 表示从0~i上的最长递增子序列长度
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        Arrays.sort(dp);

        return dp[nums.length-1];
    }


    public static void main(String[] args) {
        Solution_300_Hot100 solution300 = new Solution_300_Hot100();
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(solution300.lengthOfLIS(nums));
    }
}
