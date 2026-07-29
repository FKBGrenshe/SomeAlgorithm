package Time3Hot100;

public class Solution_437_Hot100 {

    int count = 0;
    long targetSum = 0;

    public int pathSum(TreeNode root, long targetSum) {
        this.targetSum = targetSum;
        doSearch(root);
        return count;
    }

    private void doSearch(TreeNode curNode) {
        if (curNode == null){
            return;
        }

        doSearch(curNode.left);
        countIncloudCurNode(curNode, 0);
        doSearch(curNode.right);
    }

    private void countIncloudCurNode(TreeNode curNode, long res){
        if (curNode == null){
            return;
        }
        res += curNode.val;
        if (res == targetSum){
            count++;
        }

        countIncloudCurNode(curNode.left, res);
        countIncloudCurNode(curNode.right, res);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(1);

        Solution_437_Hot100 solution437Hot100 = new Solution_437_Hot100();
        System.out.println(solution437Hot100.pathSum(root, 8));
    }

}
