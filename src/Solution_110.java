import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-06-03
 * @Description: 平衡二叉树
 */
public class Solution_110 {

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root,1);
        return flag;
    }

    private int dfs(TreeNode curNode, int curHeigh){
        if (curNode == null || !flag){
            return curHeigh;
        }

        int leftHeigh = dfs(curNode.right, curHeigh + 1);
        int rightHeigh = dfs(curNode.left, curHeigh + 1);

        if (Math.abs(leftHeigh-rightHeigh) > 1)
            flag = false;

        return Math.max(leftHeigh,rightHeigh);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);


        Solution_110 solution110 = new Solution_110();
        System.out.println(solution110.isBalanced(root));
    }

    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (index < values.length) {
            TreeNode current = queue.poll();
            if (current == null) continue;

            // 构建左子节点
            if (index < values.length && values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.offer(current.left);
            }
            index++;

            // 构建右子节点
            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }



}
