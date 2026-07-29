package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_203_Hot100 {

    List<Integer> curlist = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        doSearchAndAdd(root,k);
        return curlist.getLast();
    }

    private void doSearchAndAdd(TreeNode curNode, int k) {
        if (curNode == null){
            return;
        }
        doSearchAndAdd(curNode.left, k);
        if (curlist.size() < k){
            curlist.addLast(curNode.val);
        }else {
            return;
        }
        doSearchAndAdd(curNode.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution_203_Hot100 solution203Hot100 = new Solution_203_Hot100();
        System.out.println(solution203Hot100.kthSmallest(root, 2));
    }
}
