/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-06-05
 * @Description: 合并二叉树
 */
public class Solution_617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            root2 = root1;
            return root2;
        }
        root2.val += root1.val;
        root2.left = mergeTrees(root1.left, root2.left);
        root2.right = mergeTrees(root1.right,root2.right);
        return root2;
    }


    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);


        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);


        Solution_617 solution617 = new Solution_617();
        TreeNode mergeTrees = solution617.mergeTrees(root1, root2);
        System.out.println(mergeTrees);


    }


}
