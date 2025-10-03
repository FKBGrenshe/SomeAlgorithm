import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_114_Hot100 {
    public void flatten(TreeNode root) {

        Deque<TreeNode> deque = new LinkedList<>();

        preorderFunc(root,deque);

        TreeNode head = new TreeNode();
        TreeNode curNode = null;
        head.right = deque.pollFirst();
        curNode = head.right;
        while (!deque.isEmpty()){
            curNode.right = deque.pollFirst();
            curNode = curNode.right;
        }
        curNode = head;
        while (curNode!=null){
            curNode.left = null;
            curNode = curNode.right;
        }

    }

    public void preorderFunc(TreeNode curNode, Deque deque){
        if (curNode == null){
            return;
        }
        // mid - left - right
        deque.addLast(curNode);
        preorderFunc(curNode.left,deque);
        preorderFunc(curNode.right,deque);

    }


    /*public void flattenFunc(TreeNode currentNode){

    }*/

    public static void main(String[] args) {
        Solution_114_Hot100 solution114 = new Solution_114_Hot100();
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root.left = root2;
        root.right = root5;
        root2.left = root3;
        root2.right = root4;
        root5.right = root6;

        solution114.flatten(root);
    }
}
