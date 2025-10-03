import java.util.ArrayList;
import java.util.List;

public class Solution_102_Hot100 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> answerList = new ArrayList<>();
        Que q = new Que();
        if (root == null) {return answerList;}

        q.push(root);
        while (q.size > 0){
            // 每一层的遍历
            int size = q.size;
            List<Integer> nodes = new ArrayList<>();
            while (size != 0){
                TreeNode curNode = q.pop();
                nodes.add(curNode.val);
                if (curNode.left != null){
                    q.push(curNode.left);
                }
                if (curNode.right != null){
                    q.push(curNode.right);
                }
                size--;
            }
            answerList.add(nodes);
        }
        return answerList;
    }
}

/*class que{
    int size = 0;
    TreeNode[] arr = new TreeNode[2000];
    int begin = 0, end = 0;

    public TreeNode pop(){
        if (isEmpty()){
            return null;
        }
        // 从对头弹出
        size--;
        return arr[begin++];

    }

    public boolean push(TreeNode treeNode){
        if (isFull()){
            return false;
        }
        arr[end++] = treeNode;
        size++;
        return true;
    }

    public boolean isFull(){
        return size == 2000;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */