package Time2Hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-07
 * @Description: 二叉搜素树中第k小的元素
 */
public class Solution_230_Hot100 {

    // 中序遍历 - 入队列

    public boolean isFull = false;
    public int totalSize = 0;

    Deque<TreeNode> firstKNodeQueue = null;

    public int kthSmallest(TreeNode root, int k) {
        totalSize = k;
        firstKNodeQueue = new ArrayDeque<>(k);
        dfs(root);
        return firstKNodeQueue.removeLast().val;
    }

    private void dfs(TreeNode curNode) {
        if (curNode == null || isFull){
            return;
        }

        // zuo
        dfs(curNode.left);
        // zhong
        Insert2Que(curNode);
        // you
        dfs(curNode.right);
    }

    private void Insert2Que(TreeNode curNode) {

        if (firstKNodeQueue.size() == totalSize){
            isFull = true;
            return;
        }
        firstKNodeQueue.offerLast(curNode);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        Solution_230_Hot100 solution230Hot100 = new Solution_230_Hot100();
        System.out.println(solution230Hot100.kthSmallest(root, 3));
    }


}
