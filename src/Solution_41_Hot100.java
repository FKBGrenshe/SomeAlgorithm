import java.util.Arrays;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 */

public class Solution_41_Hot100 {
    public int firstMissingPositive(int[] nums) {
        // 创建一个长度为100000的数组，用来记录1~10000中所有数字是否出现过
        int[] ints = new int[100200];
        for (int num : nums) {
            if (num > 0 && num < 100200){
                ints[num] = 1;
            }
        }
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] == 0){
                return i;
            }
        }
        return -1;

        /*Arrays.sort(nums);
        int values = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                if (nums[i] == values){
                    values++;
                }
                else if (nums[i] < values){
                    continue;
                }
                else {
                    return values;
                }
            }
        }
        return values++;*/
    }

    public static void main(String[] args) {
//        int i = new Solution_41_Hot100().firstMissingPositive(new int[]{1, 2, 0});
//        int i = new Solution_41_Hot100().firstMissingPositive(new int[]{3,4,-1,1});
//        int i = new Solution_41_Hot100().firstMissingPositive(new int[]{7,8,9,11,12});
        int i = new Solution_41_Hot100().firstMissingPositive(new int[]{0,2,2,1,1});
        System.out.println(i);
    }
}
