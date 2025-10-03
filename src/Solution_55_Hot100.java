import java.util.Arrays;

public class Solution_55_Hot100 {
    public boolean canJump(int[] nums) {
        // 数组的含义转变
        // 原含义：第 i 个位置表示跳跃的最大长度
        // 新含义：第 i 个位置表示最远能跳到第 num[i]的位置上
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i;
        }
        // 从 0 ~ i-1 的位置上，能否跳到 i
        int maxJump = 0;
        for (int i = 1; i < nums.length; i++) {
            if (maxJump < nums[i-1]){
                maxJump = nums[i-1];
            }
            if (maxJump < i){
                return false;
            }
        }
        return true;
    }
}
