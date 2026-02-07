package Time2Hot100;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-05
 * @Description: 对称二叉树的递归判断
 */
public class Solution_101_Hot100_method2 {


    public boolean isSymmetric(TreeNode root) {
        return doCheck(root.left, root.right);
    }

    private boolean doCheck(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return left.val == right.val && doCheck(left.left, right.right) && doCheck(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
        Solution_101_Hot100_method2 solution101Hot100 = new Solution_101_Hot100_method2();
        System.out.println(solution101Hot100.isSymmetric(root));
    }
}
