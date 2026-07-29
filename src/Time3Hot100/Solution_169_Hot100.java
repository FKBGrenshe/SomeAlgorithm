package Time3Hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution_169_Hot100 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(nums.length);

        int appearTimes = nums.length % 2 == 0 ? nums.length/2 : nums.length/2+1;

        for (int i = 0; i < nums.length; i++) {
            int curval = nums[i];
            boolean flag = doCount(count, curval, appearTimes);
            if (flag){
                return curval;
            }
        }
        return -1;
    }

    private boolean doCount(Map<Integer, Integer> count, int curval, int appearTimes) {

        if (count.containsKey(curval)){
            count.put(curval, count.get(curval)+1);
        }else {
            count.put(curval, 1);
        }

        if (count.get(curval) == appearTimes){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{
                2
        };

        Solution_169_Hot100 solution169Hot100 = new Solution_169_Hot100();
        System.out.println(solution169Hot100.majorityElement(nums));

    }

}
