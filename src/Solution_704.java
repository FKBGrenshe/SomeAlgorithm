public class Solution_704 {
    public static int search(int[] nums, int target) {
        // 判断 数组长度合法
        if(nums.length == 0){
            return -1;
        }
        // 初始化左、中、右索引
        int leftIdx = 0, rightIdx = nums.length - 1 , mediumIdx = nums.length/2;
        /**
         * if 中索引 < target { 整个判断区间在右边 right }
         * if 中索引 > target { 整个判断区间在左边 left  }
         * -------------------------------------------
         * if 中索引 = target { 返回中索引 }
         * -------------------------------------------
         * if 左索引 > 右索引 或者 右索引 < 左索引 {越界，return-1}
         */

        while (!(leftIdx > rightIdx )) {
            if (nums[mediumIdx] == target){
                return mediumIdx;
            }else if (nums[mediumIdx] < target){
                leftIdx = mediumIdx + 1;
                mediumIdx = (leftIdx + rightIdx) / 2;
            }else if (nums[mediumIdx] > target){
                rightIdx = mediumIdx - 1;
                mediumIdx = (leftIdx + rightIdx) / 2;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int result = search(new int[]{-1,0,3,5,9,12}, 2) ;
        System.out.println(result);
    }
}
