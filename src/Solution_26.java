import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-21
 * @Description: 删除有序数组中的重复项
 */
public class Solution_26 {
    /**
     * 1 <= nums.length <= 3 * 104
     * -10^4 <= nums[i] <= 10^4
     * @param nums
     * @return
     */

    int res = 10000;

    public int removeDuplicates2(int[] nums) {
        int[] copy = new int[2*res+1];
        Arrays.fill(copy, 0);

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i]+res;
            copy[value]++;
        }

        int index = 0;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != 0){
                int idx = i - res;
                nums[index] = idx;
                index++;
            }
        }
        return index;
    }

    public int removeDuplicates(int[] nums) {

        int curVal = Integer.MAX_VALUE;
        int writeIdx=0;

        for (int i = 0; i < nums.length; i++) {
            if (curVal != nums[i]){
                curVal = nums[i];
                nums[writeIdx] = curVal;
                writeIdx++;
            }
        }
        return writeIdx;

    }


    public static void main(String[] args) {
        Solution_26 solution26 = new Solution_26();
        System.out.println(solution26.removeDuplicates(
                new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
        ));
    }
}
