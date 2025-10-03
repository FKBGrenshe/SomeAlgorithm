import java.util.ArrayList;
import java.util.List;

public class Solution_113 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        int tempSum = 0;
        List<Integer> path = new ArrayList<>();
        preorderFunc(root,path,targetSum,tempSum);

        return ans;
    }

    public void preorderFunc(TreeNode curNode, List<Integer> path, int targetsum, int tempSum){

        if (curNode == null){
            return;
        }

        // mid - left - right
        path.add(curNode.val);
        tempSum += curNode.val;
        /*if (tempSum > targetsum){
            path.remove(path.size() - 1);
            tempSum -= curNode.val;
            return;
        }*/
        if (tempSum == targetsum && curNode.left == null && curNode.right == null){
            // 该路径成功
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            tempSum -= curNode.val;
            return;
        }
        preorderFunc(curNode.left,path,targetsum,tempSum);
        preorderFunc(curNode.right,path,targetsum,tempSum);
        path.remove(path.size() - 1);
        tempSum -= curNode.val;
    }

    public static void main(String[] args) {
        Solution_113 solution113 = new Solution_113();
        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(solution113.pathSum(root,22));*/
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        System.out.println(solution113.pathSum(root,-5));
    }

}
