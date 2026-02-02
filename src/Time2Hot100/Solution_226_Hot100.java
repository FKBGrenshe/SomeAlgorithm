package Time2Hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-02
 * @Description:
 */
public class Solution_226_Hot100 {

    Deque<TreeNode> deque = new ArrayDeque<>();

    TreeNode temp = null;

    public TreeNode invertTree(TreeNode root) {
        doReverse(root);

        return root;
    }

    private void doReverse(TreeNode curNode) {
        if (curNode == null){
            return;
        }

        // 左
        doReverse(curNode.left);
        // 右
        doReverse(curNode.right);
        // 中
        temp = curNode.left;
        curNode.left = curNode.right;
        curNode.right = temp;


    }
}
