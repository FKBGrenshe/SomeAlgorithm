import java.util.HashMap;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-24
 * @Description: 437路经综合Ⅲ
 */
public class Solution_437_Hot100 {

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null){
            return 0;
        }

        findSum(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return count;
    }

    public void findSum(TreeNode curNode, long targetSum){
        if (curNode == null){
            return;
        }

        long curVal = curNode.val;

        // 前序遍历
        if (targetSum - curVal == 0){
            count++;
        }
        findSum(curNode.left, targetSum - curVal);
        findSum(curNode.right, targetSum - curVal);
    }

    public static void main(String[] args) {
        Solution_437_Hot100 solution437 = new Solution_437_Hot100();
        //root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);*/
        // root [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000] = targetSum = 0
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);
        System.out.println(solution437.pathSum(root, 8));
    }
}
