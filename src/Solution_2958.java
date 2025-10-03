import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-09
 * @Description: 最多k个重复元素的最长子数组
 */
public class Solution_2958 {

    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> hashs = new HashMap<>(nums.length+1);

        int count = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            int key = nums[right];

            if (!hashs.containsKey(key)){
                hashs.put(key,1);
            }else {

                int curTimess = hashs.get(key);

                if (curTimess>= k){
                    while (nums[left]!= nums[right]){
                        //hashs[nums[left]]--;
                        hashs.put(nums[left],hashs.get(nums[left])-1);
                        left++;
                    }
                    left++;

                }else {
                    hashs.put(key,curTimess+1);
                }
            }
//            if (hashs[nums[right]] < k) {
//                hashs[nums[right]]++;
//            } else{
//                while (nums[left]!= nums[right]){
//                    hashs[nums[left]]--;
//                    left++;
//                }
//                left++;
//            }
            count = Math.max(count, right - left + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        Solution_2958 solution2958 = new Solution_2958();

        int[] nums = {
                1,2,1,2,1,2,1,2
        };
        int k = 1;

        System.out.println(solution2958.maxSubarrayLength(nums, k));
    }

}
