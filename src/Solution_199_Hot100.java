import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_199_Hot100 {
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> rightSideNodeList = new ArrayList<>();
//        if (root == null){
//            return rightSideNodeList;
//        }
//        Que queue = new Que();
//        queue.push(root);
//
//        while (queue.size != 0){
//            int size = queue.size;
//            while (size-- != 0){
//                TreeNode curNode = queue.pop();
//                if (size == 0){
//                    // 队列最后一个节点 -- 最右侧节点
//                    TreeNode theMostRightNode = curNode;
//                    rightSideNodeList.add(theMostRightNode.val);
//                }
//                if (curNode.left != null){
//                    queue.push(curNode.left);
//                }
//                if (curNode.right != null){
//                    queue.push(curNode.right);
//                }
//            }
//        }
//        return rightSideNodeList;
//    }

    private List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> deque = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null){
            return ans;
        }

        deque.add(root);
        while (!deque.isEmpty()){
            ans.add(
                    deque.peekLast().val
            );
            int i = deque.size();
            for (; i > 0; i--) {
                TreeNode curNode = deque.pollFirst();
                if (curNode.left != null)
                    deque.add(curNode.left);
                if (curNode.right != null)
                    deque.add(curNode.right);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(9);



        Solution_199_Hot100 solution199Hot100 = new Solution_199_Hot100();
        List<Integer> list = solution199Hot100.rightSideView(root);
        System.out.println(list);
    }


}
