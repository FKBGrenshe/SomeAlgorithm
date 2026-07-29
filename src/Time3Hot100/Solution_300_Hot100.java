package Time3Hot100;

import java.util.Arrays;

public class Solution_300_Hot100 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            doDp(dp, nums, i);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            ans = Integer.max(ans, dp[i]);
        }

        return ans;
    }

    private void doDp(int[] dp, int[] nums, int i) {
        if (i < 1){
            return;
        }
        int curTimes = Integer.MIN_VALUE;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]){
                curTimes = Integer.max(curTimes,dp[j]+1);
            }
        }
        dp[i] = curTimes == Integer.MIN_VALUE?dp[i] : curTimes;
    }

    public static void main(String[] args) {
        Solution_300_Hot100 solution300Hot100 = new Solution_300_Hot100();
        System.out.println(solution300Hot100.lengthOfLIS(
                new int[]{
                        10, 9, 2, 5, 3, 7, 101, 18
//                        0,1,0,3,2,3
                }
        ));
    }
}
