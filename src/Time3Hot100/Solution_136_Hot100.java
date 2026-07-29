package Time3Hot100;

public class Solution_136_Hot100 {

    int[] count = new int[30000*2 + 1];

    public int singleNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int curVal = nums[i];
            count[curVal+30000]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1){
                return i - 30000;
            }
        }

        return  -1;

    }
}
