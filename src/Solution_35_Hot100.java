/**
 * 35. 搜索插入位置
 */
public class Solution_35_Hot100 {
    public static int searchInsert(int[] nums, int target) {

        if(nums.length == 0){
            return 0;
        }

        int left_index = 0;
        int right_index = nums.length-1;
        int median_index = (left_index + right_index)/2;

        while (left_index <= right_index){
            if(nums[median_index] == target){
                return median_index;
            }else if(nums[median_index] < target){
                left_index = median_index + 1;
            }else {
                right_index = median_index -1;
            }
            median_index = (left_index + right_index)/2;
        }
        return left_index;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}
