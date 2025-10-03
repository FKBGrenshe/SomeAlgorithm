import java.util.Arrays;

public class Solution_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums.length == 0){
            return null;
        }

        int maxValue = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue){
                maxValue = nums[i];
                maxIdx = i;
            }
        }

        TreeNode curRootNode = new TreeNode(maxValue);

        if (maxIdx > 0){
            curRootNode.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
        }
        if (maxIdx < nums.length){
            curRootNode.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx+1, nums.length));
        }

        return curRootNode;
    }

//    public TreeNode buildTree(int[] nums, int){
//
//    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution_654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode);
    }
}
