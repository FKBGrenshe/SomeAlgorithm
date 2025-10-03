import java.util.Arrays;

public class Solution_198_Hot100 {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 递推公式
        for (int i = 2; i < nums.length; i++) {
            // 不存放i -- dp[i-1]
            // 存放i -- dp[i-2]+i
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        Solution_198_Hot100 solution198Hot100 = new Solution_198_Hot100();
        System.out.println(solution198Hot100.rob(new int[]{
                2,4,8,9,9,3
        }));
    }
}
