package Time3Hot100;

import java.util.Arrays;

public class Solution_283_Hot100 {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1){
            return;
        }

        int need2moveIdx = findFirstZero(nums);
        int curLastNullZero = findLastNullZero(nums);
        while ( need2moveIdx < curLastNullZero){

            totalMoveLeft(need2moveIdx, nums);

            need2moveIdx = findFirstZero(nums);
            curLastNullZero = findLastNullZero(nums);
        }

    }

    private int findFirstZero(int[] nums){
        for(int i = 0; i <nums.length; i++){
            if (nums[i] == 0){
                return i;
            }
        }
        return -1;
    }

    private int findLastNullZero(int[] nums){
        for(int i = nums.length-1; i >= 0; i--){
            if (nums[i] != 0){
                return i;
            }
        }
        return -1;
    }

    private void totalMoveLeft(int startIdx, int[] nums){
        while (startIdx < nums.length){
            nums[startIdx-1] = nums[startIdx];
            startIdx++;
        }
    }


    public static void main(String[] args) {
        Solution_283_Hot100 solution283Hot100 = new Solution_283_Hot100();
        int[] nums = new int[]{0,1,0,3,1};

        solution283Hot100.moveZeroes(nums);

        System.out.printf(Arrays.toString(nums));
    }

}
