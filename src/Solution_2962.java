import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-12
 * @Description: 统计最大元素出现至少k次的子数组
 */
public class Solution_2962 {

    public long countSubarrays(int[] nums, int k) {

        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        long count = 0;
        int tempK = 0;

        int start = 0;
        int end = start;
        if (nums[end] == maxVal){
            tempK++;
        }
        while (start <= nums.length-1){
            if (start > end){
                end = start;
                if (nums[end] == maxVal){
                    tempK++;
                }
            }
            while (end < nums.length-1 && tempK < k){
                end++;
                if (nums[end] == maxVal){
                    tempK++;
                }
            }
            if (tempK == k){
                count += nums.length-1 - end + 1;
                if (nums[start] == maxVal){
                    tempK--;
                }
                start++;
            }else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_2962 solution2962 = new Solution_2962();

        int[] nums = {
//                1,3,2,3,3
//                1,4,2,1
                73,52,73,40,73
//                73,54,15,4,23,70,53,65,73,73,2,72,36,71,73,69,35,18,62,73,62,73,73,50,30,73,20,71,60,9,12,57,48,73,40,20,8,73,73,73,34,59,31,49,73,5,51,36,47,38,36,58,34,42,23,28,52,73
//                28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49
//                91,91,91,47,91,61,49
        };
        int k = 1;
        System.out.println(solution2962.countSubarrays(
                nums, k
        ));
    }

}
