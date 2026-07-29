package Time3Hot100;

public class Solution_104_Hot100 {

    int maxDepth = 0;
    int curDepth = 0;

    public int maxDepth(TreeNode root) {
        doDeep(root);
        return maxDepth;
    }

    private void doDeep(TreeNode curNode) {
        if (curNode == null){
            return;
        }
        curDepth++;
        doDeep(curNode.left);
        doCompare();
        curDepth--;

        curDepth++;
        doDeep(curNode.right);
        doCompare();
        curDepth--;
    }

    private void doCompare() {
        maxDepth = Integer.max(maxDepth,curDepth);
    }


    public static void main(String[] args) {
        Solution_104_Hot100 solution104Hot100 = new Solution_104_Hot100();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solution104Hot100.maxDepth(root));
    }

}
