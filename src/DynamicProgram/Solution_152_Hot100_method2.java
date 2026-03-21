package DynamicProgram;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-21
 * @Description: 优化多维动态规划到一维
 */
public class Solution_152_Hot100_method2 {


    int dp[];
    int maxVal;

    public int maxProduct(int[] nums) {
        int size = nums.length;
        dp  = new int[size];
        maxVal = nums[0];

        for (int curIdx = 0; curIdx < size; curIdx++) {
            maxVal = Math.max(maxVal, nums[curIdx]);
            if (nums[curIdx] == 1) continue;
            for (int curRow = 0; curRow < size; curRow++) {
                if (curRow > curIdx) continue;
                else if (curRow == curIdx) {
                    dp[curRow] = nums[curIdx];
                }else {
                    dp[curRow] = dp[curRow]*nums[curIdx];
                }
                maxVal = Math.max(maxVal, dp[curRow]);
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Solution_152_Hot100 solution152Hot100 = new Solution_152_Hot100();
        System.out.println(solution152Hot100.maxProduct(
                new int[]{
//                        -2,3,-4
//                        2,3,-2,4
//                        -2,0,-1
                        -3,0,1,-2
                }
        ));
    }


}
