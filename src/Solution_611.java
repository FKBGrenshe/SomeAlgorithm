import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-30
 * @Description: 有效三角形的个数
 *  1. 两边之差大于第三边 -> min > max-mid
 *  2. 两边之和小于第三边 -> max < min+mid
 *  https://leetcode.cn/problems/valid-triangle-number/solutions/3671044/minmidmaxwei-shi-yao-yao-gu-ding-zui-da-3vuo5/
 */
public class Solution_611 {

    int count = 0;

    public int triangleNumber(int[] nums) {

        // min + mid > max

        Arrays.sort(nums);

        for (int max = nums.length-1; max > 1; max--) {
            int min = 0;
            int mid = max-1;


            while (min < mid){
                int legal = nums[min] + nums[mid] - nums[max];
                if (legal > 0){
                    // min + mid > max
                    count+= mid-min;
                    mid--;
                }else {
                    // min + mid <= max
                    min++;
                }
            }
        }

        return count;
    }





    public static void main(String[] args) {
        Solution_611 solution611 = new Solution_611();
        int[] nums = new int[]{
            2,2,3,4
        };
//        System.out.println(solution611.triangleNumberV2(nums));
    }
}
