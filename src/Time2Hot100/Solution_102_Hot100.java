package Time2Hot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-02
 * @Description: 层序遍历
 */
public class Solution_102_Hot100 {

    List<List<Integer>> finalRes = new ArrayList<>();

    Deque<TreeNode> deque = new LinkedList<>();


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return finalRes;
        }
        deque.add(root);
        while (!deque.isEmpty()){

            int curLayerSize = deque.size();
            List<Integer> curLayerVal = new ArrayList<>(curLayerSize);

            for (int i = 0; i < curLayerSize; i++) {
                TreeNode curNode = deque.removeFirst();
                curLayerVal.add(curNode.val);
                if (curNode.left != null){
                    deque.addLast(curNode.left);
                }
                if (curNode.right != null){
                    deque.addLast(curNode.right);
                }
            }
            finalRes.add(curLayerVal);
        }
        return finalRes;
    }
}
