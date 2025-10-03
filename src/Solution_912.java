import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-09-04
 * @Description:
 */
public class Solution_912 {

    public int[] sortArray(int[] nums) {
        int[] counts = new int[100002];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] + 50000]++;
        }

        int i = 0;
        for (int j = 0; j < counts.length; j++) {
            if (counts[j] != 0){
                for (int i1 = 0; i1 < counts[j]; i1++) {
                    nums[i++] = j-50000;
                }
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        Solution_912 solution912 = new Solution_912();
        int[] array = solution912.sortArray(new int[]{0, 9, 8, 5, 4});
        System.out.println(Arrays.toString(array));
    }

}
