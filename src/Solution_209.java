/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-08
 * @Description: 长度最小的子数组
 */
public class Solution_209 {
    public int minSubArrayLen(int target, int[] nums) {

        int length = nums.length+1;


        int left = 0;
        int right = 0;
        int sum = nums[0];

        while (right < nums.length){

            if (sum >= target){
                length = Math.min(length,right-left+1);
                sum -= nums[left++];
            } else {
                if (right == nums.length - 1){
                    break;
                }
                right++;
                sum += nums[right];
            }

            if (left >= nums.length || right >= nums.length){
                break;
            }

            if (left > right){
                right = left;
                sum = nums[right];
            }

        }



        return length != nums.length+1 ? length : 0;
    }

    public int minSubArrayLenV1(int target, int[] nums) {
        int length = nums.length+1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum - nums[left] >= target){
                sum -= nums[left++];
            }
            if (sum >= target){
                length = Math.min(length,right-left+1);
            }
        }
        return length == nums.length+1 ? 0 : length;
    }

    public static void main(String[] args) {
        Solution_209 solution209 = new Solution_209();

        int target = 11;
        int[] nums = {1,2,3,4,5};
//        int[] nums = {2,3,1,2,4,3};

        System.out.println(solution209.minSubArrayLenV1(
                target, nums
        ));
    }
}
