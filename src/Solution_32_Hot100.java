import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 *
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 */
public class Solution_32_Hot100 {
    public int search(int[] nums, int target) {

        if (nums.length <= 10){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target){
                    return i;
                }
            }
            return -1;
        }

        int leftIdx = 0, rightIdx = nums.length - 1, mediumIdx = nums.length / 2;

        // 查找旋转点: medianIdx 是否有序
        while (leftIdx <= rightIdx){
            if (nums[mediumIdx] < nums[mediumIdx +1] && nums[mediumIdx] < nums[mediumIdx - 1]){
                // mediumIdx就是旋转点
                int tempIdx = nums[0] < target ? binarySearch(Arrays.copyOfRange(nums, 0, mediumIdx), target): binarySearch(Arrays.copyOfRange(nums, mediumIdx, nums.length), target);
                if (tempIdx != -1){
                    return nums[0] < target ? tempIdx : tempIdx + mediumIdx;
                }else {
                    return -1;
                }
            }
            if (nums[mediumIdx] < nums[leftIdx]){
                // 旋转点在左边
                rightIdx = mediumIdx;
                mediumIdx = (leftIdx + mediumIdx) / 2;
            } else if (nums[mediumIdx] > nums[rightIdx]) {
                // 旋转点在右边
                leftIdx = mediumIdx;
                mediumIdx = (leftIdx + rightIdx) / 2;
            }
        }

        return -1;

    }

    // binary search
    public int binarySearch(int[] nums, int target){

        int leftIdx = 0, rightIdx = nums.length - 1, mediumIdx = nums.length / 2;
        while (leftIdx <= rightIdx){
            if (nums[mediumIdx] == target){
                // found it
                return mediumIdx;
            }
            if (nums[mediumIdx] < target){
                leftIdx = mediumIdx + 1;
            }else {
                rightIdx = mediumIdx - 1;
            }
            mediumIdx = (leftIdx + rightIdx) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution_32_Hot100().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(new Solution_32_Hot100().search(new int[]{15,16,19,20,25,1,3,4,5,7,10,14}, 25));
//        System.out.println(new Solution_32_Hot100().search(new int[]{279,284,285,287,288,296,2,8,10,11,12,13,14,19,20,22,25,26,27,28,29,33,37,39,42,43,47,48,49,50,57,62,63,66,68,69,71,73,74,77,78,79,85,89,92,94,99,111,113,117,120,122,125,134,145,152,155,157,160,161,167,168,181,182,188,189,190,194,199,201,204,208,213,220,223,225,226,227,231,237,240,242,247,254,259,260,261,264,267,271,275}, 25));
        System.out.println(new Solution_32_Hot100().search(new int[]{150,151,152,156,158,159,160,161,162,167,169,170,171,177,180,183,184,186,189,191,197,200,203,205,210,215,216,219,221,222,233,236,237,238,239,246,247,250,254,257,260,261,262,269,275,279,283,284,286,287,288,289,290,294,295,298,1,5,6,9,10,13,15,16,20,25,27,28,34,37,41,42,43,46,48,51,53,54,59,61,65,67,72,76,78,79,81,83,85,91,92,94,95,102,103,105,106,111,113,118,120,122,123,126,141,148}, 55));
    }

}
