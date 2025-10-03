/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-06-03
 * @Description: 相同的树
 */
public class Solution_100 {

    private boolean same = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!same){
            return same;
        }

        if (p == null || q == null){
            return p == q;
        }

        if (p.val != q.val){
            same = false;
            return false;
        }

        same = isSameTree(p.left,q.left) && isSameTree(p.right, q.right);

        return same;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);

        Solution_100 solution100 = new Solution_100();
        System.out.println(solution100.isSameTree(root, root2));

    }

}
