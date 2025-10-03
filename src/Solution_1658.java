import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-13
 * @Description: 将x减到0的最小操作数
 */
public class Solution_1658 {
    public int minOperations(int[] nums, int x) {

        int len = Integer.MIN_VALUE;
        boolean flag = true;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        if (target < 0){
            return -1;
        }
        if (target == 0){
            return nums.length;
        }

        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > target){
                sum -= nums[left];
                left++;
            }

            if (sum == target){
                len = Math.max(right-left+1,len);
            }


        }

        return len == Integer.MIN_VALUE ? -1 : nums.length - len;

    }

    public static void main(String[] args) {
        Solution_1658 solution1658 = new Solution_1658();

        int[] nums = {
//                5,6,7,8,9
//                3,2,20,1,1,3
                8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309
        };
        int x = 134365;

        System.out.println(solution1658.minOperations(
                nums, x
        ));
    }

}
