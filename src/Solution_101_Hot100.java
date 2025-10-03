import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution_101_Hot100 {
//    public boolean isSymmetric(TreeNode root){
//        if (root == null){
//            return true;
//        }
//        // 层序遍历 -- 每一层是否是回文数列，如果不是直接return错误
//        int size = 0;
//        Que que = new Que();
//        que.push(root);
//        while (que.size != 0){
//            size = que.size;
//            // 判断：当前层节点（que[0,size]）是否是回文数列
//            if (!abcba(que,size)) {
//                // 当前列不是回文数列
//                return false;
//            }
//            // 当前层节点全部退出，将下一层节点全部放入
//            while (size-- != 0){
//                // push左右子节点
//                TreeNode curNode = que.pop();
//                if (curNode.val == -101){
//                    continue;
//                }
//
//                if (curNode.left != null || curNode.right != null){
//                    // left
//                    if (curNode.left != null){
//                        que.push(curNode.left);
//                    }else {
//                        que.push(new TreeNode(-101));
//                    }
//
//                    // right
//                    if (curNode.right != null){
//                        que.push(curNode.right);
//                    }else {
//                        que.push(new TreeNode(-101));
//                    }
//                }else {
//                    que.push(new TreeNode(-101));
//                    que.push(new TreeNode(-101));
//                }
//            }
//        }
//        // 所有层次都判断完了，--都是回文数列 -- 整体是对称的
//        return true;
//    }
//    private boolean abcba(Que que, int size) {
//        // 判断 que[0,size)是否是回文数列
//        if (size == 1){
//            return true;
//        }
//        if (size % 2 == 1){
//            // 除了1之外，当前层节点数量为奇数 -- 必然不对称
//            return false;
//        }
//        for (int i = 0; i < size / 2; i++) {
//            if (que.getNIdxNode(que.begin + i).val != que.getNIdxNode(que.end - 1 - i).val){
//                return false;
//            }
//        }
//        return true;
//    }

    private boolean flag = true;

    public boolean isSymmetric(TreeNode root) {
        if (root == null ||  (root.left == null && root.right == null)){
            return flag;
        }
        if (root.left == null || root.right == null){
            return false;
        }
        return isMirror(root.left, root.right);

    }

    public boolean isMirror(TreeNode node1, TreeNode node2){

        if (node1 == null && node2 == null || !flag){
            return flag;
        }

        if (node1 == null || node2 == null){
            flag = false;
            return flag;
        }

        if (node1.val != node2.val){
            flag = false;
            return flag;
        }

        flag =  isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        return flag;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        Solution_101_Hot100 solution101Hot100 = new Solution_101_Hot100();
        System.out.println(solution101Hot100.isSymmetric(root));

    }



}
