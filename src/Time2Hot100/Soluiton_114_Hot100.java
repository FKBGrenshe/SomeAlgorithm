package Time2Hot100;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-08
 * @Description: 二叉树展开为链表
 */
public class Soluiton_114_Hot100 {

    public void flatten(TreeNode curNode) {
        if (curNode == null){
            return;
        }

        // 中 - 左 - 右 : 把左子树拼接到中和右子树的中间

        TreeNode curNodeLeftChild = curNode.left;
        TreeNode curNodeRightChild = curNode.right;

        if (curNodeLeftChild != null){
            flatten(curNodeLeftChild);
        }

        if (curNodeLeftChild!=null){
            curNode.right = curNodeLeftChild;
            findLowest(curNodeLeftChild).right = curNodeRightChild;
            curNode.left = null;
        }

        if (curNodeRightChild != null){
            flatten(curNodeRightChild);
        }
    }

    private TreeNode findLowest(TreeNode curNode) {
        if (curNode.right != null){
            return findLowest(curNode.right);
        }
        return curNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Soluiton_114_Hot100 soluiton114Hot100 = new Soluiton_114_Hot100();
        soluiton114Hot100.flatten(root);

        System.out.println("");

    }

}
