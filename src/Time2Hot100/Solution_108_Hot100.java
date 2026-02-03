package Time2Hot100;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-02
 * @Description:
 */
public class Solution_108_Hot100 {

    public TreeNode sortedArrayToBST(int[] nums) {

        int middleIdx = nums.length/2;
        TreeNode root = new TreeNode(nums[middleIdx]);
        if (middleIdx-1 >= 0){
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,middleIdx));
        }
        if (middleIdx+1 < nums.length){
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums,middleIdx+1, nums.length));
        }

        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        Solution_108_Hot100 solution108Hot100 = new Solution_108_Hot100();
        TreeNode treeNode = solution108Hot100.sortedArrayToBST(nums);
    }

}
