package Time2Hot100;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-10
 * @Description: 二叉树的最近公共祖先
 */
public class Solution_236_Hot100_method2 {

    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }

    private boolean dfs(TreeNode curNode, TreeNode p, TreeNode q) {
        if (curNode == null){
            return false;
        }

        boolean left_son = dfs(curNode.left, p, q);
        boolean right_son = dfs(curNode.right, p, q);

        if (left_son && right_son || (curNode.val==p.val||curNode.val==q.val)&&(left_son||right_son)){
            ans = curNode;
            return true;
        }

        return left_son || right_son || curNode.val==p.val||curNode.val==q.val;

    }

}
