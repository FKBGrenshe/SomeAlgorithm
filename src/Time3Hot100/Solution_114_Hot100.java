package Time3Hot100;

public class Solution_114_Hot100 {


    public void flatten(TreeNode root) {

        if (root == null){
            return;
        }

        // left - mid - right

        flatten(root.left);
        changeCurNode(root);
        flatten(root.right);

    }

    private TreeNode changeCurNode(TreeNode curNode){
        if (curNode.left == null){
            return curNode;
        }

        TreeNode newRight = curNode.left;
        TreeNode newRightRight = curNode.right;

        curNode.left = null;
        curNode.right = null;


        findRight(newRight).right = newRightRight;

        curNode.right = newRight;
        return curNode;
    }

    private TreeNode findRight(TreeNode curNode) {

        if (curNode.right == null){
            return curNode;
        }
        else {
            return findRight(curNode.right);
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(5));
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        root.levelOrderPrint();

        Solution_114_Hot100 solution114Hot100 = new Solution_114_Hot100();
        solution114Hot100.flatten(root);

        root.levelOrderPrint();

    }

}
