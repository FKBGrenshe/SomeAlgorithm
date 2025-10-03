/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-21
 * @Description: 删除有序数组中的重复项2
 */
public class Solution_80 {
    public int removeDuplicates(int[] nums) {

        int curVal = Integer.MAX_VALUE;
        int curValTimes = 0;
        int writeIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (curVal != nums[i]){
                curVal = nums[i];
                curValTimes = 1;
                nums[writeIdx] = curVal;
                writeIdx++;
            }else if(curVal == nums[i] && curValTimes < 2){
                curValTimes ++;
                nums[writeIdx] = curVal;
                writeIdx++;
            }
        }
        return writeIdx;
    }

    public static void main(String[] args) {
        Solution_80 solution80 = new Solution_80();
        System.out.println(solution80.removeDuplicates(
                new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
        ));
    }
}
