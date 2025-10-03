/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-12
 * @Description: 最大连续1的个数Ⅲ
 */
public class Solution_1004 {

    public int longestOnes(int[] nums, int k) {

        int maxCount = 0;
        int tempZero = 0;

        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0){
                if (tempZero < k){
                    tempZero++;
                }else {
                    while (start < end && nums[start] != 0){
                        start++;
                    }
                    start++;
                    maxCount = Math.max(maxCount, end-start+1);
                }
            }
            maxCount = Math.max(maxCount, end-start+1);
        }

        return maxCount;
    }

    public static void main(String[] args) {

        Solution_1004 solution1004 = new Solution_1004();
        int[] nums = {
//                0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1
                1,1,1,0,0,0,1,1,1,1,0
        };
        int k =2;
        System.out.println(solution1004.longestOnes(
                nums, k
        ));

    }

}
