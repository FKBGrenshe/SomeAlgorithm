/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-08
 * @Description: 乘积小于k的子数组个数
 */
public class Solution_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int count = 0;
        int product = 1;

        for (int curidx = 0; curidx < nums.length; curidx++) {

            int nextidx = curidx;
            while (nextidx < nums.length){

                product *= nums[nextidx];

                if (product < k){
                    count++;
                    nextidx++;
                }else {
                    break;
                }
            }
            product = 1;

        }

        return count;
    }


    public int numSubarrayProductLessThanKV2(int[] nums, int k) {

        if (k == 0 || k == 1){
            return 0;
        }

        int product = 1;
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k){
                product /= nums[left++];
            }
            count += right - left + 1;
        }

        return count;

    }

    public static void main(String[] args) {
        Solution_713 solution713 = new Solution_713();

//        int[] nums = {10,5,2,6};
        int[] nums = {1,1,1};
        int k = 1;

        System.out.println(solution713.numSubarrayProductLessThanKV2(nums, k));
    }




}
