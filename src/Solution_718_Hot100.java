/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 *
 *  示例 2：
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 */
public class Solution_718_Hot100 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int maxValue = -1;
        // dp initialize :
        dp[0][0] = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]){
                dp[i][0] = 1;
                maxValue = 1;
            }
        }
        for (int j = 0; j < nums2.length; j++) {
            if (nums1[0] == nums2[j]){
                dp[0][j] = 1;
                maxValue = 1;
            }
        }

        // state transfer
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i-1][j-1] + 1 : 0;
                if (dp[i][j] > maxValue){
                    maxValue = dp[i][j];
                }
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Solution_718_Hot100 solution718Hot100 = new Solution_718_Hot100();
        System.out.println(solution718Hot100.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4}));
    }

}
