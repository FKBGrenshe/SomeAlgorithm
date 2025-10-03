import java.util.Arrays;

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 *  更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 *      那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 *      如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */

public class Solution_31_Hot100 {
    public void nextPermutation(int[] nums) {

        boolean hasBiggerFlag = false;

        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i-1] < nums[i]){
                hasBiggerFlag = true;
                // 表示找到一个比前一个数大的数
                if (i == nums.length-1){
                    // 说明 原数就是最小数，只需交换最后两位
                    int temp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = temp;
//                    System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
                    return;
                }
                // 说明 [i, nums.length-1] 已经是最大数了
                for (int j = i + 1; j < nums.length; j++) {
                    // i-1, i, ... ,j-1, j,...
                    // 找到比 nums[i-1] 大的最小的数 -- nums[j]前面的数
                    if (nums[j] <= nums[i-1]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[j-1];
                        nums[j-1] = temp;
                        // 将 i ~ num.length-1 的数都进行排序
                        Arrays.sort(nums, i, nums.length);
//                        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
                        return;
                    }
                }
                // 如果for循环没有return，说明j超出了范围，即 从 i之后，每一个都比 nums[i-1]大，因此和最后面的比他大的数交换位置
                int needChangeIdx = -1;
                for (int j = nums.length-1; j > i-1; j--) {
                    if (nums[j] > nums[i-1]){
                        needChangeIdx = j;
                        break;
                    }
                }
                int temp = nums[i-1];
                nums[i-1] = nums[needChangeIdx];
                nums[needChangeIdx] = temp;
                // 将 i ~ num.length-1 的数都进行排序
                Arrays.sort(nums, i, nums.length);
//                        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
                return;
            }
        }

        if (!hasBiggerFlag){
            Arrays.sort(nums);
        }
//        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }
    public static void main(String[] args) {
        Solution_31_Hot100 solution31Hot100 = new Solution_31_Hot100();
//        solution31Hot100.nextPermutation(new int[]{5,4,7,5,3,2});
//        solution31Hot100.nextPermutation(new int[]{1,3,2});
//        solution31Hot100.nextPermutation(new int[]{1,2,3});
//        solution31Hot100.nextPermutation(new int[]{3,2,1});
//        solution31Hot100.nextPermutation(new int[]{1,1,5});
//        solution31Hot100.nextPermutation(new int[]{1,5,1});
        solution31Hot100.nextPermutation(new int[]{2,2,7,5,4,3,2,2,1});
    }
}
