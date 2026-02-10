package Time2Hot100;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-10
 * @Description: 二叉树的最大路径和
 */
public class Solution_124_Hot100 {

    Integer ans = -1111;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode curNode) {
        if (curNode == null){
            return 0;
        }

        // 当前路径的最大可能 是 左子树 + 右子树 + 本节点

        // 左、右
        int leftMax = dfs(curNode.left);
        int rightMax = dfs(curNode.right);
        // 中
        ans = Math.max(ans,curNode.val);
        ans = Math.max(ans, leftMax+curNode.val);
        ans = Math.max(ans, rightMax+curNode.val);
        ans = Math.max(ans, leftMax+rightMax+curNode.val);

        // 返回当前路径的最大路径之和
        return Math.max(curNode.val, curNode.val+Math.max(leftMax,rightMax));
    }

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.left = new TreeNode(2);

//        TreeNode root = new TreeNode(2);
//        root.right = new TreeNode(-2);
//        root.left = new TreeNode(-1);

//        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(9);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.left = new TreeNode(-6);
        root.right.right.left.right = new TreeNode(-6);
        root.right.right.left.left.left = new TreeNode(-6);


        Solution_124_Hot100 solution124Hot100 = new Solution_124_Hot100();
        System.out.println(solution124Hot100.maxPathSum(root));
    }

    /*
    *     2
    * -1   -2
    *
    * */


}
