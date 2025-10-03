//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: Bingyu Chen
// * @CreateTime: 2025-06-05
// * @Description: 节点与其祖先之间的最大差值
// */
//public class Solutioin_1026 {
//
//    private int max = 0;
//    private List<Integer> minVal = new ArrayList<>();
//    private List<Integer> maxVal = new ArrayList<>();
//    int cnt = 0;
//    public int maxAncestorDiff(TreeNode root) {
//
//        if (root == null)
//            return 0;
//        minVal.add(root.val);
//        maxVal.add(root.val);
//        cnt++;
//
//    }
//
//    private void dfs(TreeNode curNode){
//        if (curNode == null){
//            return;
//        }
//        // 左右中，遍历
//        minVal.add( minVal.isEmpty() ? curNode.val : Math.min(curNode.val, minVal.get(minVal.size()-1)) );
//        maxVal.add( maxVal.isEmpty() ? curNode.val : Math.max(curNode.val, minVal.get(minVal.size()-1)) );
//        max = Math.max(maxVal.get(maxVal.size()-1)-minVal.get(minVal.size()-1),max);
//
//
//
//    }
//
//
//}
