/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-23
 * @Description: 124二叉树最大路径和
 */
public class Solution_124_Hot100 {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        findMaxSum(root);
        return maxSum;

    }

    public int findMaxSum(TreeNode root) {
        if (root == null){
            return Integer.MIN_VALUE;
        }
        // 递归调用
        // 1. 首先计算左右子树的最大路径和
        int leftSum = findMaxSum(root.left);
        int rightSum = findMaxSum(root.right);
        // 判断当前节点的最大路径和
        /**
         * 解题思路：当前节点的最大路径和即：
         *  1. 当前节点值 + 左子树最大路径和 + 右子树最大路径和
         *  2. 当前节点值 + 左子树最大路径和
         *  3. 当前节点值 + 右子树最大路径和
         *  4. 当前节点值
         *  5. 左子树最大路径和
         *  6. 右子树最大路径和
         *
         *  当前节点值<0
         *      如果左子树值<0 && 右子树值<0 -- 返回当前节点值
         *      如果左子树值>0 && 右子树值<0 -- 返回当前节点值 + 左子树值
         *      如果左子树值<0 && 右子树值>0 -- 返回当前节点值 + 右子树值
         *  当前节点值>=0
         *      如果左子树值<0 && 右子树值<0 -- 返回当前节点值
         *      如果左子树值>0 && 右子树值<0 -- 返回当前节点值 + 左子树值
         *      如果左子树值<0 && 右子树值>0 -- 返回当前节点值 + 右子树值
         */

        int tempMaxValue = Integer.MIN_VALUE;
        if (root.val < 0){
            if(leftSum < 0){
                if (rightSum < 0){
                    if (maxSum < root.val){
                        maxSum = root.val;
                    }
                    return root.val;
                }else {
                    if (maxSum < rightSum){
                        maxSum = rightSum;
                    }
                    return root.val + rightSum;
                }
            }else {
                if (rightSum < 0){
                    if (maxSum < root.val){
                        maxSum = root.val;
                    }
                    return root.val + leftSum;
                }else {
                    if (maxSum < Math.max( leftSum + rightSum + root.val, Math.max(leftSum,rightSum))){
                        maxSum = Math.max( leftSum + rightSum + root.val, Math.max(leftSum,rightSum));
                    }
                    // 不能所有都向上传递，因为会出现分叉，导致不是一条线
                    return Math.max(root.val + leftSum, root.val + rightSum);
                }

            }
        }
        else {
            if (leftSum < 0){
                if (rightSum < 0){
                    if (maxSum < root.val){
                        maxSum = root.val;
                    }
                    return root.val;
                }else {
                    if (maxSum < rightSum + root.val){
                        maxSum = rightSum + root.val;
                    }
                    return root.val + rightSum;
                }
            }else {
                if (rightSum < 0){
                    if (maxSum < leftSum + root.val){
                        maxSum = leftSum + root.val;
                    }
                    return root.val + leftSum;
                }else {
                    if (maxSum < leftSum+rightSum + root.val){
                        maxSum = leftSum+rightSum + root.val;
                    }
                    // 不能所有都向上传递，因为会出现分叉，导致不是一条线
                    return Math.max(root.val + leftSum, root.val + rightSum);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution_124_Hot100 solution124Hot100 = new Solution_124_Hot100();
        // root = [1,2,3]
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
        // root = [-3]
//        TreeNode root = new TreeNode(-3);
        // root = [5,4,8,11,null,13,4,7,2,null,null,null,1]
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.right.right = new TreeNode(1);
        // root = [8,9,-6,null,null,5,9]
//        TreeNode root = new TreeNode(8);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(-6);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(9);
        // root = [-1,8,2,null,-9,0,null,null,null,-3,null,null,-9,null,2]
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(-9);
        root.right.left = new TreeNode(0);
        root.right.left.left = new TreeNode(-3);
        root.right.left.left.right = new TreeNode(-9);
        root.right.left.left.right.right = new TreeNode(2);


        System.out.println(solution124Hot100.maxPathSum(root));
    }

}
