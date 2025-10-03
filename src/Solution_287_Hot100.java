public class Solution_287_Hot100 {
    public static int findDuplicate(int[] nums) {
        int[] existsList = new int[nums.length +1];
        for (int i = 0; i < nums.length; i++) {
            if (++existsList[nums[i]] > 1){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1,3,4,2,2
        };
        System.out.println(findDuplicate(nums));
    }
}
