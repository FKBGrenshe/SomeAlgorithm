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
public class Solution_701_Hot100 {

    TreeNode parrentNode = null;

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null){
            return new TreeNode(val);
        }

        if (val < root.val){

            root.left = insertIntoBST(root.left,val);
        }
        if (val > root.val){
            root.right = insertIntoBST(root.right,val);
        }

        return root;
    }

    public void insertFunc(TreeNode curNode, int val){
        if (curNode == null){
            // 找到应该插入的位置
            curNode = new TreeNode(val);
            if (parrentNode.val < val){
                parrentNode.right = curNode;
            } else {
                parrentNode.left = curNode;
            }
            return;
        }

        parrentNode = curNode;

        if (val < curNode.val){
            insertFunc(curNode.left,val);
        }
        if (curNode.val > val){
            insertFunc(curNode.right,val);
        }

    }

    public static void main(String[] args) {
        Solution_701_Hot100 solution701Hot100 = new Solution_701_Hot100();
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);
        solution701Hot100.insertIntoBST(root,25);
    }

}
