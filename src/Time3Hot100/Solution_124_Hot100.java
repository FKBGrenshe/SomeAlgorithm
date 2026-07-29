package Time3Hot100;

public class Solution_124_Hot100 {

    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        doFindMax(root);
        return maxVal;
    }

    private int doFindMax(TreeNode curNode){
        if (curNode == null){
            return 0;
        }

        int leftChildMax = doFindMax(curNode.left);
        int rightChildMax = doFindMax(curNode.right);

        int curMaxPathVal = Integer.max(curNode.val,Integer.max(leftChildMax+curNode.val, rightChildMax+curNode.val));

        int curMax = Integer.max(curMaxPathVal, leftChildMax+rightChildMax+curNode.val);

//        int curMax = curNode.val;
//
//        if (curNode.val < 0){
//
//            curMax = Integer.max(curMax, Integer.max(leftChildMax + curNode.val, rightChildMax+curNode.val)
//            );
//        }else{
//
//            curMax = Integer.max(curMax, Integer.max(curNode.val,
//                    Integer.max(leftChildMax + curNode.val,
//                            Integer.max(rightChildMax + curNode.val,
//                                    leftChildMax+rightChildMax + curNode.val)
//                    )));
//
//            curMax = Integer.max(curNode.val,Integer.max(leftChildMax+curNode.val, rightChildMax+curNode.val));
//
//        }
        maxVal = Integer.max(maxVal, curMax);
        return curMaxPathVal;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5,
                new TreeNode(4),
                new TreeNode(8));

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);


        root.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(2);


        Solution_124_Hot100 solution124Hot100 = new Solution_124_Hot100();
        System.out.println(solution124Hot100.maxPathSum(root));
    }

}
