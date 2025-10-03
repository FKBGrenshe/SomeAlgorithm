public class Solution_111 {
    public int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return getRootMinHeight(root);
    }

    private int getRootMinHeight(TreeNode curNode) {
        if (curNode == null){
            return 0;
        }
        int leftHeight = getRootMinHeight(curNode.left);
        int rightHeight = getRootMinHeight(curNode.right);

        return leftHeight != 0 ? 1+Math.min(leftHeight, rightHeight != 0 ? rightHeight : leftHeight + 1) : rightHeight != 0 ? rightHeight + 1 : 1;
        /*if (leftHeight == 0 && rightHeight == 0){
            return 1;
        }else {
            return leftHeight != 0 ? 1 + Math.min(leftHeight, rightHeight != 0 ? rightHeight : leftHeight +1) : 1 + rightHeight;
        }*/


    }

    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    private int mindeep = Integer.MAX_VALUE;

    public int minDepthV2(TreeNode root) {
        find(root,1);
        return mindeep == Integer.MAX_VALUE ? 0 : mindeep;
    }


    private void find(TreeNode curNode, int curDeep){
        if (curNode == null){
            return;
        }

        if (curDeep < mindeep){

            if (curNode.left == null && curNode.right == null){
                mindeep = Math.min(mindeep, curDeep);
                return;
            }
            find(curNode.left, curDeep+1);
            find(curNode.right, curDeep+1);
        }
    }

    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Solution_111 solution111 = new Solution_111();

        // root = [3,9,20,null,null,15,7]
         TreeNode root = new TreeNode(3);
         root.left = new TreeNode(9);
         root.right = new TreeNode(20);
         root.right.left = new TreeNode(15);
         root.right.right = new TreeNode(7);

        System.out.println(solution111.minDepthV2(root));


    }


}
