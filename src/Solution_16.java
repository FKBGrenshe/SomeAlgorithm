import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-05
 * @Description: 最接近的三数之和
 */
public class Solution_16 {

    int minDist = Integer.MAX_VALUE;
    int minVal = -1;

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        for (int max = nums.length-1; max > 1; max--) {
            int min = 0;
            int mid = max-1;
            while (min < mid){
                int curDist = target - (nums[min] + nums[mid] + nums[max]);
                if (curDist == 0){
                    return target;
                } else if (Math.abs(curDist) < minDist) {
                    minDist = Math.abs(curDist);
                    minVal = nums[min] + nums[mid] + nums[max];
                }

                if (curDist > 0){
                    min++;
                }else {
                    mid--;
                }
            }
        }

        return minVal;
    }

    public static void main(String[] args) {

        Solution_16 solution16 = new Solution_16();
//
//        int[] nums = {-1,2,1,-4};
//        int target = 1;

        int[] nums = {-1,2,1,5,6,7,8,9,0,-4,1};
        int target = 1;

        System.out.println(solution16.threeSumClosest(
                nums, target
        ));
    }

}
