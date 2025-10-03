import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历 && 递归
 */

/*public class Solution_144 {

    *//**
     *  前序： 中节点 - 左节点 - 右节点
     * @param root 当前遍历时的根节点
     * @return List
     *//*
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> treeNodeList = new ArrayList<>();
        preOrder(root,treeNodeList);
        return treeNodeList;
    }

    public void preOrder(TreeNode curNode, List list){
        // 确定终止条件：当前节点为空时，表示遍历到底
        if (curNode == null){
            return;
        }
        // 递归逻辑：mid -> left -> right
        // mid
        list.add(curNode.val);
        //left
        preOrder(curNode.left,list);
        // right
        preOrder(curNode.right,list);
    }


}*/


public class Solution_144 {
    /**
     *  前序： 中节点 - 左节点 - 右节点
     * @param root 当前遍历时的根节点
     * @return List
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> treeNodeList = new ArrayList<>();
        preOrderFunc(root,treeNodeList);
        return treeNodeList;
    }

    public void preOrderFunc(TreeNode curNode, List list){
        if (curNode == null){
            return;
        }
        // mid - left - right
        list.add(curNode.val);
        preOrderFunc(curNode.left,list);
        preOrderFunc(curNode.right,list);

    }

}


