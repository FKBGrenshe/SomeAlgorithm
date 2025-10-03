import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */

public class Solution_189_Hot100 {
    public void rotate(int[] nums, int k) {

        if (nums.length < k){
            k = k % nums.length;
        }

        int[] newLeft = Arrays.copyOfRange(nums, nums.length-k, nums.length);
        int[] newRight = Arrays.copyOf(nums,nums.length-k);

        for (int i = 0; i < newLeft.length; i++) {
            nums[i] = newLeft[i];
        }
        for (int i = 0; i < newRight.length; i++) {
            nums[i + newLeft.length] = newRight[i];
        }
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        Solution_189_Hot100 solution189Hot100 = new Solution_189_Hot100();
//        solution189Hot100.rotate(new int[]{1,2,3,4,5,6,7}, 3);
//        solution189Hot100.rotate(new int[]{-1,-100,3,99}, 2);
        solution189Hot100.rotate(new int[]{-1}, 2);
    }

}
