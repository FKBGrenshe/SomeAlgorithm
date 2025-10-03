import com.sun.source.tree.Tree;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-23
 * @Description: 108将有序数组转换为二叉搜索树
 */
public class Solution_108_Hot100 {

    TreeNode root = null;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }

        if (nums.length == 1){
            return new TreeNode(nums[0]);
        }

        TreeNode curRoot = new TreeNode(nums[nums.length / 2]);
        curRoot.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
        curRoot.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return curRoot;
    }

    public TreeNode buildTree(int[] nums){
        if (nums.length == 0){
            return null;
        }

        if (nums.length == 1){
            return new TreeNode(nums[0]);
        }

        TreeNode curRoot = new TreeNode(nums[nums.length / 2]);
        curRoot.left = buildTree(Arrays.copyOfRange(nums,0,nums.length/2));
        curRoot.right = buildTree(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return curRoot;
    }

    public static void main(String[] args) {
        // [-10,-3,0,5,9]
        int[] nums = {-10,-3,0,5,9};
        Solution_108_Hot100 solution108Hot100 = new Solution_108_Hot100();
        TreeNode root = solution108Hot100.sortedArrayToBST(nums);
    }
}
