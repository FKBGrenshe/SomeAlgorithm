//import com.sun.source.tree.Tree;
//
//import java.util.Arrays;
//
//public class Solution_106 {
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//
//        if (inorder.length == 0 && postorder.length == 0) {
//            return null;
//        }
//        if (inorder.length == 1 && postorder.length == 1) {
//            return new TreeNode(inorder[0]);
//        }
//        if (inorder.length == 2 && postorder.length == 2) {
//            if (inorder[0] == postorder[0] && inorder[1] == postorder[1]) {
//                TreeNode tempNode = new TreeNode(postorder[1]);
//                tempNode.right = null;
//                tempNode.left = new TreeNode(postorder[0]);
//                return tempNode;
//            } else {
//                TreeNode tempNode = new TreeNode(postorder[1]);
//                tempNode.left = null;
//                tempNode.right = new TreeNode(postorder[0]);
//                return tempNode;
//            }
//        }
//
//        // 找到 tempRootNode
//        int tempRootVal = postorder[postorder.length - 1];
//        TreeNode tempRootNode = new TreeNode(tempRootVal);
//
//        // 划分 左子树， 右子树区域
//        int inorderIdx = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == tempRootVal) {
//                // 0 - i-1 左子树 | i+1 - inorder.length-1 右子树
//                inorderIdx = i;
//                break;
//            }
//        }
//        int postorderIdx = 0;
//        for (int i = 0; i < postorder.length; i++) {
//            if (inorderIdx == inorder.length - 1) {
//                postorderIdx = postorder.length - 2;
//                break;
//            } else if (postorder[i] == inorder[inorderIdx + 1]) {
//                // 0, i 左子树 | i+1, postorder.length-2 右子树
//                postorderIdx = i-1;
//                break;
//            }
//        }
//        int[] inorderLeftTree = Arrays.copyOfRange(inorder, 0, inorderIdx);
//        int[] inorderRightTree = Arrays.copyOfRange(inorder, inorderIdx + 1, inorder.length);
//        int[] postorderLeftTree = Arrays.copyOfRange(postorder, 0, postorderIdx);
//        int[] postorderRightTree = Arrays.copyOfRange(postorder, postorderIdx, postorder.length - 1);
//        tempRootNode.left = buildTree(inorderLeftTree, postorderLeftTree);
//        tempRootNode.right = buildTree(inorderRightTree, postorderRightTree);
//
//        return tempRootNode;
//    }
//
//    public static void main(String[] args) {
//        int[] inorder = {9,3,15,20,7};
//        int[] postorder = {9,15,7,20,3};
////        int[] inorder = {1,2};
////        int[] postorder = {2,1};
////        int[] inorder = {2, 3, 1};
////        int[] postorder = {3, 2, 1};
////        int[] inorder = {1, 2, 3};
////        int[] postorder = {3, 2, 1};
//        Solution_106 solution106 = new Solution_106();
//        TreeNode treeNode = solution106.buildTree(inorder, postorder);
//        System.out.println(treeNode);
//    }
//
//}
