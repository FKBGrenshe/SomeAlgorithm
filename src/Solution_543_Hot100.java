/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-23
 * @Description: 543二叉树直径
 */
public class Solution_543_Hot100 {

    int maxCount = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        depth(root);

        return maxCount;

    }

    // 找到当前节点的最大深度
    int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);

        maxCount = Math.max(l+r,maxCount);

        return Math.max(l,r)+1;

    }


    public static void main(String[] args) {

        Solution_543_Hot100 solution543Hot100 = new Solution_543_Hot100();

        //root = [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(solution543Hot100.diameterOfBinaryTree(root));


    }

}
