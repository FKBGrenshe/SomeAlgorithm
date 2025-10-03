import java.util.ArrayList;
import java.util.Arrays;

public class Solution_128_Hot100 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int difference = nums[0];
        int consecutiveNumbers = 1;
        int maxConsecutiveNumbers = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == i + difference - 1 ){
                // nums，说明是重复数字，跳过
                difference = nums[i] - i;
                continue;
            }
            if (nums[i] != difference + i){
                difference = nums[i] - i;
                consecutiveNumbers = 0;
            }
            consecutiveNumbers++;
            if (maxConsecutiveNumbers < consecutiveNumbers){
                maxConsecutiveNumbers = consecutiveNumbers;
            }
        }
        return maxConsecutiveNumbers;



    }
}
