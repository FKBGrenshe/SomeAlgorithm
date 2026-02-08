package Time2Hot100;

import java.util.*;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-08
 * @Description: 二叉树的右视图
 */
public class Solution_199_Hot100 {

    // 层序遍历，然后抛出最右侧的值即可

    Deque<TreeNode> layerNodes = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return result;
        }
        layerNodes.addFirst(root);
        doInsertRightVal();
        return result;
    }

    private void doInsertRightVal() {

        if (layerNodes.isEmpty()){
            return;
        }

        result.add(layerNodes.peekLast().val);

        int times = layerNodes.size();
        TreeNode curNode = null;
        for (int i = 0; i < times; i++) {
            curNode = layerNodes.removeFirst();
            if (curNode.left != null)
                layerNodes.addLast(curNode.left);
            if (curNode.right != null)
                layerNodes.addLast(curNode.right);
        }
        doInsertRightVal();

    }

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.left.left = new TreeNode(5);

//        TreeNode root = null;

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution_199_Hot100 solution199Hot100 = new Solution_199_Hot100();
        List<Integer> list = solution199Hot100.rightSideView(root);

        System.out.println(list.toString());

    }

}
