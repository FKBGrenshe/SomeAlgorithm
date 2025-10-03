/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-12
 * @Description: 统计得分小于k的子数组数目
 */
public class Solution_2302 {

    public long countSubarrays(int[] nums, long k) {

        long count = 0;
        int start = 0;
        long sum = 0;

        for (int end = 0; end < nums.length; end++) {

            sum += nums[end];
            while (sum*(end-start+1)>= k){
                sum -= nums[start];
                start++;
            }
            count += end - start + 1;
        }

        return count;

    }


    public static void main(String[] args) {

        Solution_2302 solution2302 = new Solution_2302();

//        System.out.println(solution2302.calNums(0, 4));


        int[] nums = {
//                2,1,4,3,5
                1,1,1
        };
        long k = 5;
        System.out.println(solution2302.countSubarrays(
                nums, k
        ));

    }


}
