package Time3Hot100;

public class Solution_198_Hot100 {

    // dp[i] = dp[i-2] + v[i] , dp[i-1]

    public int rob(int[] nums) {
        if (nums.length < 2){
            return nums[0];
        }
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Integer.max(
                    dp[i-2]+nums[i],
                    dp[i-1]
            );
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        Solution_198_Hot100 solution198Hot100 = new Solution_198_Hot100();
        System.out.println(solution198Hot100.rob(
                new int[]{
                        1, 2, 3, 1
                }
        ));
    }
}
