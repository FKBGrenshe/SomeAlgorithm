import java.util.Arrays;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 *
 *  示例 1:
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 *  示例 2:
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 提示:
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何子数组的乘积都 保证 是一个 32-位 整数
 */
public class Solution_152_Hot100 {

    public int maxProduct(int[] nums) {
        int[] dpPositive = new int[nums.length];
        int[] dpNegative = new int[nums.length];

        dpPositive[0] = nums[0];
        dpNegative[0] = nums[0];
        int[] tempArray = new int[5];

        for (int i = 1; i < dpPositive.length; i++) {

            int tempPositveProduct = dpPositive[i-1]*nums[i];
            int tempNegativeProduct = dpNegative[i-1]*nums[i];
            // 对5个数进行排序 tempPositveProduct, tempNegativeProduct, nums[i], dpPositive[i-1]*nums[i], dpNegative[i-1]*nums[i]
            tempArray[0] = tempPositveProduct;
            tempArray[1] = tempNegativeProduct;
            tempArray[2] = nums[i];
            tempArray[3] = dpPositive[i-1]*nums[i];
            tempArray[4] = dpNegative[i-1]*nums[i];
            Arrays.sort(tempArray);
            dpPositive[i] = tempArray[4];
            dpNegative[i] = tempArray[0];
        }

        Arrays.sort(dpPositive);
        return dpPositive[nums.length-1];
    }

    public static void main(String[] args) {
        Solution_152_Hot100 solution152Hot100 = new Solution_152_Hot100();
        System.out.println(solution152Hot100.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(solution152Hot100.maxProduct(new int[]{-2,3,-4}));
    }

}
