package Time2Hot100;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-11
 * @Description: 最长递增子序列
 */
public class Solution_300_Hot100 {

    int[] dp;
    int max = 1;

    public int lengthOfLIS(int[] nums) {

        int length = nums.length;
        dp = new int[length+1];

        dp[0] = 1;

        // 对于nums[x]的数来说：[0~x]的最长子序列数 = 1 + Max([0~y]的最长子序列)
        // 两个条件：（1） y < x （2） nums[y] < nums[x]
        // transfer formula:

        for (int idx = 1; idx < length; idx++) {
            int preMaxIdx = findMax(idx,nums);
            dp[idx] = preMaxIdx == -1 ? 1 : dp[preMaxIdx]+1;
            max = Math.max(max, dp[idx]);
        }

        return max;
    }

    /**
     * 对于当前索引x，从 dp 缓存数组中，找到 0 ~（x-1）上的最长递增子序列
     * @param x 当前索引x
     * @return 返回找到的索引y
     */
    public int findMax(int x,int[]nums){
        int tempYmax = -1;
        int tempYmaxVal = -1;

        for (int y = 0; y < x; y++) {
            if (nums[x] > nums[y]){
                if (tempYmaxVal < dp[y]){
                    tempYmax = y;
                    tempYmaxVal = dp[y];
                }
            }
        }

        return tempYmax;
    }

    public static void main(String[] args) {
        Solution_300_Hot100 solution300Hot100 = new Solution_300_Hot100();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(solution300Hot100.lengthOfLIS(nums));
    }
}
