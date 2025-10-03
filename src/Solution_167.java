import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-30
 * @Description: 两数之和Ⅱ
 */
public class Solution_167 {


    public int[] twoSum(int[] numbers, int target) {

        int small = 0;
        int big = numbers.length-1;
        int curSum = 0;
        while (small < big){
            curSum = numbers[small] + numbers[big];
            if (curSum < target){
                small++;
            }else if (curSum > target){
                big--;
            }else {
                return new int[]{small+1, big+1};
            }
        }

        return null;

    }

}
