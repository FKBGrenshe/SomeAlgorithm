import java.util.ArrayList;
import java.util.List;

public class Solution_104_Hot100 {
    public int maxDepth(TreeNode root) {
        List<List<Integer>> answerList = new ArrayList<>();
        Que q = new Que();
        if (root == null) {return 0;}

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
        return answerList.size();
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    public int maxDepthver2(TreeNode root){
        if (root == null){
            return 0;
        }
        return getRootHeight(root);
    }

    private int getRootHeight(TreeNode curNode) {
        if (curNode == null){
            return 0;
        }
        // 后序遍历
        // left
        int leftHeight = getRootHeight(curNode.left);
        // right
        int rightHeight = getRootHeight(curNode.right);
        // mid
        return 1 + Math.max(leftHeight,rightHeight);
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    public int maxDeep = 0;
    public int curDeep = 0;

    public int maxDepthVer3(TreeNode root) {

        if (root == null){
            return maxDeep;
        }

        curDeep++;
        maxDeep = Math.max(curDeep, maxDeep);
        maxDepthVer3(root.left);
        maxDepthVer3(root.right);
        curDeep--;
        return maxDeep;
    }

}
