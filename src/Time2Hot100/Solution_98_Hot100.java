package Time2Hot100;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-07
 * @Description: 验证二叉搜索树
 */
public class Solution_98_Hot100 {

    public boolean flag = true;

    public boolean isValidBST(TreeNode root) {

        doSearch(root);
        return flag;
    }

    private void doSearch(TreeNode curNode) {
        if (!flag){
            return;
        }

        if (curNode.left!=null){
            doSearch(curNode.left);
            int leftMax = findMax(curNode.left);
            flag = flag&&compare2NodeVal(leftMax,curNode.val);
        }
        if (curNode.right!=null){
            doSearch(curNode.right);
            int rightMin = findMin(curNode.right);
            flag = flag&&compare2NodeVal(curNode.val,rightMin);
        }

    }

    public boolean compare2NodeVal(int left, int right){
        return left < right;
    }

    public int findMax(TreeNode curNode){
        if (curNode.right==null){
            return curNode.val;
        }
        return findMax(curNode.right);
    }

    public int findMin(TreeNode curNode){
        if (curNode.left == null){
            return curNode.val;
        }
        return findMin(curNode.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);

//
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(6);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(32);
//        root.left = new TreeNode(26);
//        root.right = new TreeNode(47);
//        root.left.left = new TreeNode(19);
//        root.left.left.right = new TreeNode(27);
//        root.right.right = new TreeNode(56);

        Solution_98_Hot100 solution98Hot100 = new Solution_98_Hot100();
        System.out.println(solution98Hot100.isValidBST(root));

    }

}
