package Time2Hot100;

import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-08
 * @Description: 前序、中序构建二叉树
 */
public class Solution_105_Hot100 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 && inorder.length == 0){
            return null;
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        if (preorder.length > 1 && inorder.length > 1){
            // 找到中序遍历-root节点索引位置
            int inorderRootIdx = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == rootVal){
                    inorderRootIdx = i;
                    break;
                }
            }

            int leftLength = inorderRootIdx;
            int rightLength = inorder.length-1-leftLength;


            // 中序遍历：左子树范围[0,leftLength-1]，右子树范围[rootIdx+1, inorder.length-1]
            int[] left_inorder = Arrays.copyOfRange(inorder, 0, leftLength);
            int[] right_inorder = Arrays.copyOfRange(inorder, inorderRootIdx+1, inorder.length);

            // 前序遍历：左子树范围[1,leftLength]，右子树范围[leftLength+1, inorder.length-1]
            int[] left_preorder = Arrays.copyOfRange(preorder,1,leftLength+1);
            int[] right_preorder = Arrays.copyOfRange(preorder, leftLength+1, preorder.length);

//            if (left_inorder.length == 0){
//                int[] right_preorder = Arrays.copyOfRange(preorder, inorderRootIdx+1, preorder.length);
//                root.right = buildTree(right_preorder,right_inorder);
//            }else {
//                int preorderLeftEndVal = inorder[inorderRootIdx-1];
//                int preorderLeftEndIdx = 1;
//                for (int i = 0; i < preorder.length; i++) {
//                    if (preorder[i] == preorderLeftEndVal){
//                        preorderLeftEndIdx = i;
//                    }
//                }
//                // 前序遍历：左子树范围[1, preorderLeftEndIdx]，右子树范围 [preorderLeftEndIdx+1, preorder.length-1]
//                int[] left_preorder = Arrays.copyOfRange(preorder,1,preorderLeftEndIdx+1);
//                int[] right_preorder = Arrays.copyOfRange(preorder, preorderLeftEndIdx+1, preorder.length);

                // 左子树
                root.left  = buildTree(left_preorder,left_inorder);
                // 右子树
                root.right = buildTree(right_preorder,right_inorder);
//            }
        }



        return root;
    }

    public static void main(String[] args) {
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9,3,15,20,7};

//        int[] preorder = {1,2};
//        int[] inorder = {1,2};
//        int[] inorder = {2,1};

        int[] preorder = {1,2,3};
        int[] inorder = {3,2,1};

        Solution_105_Hot100 solution105Hot100 = new Solution_105_Hot100();
        TreeNode treeNode = solution105Hot100.buildTree(preorder, inorder);
        System.out.printf("");
    }

    /*
    *      1
    *   2
    * 3
    * */

}
