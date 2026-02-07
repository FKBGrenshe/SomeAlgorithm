package Time2Hot100;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-02
 * @Description: 543 二叉树直径
 */
public class Solution_543_Hot100 {

    int maxlength = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        int i = doSearch(root);

        return maxlength;
    }

    public int doSearch(TreeNode curNode){
        if (curNode == null){
            return 0;
        }

        int leftMaxDepth = doSearch(curNode.left);
        int rightMaxDepth = doSearch(curNode.right);

        maxlength = Math.max(maxlength, leftMaxDepth+rightMaxDepth);

        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution_543_Hot100 solution543Hot100 = new Solution_543_Hot100();
        System.out.println(solution543Hot100.diameterOfBinaryTree(root));

    }




}
