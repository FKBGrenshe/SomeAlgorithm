public class Solution_27 {
    public static int removeElement(int[] nums, int val) {
        int sum = 0;
        int rightIdx = nums.length - 1;
        /**
         *  [ x1,x2,x3,x4,...xn]
         *  -> 从左向右遍历，当nums[xi] == val时，
         *      将队尾元素赋值到xi位置，right向左位移一位
         *      xi不变，重新检擦当前改位后的队尾元素
         */
        for (int idx = 0; idx <= rightIdx; idx++) {
            if(nums[idx] == val){
                // 调换位置
                nums[idx] = nums[rightIdx];
                rightIdx--;
                sum ++;
                // 为了确保idx不变，要idx--
                idx--;
            }
        }
        return nums.length - sum;
    }

    public static void main(String[] args) {
        int result = removeElement(new int[]{0,1,2,2,3,0,4,2}, 3);
        System.out.println(result);
    }
}
