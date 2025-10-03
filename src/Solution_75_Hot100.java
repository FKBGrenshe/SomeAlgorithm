import java.util.Arrays;

public class Solution_75_Hot100 {
    public void sortColors(int[] nums) {
        int Zero = 0;
        int One= 0;
        int Two = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]){
                case 0: Zero++; break;
                case 1: One++; break;
                case 2: Two++; break;
            }
        }
        Arrays.fill(nums,0,Zero,0);
        Arrays.fill(nums,Zero,Zero+One,1);
        Arrays.fill(nums,Zero+One,nums.length,2);

        for (int num : nums) {
            System.out.print(num+" ");
        }

    }

    public static void main(String[] args) {
        Solution_75_Hot100 solution75Hot100 = new Solution_75_Hot100();
        solution75Hot100.sortColors(new int[]{
                2,0,1
        });
    }
}
