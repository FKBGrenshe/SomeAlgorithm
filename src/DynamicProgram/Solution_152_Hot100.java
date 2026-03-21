package DynamicProgram;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-21
 * @Description: 乘积最大子数组
 */
public class Solution_152_Hot100 {

    int dp[][];
    int maxVal = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {
        int size = nums.length;
        dp  = new int[size][size];

        for (int curColumn = 0; curColumn < size; curColumn++) {
            for (int curRow = 0; curRow < size; curRow++) {
                if (curRow > curColumn) break;
                if (curRow == curColumn){
                    dp[curRow][curColumn] = nums[curColumn];
                }else {
                    dp[curRow][curColumn] = dp[curRow][curColumn-1]*nums[curColumn];
                }
                maxVal = Math.max(maxVal, dp[curRow][curColumn]);
            }
        }

        return maxVal;
    }

    private int findMaxLastColumn(int curColumn) {
        int max = dp[0][curColumn];
        for (int curRow = 1; curRow <= curColumn; curRow++) {
            max = Math.max(dp[curRow][curColumn], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution_152_Hot100 solution152Hot100 = new Solution_152_Hot100();
        System.out.println(solution152Hot100.maxProduct(
                new int[]{
                        -2,3,-4
                }
        ));
    }

}
