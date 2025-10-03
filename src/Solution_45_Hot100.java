public class Solution_45_Hot100 {
    public int jump(int[] nums) {
        if (nums[0] == 0 || nums.length == 1){
            return 0;
        }
        int needJump = nums.length-1;
        int totalJump = 0;
        int maxJumplength = 0;
        int maxJumpIdx = -1;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] + i >= nums.length-1){
                return totalJump+1;
            }
            // j是第i个能跳跃的范围
            // 在第i个位置上，可以跳到的索引范围是[i+1,i+nums[i]]
            // 遍历[i+1,i+nums[i]]，找到下一次能跳到的最大索引就是我这一步的最优解
            for (int j = i+1; j <= nums[i] + i; j++) {
                int tempJump = j + nums[j];
                if (tempJump > maxJumplength){
                    maxJumplength = tempJump;
                    maxJumpIdx = j;
                }
            }
            i = maxJumpIdx;
            maxJumplength = 0;
            totalJump++;
        }
        return totalJump;
    }

    public static void main(String[] args) {
        int jump = new Solution_45_Hot100().jump(new int[]{0});
        System.out.println(jump);
    }
}
