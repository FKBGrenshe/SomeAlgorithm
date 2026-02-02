package Time2Hot100;

import java.util.*;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-02
 * @Description:
 */
public class Solution_101_Hot100 {

    boolean globalFlag = true;

    public boolean isSymmetric(TreeNode root) {

        doCheck(root);
        return globalFlag;
    }

    public void doCheck(TreeNode curNode){
        if (globalFlag == false || curNode == null){
            return;
        }



    }

    /*Deque<TreeNode> deque = new LinkedList<>();
    ArrayList<Integer> curLayerVals = new ArrayList<>();
    TreeNode nullNode = new TreeNode(-111);

    public boolean isSymmetric(TreeNode root) {
        push2Que(root);
        while (!deque.isEmpty()){
            int curLayerSize = deque.size();
            for (int i = 0; i < curLayerSize; i++) {
                TreeNode curNode = deque.removeFirst();
                curLayerVals.add(curNode.val);
                push2Que(curNode);
            }
            if (!chechCurLayer()){
                return false;
            }
            if (allNullCurLayer()){
                break;
            }
            curLayerVals.clear();
        }
        return true;
    }

    private boolean allNullCurLayer() {

        for (Integer curLayerVal : curLayerVals) {
            if (curLayerVal != -111){
                return false;
            }
        }
        return true;
    }

    public void push2Que(TreeNode curNode){
        if (curNode.left != null){
            deque.addLast(curNode.left);
        }else {
            deque.addLast(nullNode);
        }
        if (curNode.right != null){
            deque.addLast(curNode.right);
        }else {
            deque.addLast(nullNode);
        }
    }

    public boolean chechCurLayer(){

        int begin = 0;
        int end = curLayerVals.size()-1;
        while (begin <= end){
            if (curLayerVals.get(begin) != curLayerVals.get(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }*/


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        Solution_101_Hot100 solution101Hot100 = new Solution_101_Hot100();
        System.out.println(solution101Hot100.isSymmetric(root));
    }

}
