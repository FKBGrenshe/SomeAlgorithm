import java.util.Arrays;

public class Solution_105_Hot100 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0){
            // 数组为空，
            return null;
        }

        // todo 前序 找 root
        TreeNode root = new TreeNode(preorder[0]);
        System.out.println("前序遍历数组中：找到root节点：" + preorder[0]);
        if (preorder.length == 1){
            // 叶子节点 -- 直接返回
            return root;
        }
        // todo 中序 切 中序-左子树，中序-右子树
        int index=-1;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]){
                index = i;
                System.out.println("中序遍历数组中：找到root节点：mid[" + index + "]" + "=:" + inorder[index]);
                // 找到root节点 : index
                break;
            }
        }
        if (index == -1){
            System.out.println("中序遍历没找到root节点");
            throw new RuntimeException();
        }
        // [0,i) -- 中序-左子树
        int[] MID_leftSunTree = Arrays.copyOfRange(inorder,0,index);
        System.out.print("中序左子树：");Arrays.stream(MID_leftSunTree).forEach(System.out::print);System.out.println();
        // [i+1,-1) -- 中序-右子树
        int[] MID_rightSunTree = Arrays.copyOfRange(inorder,index+1,inorder.length);
        System.out.println("中序右子树：");Arrays.stream(MID_rightSunTree).forEach(System.out::print);System.out.println();
        // todo 前序 切 前序-左子树， 前序-右子树
        int[] PRE_leftSunTree = Arrays.copyOfRange(preorder,1,MID_leftSunTree.length + 1);
        System.out.println("前序左子树：");Arrays.stream(PRE_leftSunTree).forEach(System.out::print);System.out.println();
        int[] PRE_rightSunTree = Arrays.copyOfRange(preorder,MID_leftSunTree.length + 1,preorder.length);
        System.out.println("前序右子树：");Arrays.stream(PRE_rightSunTree).forEach(System.out::print);System.out.println();
        // todo 迭代
        // left
        root.left = buildTree(PRE_leftSunTree,MID_leftSunTree);
        // right
        root.right = buildTree(PRE_rightSunTree,MID_rightSunTree);




        return root;
    }

    public static void main(String[] args) {
        /*int[] org = new int[]{1,2,3};
        int[] left = Arrays.copyOfRange(org,0,2);
        int[] right = Arrays.copyOfRange(org,2,3);
        Arrays.stream(left).forEach(System.out::print);
        Arrays.stream(right).forEach(System.out::print);*/

    }
}
