import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 给你一个整数数组 nums，返回数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 *
 * 提示：
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 输入 保证 数组 answer[i] 在  32 位 整数范围内
 *
 *
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */


public class Solution_238_Hot100 {
    public int[] productExceptSelf(int[] nums) {
//        int tempRightProduct = 1, tempLeftProduct = 1;
        int[] leftProductList = new int[nums.length];
        int[] rightProductList = new int[nums.length];
        Arrays.fill(leftProductList,1);
        Arrays.fill(rightProductList,1);
        for (int i = 1; i < nums.length; i++) {
            // leftProduct
            leftProductList[i] = leftProductList[i-1] * nums[i - 1];
            // rightProduct
            rightProductList[nums.length-1-i] = rightProductList[nums.length-i] * nums[nums.length - i];
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = leftProductList[i] * rightProductList[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution_238_Hot100 solution238Hot100 = new Solution_238_Hot100();
        int[] ints = solution238Hot100.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
