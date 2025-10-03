import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 *  示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class Solution_34_Hot100 {
    public int[] searchRange(int[] nums, int target) {

        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        int medianIdx = (leftIdx + rightIdx) / 2;

        while (leftIdx <= rightIdx){
            if (nums[medianIdx] == target){
                // found it
                for (int left = medianIdx; left >= 0; left--) {
                    if (nums[left] < target){
                        leftIdx = left+1;
                        break;
                    }
                }
                for (int right = medianIdx; right < nums.length; right++) {
                    if (nums[right] > target){
                        rightIdx = right-1;
                        break;
                    }
                }
                return new int[]{leftIdx, rightIdx};
            }
            if (nums[medianIdx] > target){
                rightIdx = medianIdx - 1;
            }else {
                leftIdx = medianIdx + 1;
            }
            medianIdx = (leftIdx + rightIdx) / 2;
        }

        // unfounded it
        return new int[]{-1, -1};
    }



    public int[] searchRangeV2(int[] nums, int target) {

        int[] ans = {-1,-1};
        if (nums.length == 0){
            return ans;
        }

        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while (left <= right){
            mid = (left+right)/2;

            if (nums[mid] < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        for (int i = left; i < nums.length; i++) {
            if (ans[0] == -1){
                if(nums[i] == target){
                    ans[0] = i;
                }
            } else {
                if (nums[i] != target){
                    ans[1] = i-1;
                    break;
                }
            }
        }

        if (ans[0] == -1){
            return ans;
        }else {
            ans[1] = ans[1] != -1 ? ans[1] : nums.length-1;
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution_34_Hot100 solution34Hot100 = new Solution_34_Hot100();
//        System.out.println(Arrays.toString(solution34Hot100.searchRangeV2(new int[]{5,7,7,8,8,10}, 8)));
//        System.out.println(Arrays.toString(solution34Hot100.searchRangeV2(new int[]{1,2,3}, 2)));
        System.out.println(Arrays.toString(solution34Hot100.searchRangeV2(new int[]{1}, 0)));
    }
}
