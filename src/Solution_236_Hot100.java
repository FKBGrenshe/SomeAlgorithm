/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-23
 * @Description: 236二叉树的最近公共祖先
 */
public class Solution_236_Hot100 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null){
            return null;
        }

        // 递归逻辑 -- 后序遍历 -- 左右（自底向上找） -> 中（处理逻辑）
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        // 处理逻辑
        if (root.val == p.val || root.val == q.val){
            // 1. 如果当前节点就是目标节点之一 -- 返回当前节点
            return root;
        }
        // 2. 如果当前节点不是，返回左右子树中不为null的节点，若两个子树返回节点均不为null，返回当前节点
        else {
            if (leftResult != null && rightResult != null){
                return root;
            }else {
                return leftResult != null ? leftResult : rightResult;
            }
        }

    }

    public static void main(String[] args) {
        Solution_236_Hot100 solution236Hot100 = new Solution_236_Hot100();

        // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode treeNode = solution236Hot100.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
        System.out.println(treeNode.val);

    }

}
