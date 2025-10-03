///**
// * @Author: Bingyu Chen
// * @CreateTime: 2025-06-05
// * @Description: 翻转等价二叉树
// */
//public class Solution_951 {
//
//    private boolean flag = false;
//
//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        if (!flag || (root1==null&&root2==null)){
//            return flag;
//        }
//
//        if (root1.val != root2.val){
//            flag = false;
//            return flag;
//        }
//
//
//
//
//    }
//
//    private boolean isSameNodeStructure(TreeNode node1, TreeNode node2){
//        if (node1 == null || node2== null){
//            return !(node1 != null || node2 != null);
//        }
//        return node1.val == node2.val;
//    }
//
//}
