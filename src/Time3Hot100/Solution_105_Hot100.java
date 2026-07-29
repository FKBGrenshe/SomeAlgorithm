package Time3Hot100;

import java.util.Arrays;

public class Solution_105_Hot100 {

    // 中 左 右
    // 左 中 右

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0){
            return null;
        }

        // step 1 -- 确认中
        TreeNode curRoot = new TreeNode(preorder[0]);

        int curRootInorderIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == curRoot.val){
                curRootInorderIdx = i;
                break;
            }
        }

        // step 2 -- 递归挂左右子树

        // left inorder
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, curRootInorderIdx);
        // right inorder
        int[] rightInorder = Arrays.copyOfRange(inorder, curRootInorderIdx+1, inorder.length);

        // preorder
        int leftLastNodePreorderIdx=-1;
        if (leftInorder.length != 0){
            leftLastNodePreorderIdx = leftInorder.length;
        }else{
            leftLastNodePreorderIdx = 0;
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftLastNodePreorderIdx+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftLastNodePreorderIdx+1, preorder.length);

        curRoot.left = buildTree(leftPreorder,leftInorder);
        curRoot.right = buildTree(rightPreorder,rightInorder);
        return curRoot;
    }


    public static void main(String[] args) {
        int[] preOrder = new int[] {
                1,2,3
        };
        int[] inOrder = new int[] {
                3,2,1
        };

        Solution_105_Hot100 solution105Hot100 = new Solution_105_Hot100();
        TreeNode treeNode = solution105Hot100.buildTree(preOrder, inOrder);
        treeNode.levelOrderPrint();
    }
}
