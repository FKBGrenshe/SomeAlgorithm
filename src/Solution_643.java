/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-28
 * @Description: 子数组最大平均数
 */
public class Solution_643 {


    public double findMaxAverage(int[] nums, int k) {

        int curVal = 0;
        for (int i = 0; i < k; i++) {
            curVal += nums[i];
        }
        int maxVal = curVal;
        int maxStart = 0;

        for (int i = k; i < nums.length; i++) {
            curVal = curVal + nums[i] - nums[i-k];
            if (maxVal < curVal){
                maxVal = curVal;
                maxStart = i-k+1;
            }
        }

        double avg = 0;
        for (int i = 0; i < k; i++) {
            avg += nums[maxStart + i];
        }

        return avg/k;

    }

    public static void main(String[] args) {
        Solution_643 solution643 = new Solution_643();

        int[] nums = new int[]{
                1,12,-5,-6,50,3
        };
        int k = 4;


        System.out.println(solution643.findMaxAverage(
                nums,
                k
        ));
    }

}
