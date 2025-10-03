public class Solution_977 {
    public static int[] sortedSquares(int[] nums) {
        // 判断数组合法
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }
        
        /**
         * 找出 medium最小值
         */
        int mediumIdx = nums.length / 2;
        int leftIdx = mediumIdx - 1, rightIdx = mediumIdx + 1;
        while (leftIdx > 0 && mediumIdx < nums.length){
            // left > medium > right
            if(nums[leftIdx] > nums[mediumIdx] && nums[mediumIdx] > nums[rightIdx]){
                mediumIdx /= 2;
                leftIdx = mediumIdx - 1;
                rightIdx = mediumIdx + 1;
            }
            // reft < medium < right
            else if(nums[leftIdx] < nums[mediumIdx] && nums[mediumIdx] < nums[rightIdx]){
                mediumIdx += mediumIdx/2;
                leftIdx = mediumIdx - 1;
                rightIdx = mediumIdx + 1;
            }
            else { // 找到了
                break;
            }
        }
        System.out.println(mediumIdx);

        return nums;
    }

    public static void main(String[] args) {
        sortedSquares(new int[]{-7, -3, 2, 3, 11});
    }
}
