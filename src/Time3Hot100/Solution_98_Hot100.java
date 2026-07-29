package Time3Hot100;

public class Solution_98_Hot100 {

    int prevVal = Integer.MIN_VALUE;
    boolean prevInit = false;

    public boolean isValidBST(TreeNode root) {
        return doSearch(root);
    }

    private boolean doSearch(TreeNode curNode){
        if (curNode == null){
            return true;
        }

        boolean flag = true;

        flag = flag && doSearch(curNode.left);
        if (!flag){
            return flag;
        }
        flag = flag && doCompareCurNode(curNode.val);
        if (!flag){
            return flag;
        }
        flag = flag && doSearch(curNode.right);
        if (!flag){
            return flag;
        }
        return flag;
    }

    private boolean doCompareCurNode(int curVal) {
        if (!prevInit){
            prevVal = curVal;
            prevInit = true;
            return true;
        }
        if (prevVal >= curVal){
            return false;
        }
        prevVal = curVal;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(-3);
        root.right = new TreeNode(8);

//        root.right.left = new TreeNode(4);

        Solution_98_Hot100 solution98Hot100 = new Solution_98_Hot100();
        System.out.println(solution98Hot100.isValidBST(root));
    }

}
