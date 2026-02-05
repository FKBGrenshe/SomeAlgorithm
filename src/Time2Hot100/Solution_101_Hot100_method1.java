package Time2Hot100;

import java.util.*;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-02
 * @Description:
 */
public class Solution_101_Hot100_method1 {

    /**
     * 1. 层序遍历 -> 将每层Node插入DEQUE
     * 2. 每层判断是否是对称数组
     */

    Deque<TreeNode> layerNodes = new ArrayDeque<>();
    ArrayList<Integer> layerVals = new ArrayList<>();
    TreeNode nullNode = new TreeNode(-111, null, null);


    public boolean isSymmetric(TreeNode root) {

        layerNodes.addLast(root);
        return doLayerInsert();
    }

    private boolean doLayerInsert() {
        if (layerNodes.isEmpty()){
            return true;
        }

        layerVals.clear();
        // this layer
        int thisLayerSize = layerNodes.size();
        for (int i = 0; i < thisLayerSize; i++) {
            TreeNode curNode = layerNodes.removeFirst();

            if (!Objects.equals(curNode, nullNode)){
                layerNodes.addLast(Objects.isNull(curNode.left) ? nullNode: curNode.left);
                layerNodes.addLast(Objects.isNull(curNode.right) ? nullNode: curNode.right);
            }
            layerVals.add(curNode.val);
        }

        if (!checkThisLayerVals()){
            return false;
        }

        return doLayerInsert();

    }

    public boolean checkThisLayerVals(){
//        if (layerVals.size() == 1){
//            return true;
//        }
        int leftIdx = 0, rightIdx = layerVals.size()-1;
        while (leftIdx <= rightIdx){
            if (layerVals.get(leftIdx++) != layerVals.get(rightIdx--)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
        Solution_101_Hot100_method1 solution101Hot100 = new Solution_101_Hot100_method1();
        System.out.println(solution101Hot100.isSymmetric(root));
    }

}
