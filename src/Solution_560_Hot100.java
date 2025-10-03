import java.util.LinkedList;

class Solution_560_Hot100 {
    public int subarraySum(int[] nums, int k) {

        int count = 0;

        int[] valueList = new int[nums.length + 1];
        valueList[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            valueList[i+1] = valueList[i] + nums[i];
        }

        for (int startIdx = 0; startIdx < valueList.length; startIdx++) {
            for (int endIdx = startIdx + 1; endIdx < valueList.length; endIdx++) {
                if (valueList[endIdx] - valueList[startIdx] == k){
                    count++;
                }
            }
        }

        return count;




    }

    public static void main(String[] args) {
        Solution_560_Hot100 solution560 = new Solution_560_Hot100();
        int[] nums = {1};
        int k = 0;
        System.out.println(solution560.subarraySum(nums, k));
    }

}