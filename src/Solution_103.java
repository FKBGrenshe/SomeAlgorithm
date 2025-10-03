import java.util.*;
import java.util.function.Consumer;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-08-07
 * @Description: 二叉树的z字形层序遍历
 */
public class Solution_103 {

    Deque<TreeNode> treeNodeDeque = new LinkedList<>();
    List<List<Integer>> answer = new ArrayList<>();

//    Deque<Integer> answerPerFloor = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){

        if (root == null){
            return answer;
        }

        treeNodeDeque.offerFirst(root);
        int floor = 0;

        while (!treeNodeDeque.isEmpty()){
            LinkedList<Integer> answerPerFloor = new LinkedList<>();

            if (floor %2 == 0){

                int size = treeNodeDeque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = treeNodeDeque.pollFirst();
                    answerPerFloor.offerLast(treeNode.val);
                    if (treeNode.left != null)
                        treeNodeDeque.offerLast(treeNode.left);
                    if (treeNode.right != null)
                        treeNodeDeque.offerLast(treeNode.right);
                }

                answer.add(answerPerFloor);

            }else {
                int size = treeNodeDeque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = treeNodeDeque.pollFirst();
                    answerPerFloor.offerFirst(treeNode.val);
                    if (treeNode.left != null)
                        treeNodeDeque.offerLast(treeNode.left);
                    if (treeNode.right != null)
                        treeNodeDeque.offerLast(treeNode.right);
                }
                answer.add(answerPerFloor);

            }
//            answerPerFloor.clear();
            floor++;
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution_103 solution103 = new Solution_103();

        // building tree
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);*/

        // [0,2,4,1,null,3,-1,5,1,null,6,null,8]
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.right.left.right  = new TreeNode(6);
        root.right.right.right = new TreeNode(8);




        List<List<Integer>> lists = solution103.zigzagLevelOrder(root);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }


}



//Definition for a binary tree node.
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

