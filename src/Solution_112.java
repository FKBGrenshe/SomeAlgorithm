public class Solution_112 {

    boolean hasFlag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        int tempSum = 0;
        preorderFunc(root,targetSum,tempSum);
        return hasFlag;
    }

    public void preorderFunc(TreeNode curNode, int targetSum, int tempSum){
        if (curNode == null || hasFlag){
//            tempSum -= curNode.val;
            return;
        }

        // mid - left -right
        tempSum += curNode.val;
        /*if (tempSum > targetSum){
            tempSum -= curNode.val;
            return;
        }*/
        if (tempSum == targetSum && curNode.left == null && curNode.right == null){
            hasFlag = true;
            return;
        }
        preorderFunc(curNode.left,targetSum,tempSum);
        preorderFunc(curNode.right,targetSum,tempSum);
        tempSum -= curNode.val;
    }


    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    private boolean result = false;
    private int curVal = 0;
    private int targetSum = 0;

    public boolean hasPathSumV2(TreeNode root, int targetSum) {

        this.targetSum = targetSum;
        dfs(root);
        return result;
    }

    public void dfs(TreeNode curNode){

        if (result || curNode == null){
            return;
        }

        if (curNode.left == null && curNode.right == null){
            result = curVal+curNode.val == targetSum;
        }else {
            curVal += curNode.val;
            dfs(curNode.left);
            dfs(curNode.right);
            curVal -= curNode.val;
        }

    }


    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        Solution_112 solution112Hot100 = new Solution_112();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        /*TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);*/
        System.out.println(solution112Hot100.hasPathSumV2(root, 22));
    }
}
