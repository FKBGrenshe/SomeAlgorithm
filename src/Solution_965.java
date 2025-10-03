/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-06-05
 * @Description: 单值二叉树
 */
public class Solution_965 {

    private int value = -1;
    private boolean flag = true;

    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        value = root.val;
        dfs(root);
        return flag;
    }

    public void dfs(TreeNode curNode){
        if(!flag || curNode == null){
            return;
        }

        flag = curNode.val == value;
        dfs(curNode.left);
        dfs(curNode.right);
        return;
    }
}
