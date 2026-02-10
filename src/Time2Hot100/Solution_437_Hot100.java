package Time2Hot100;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-09
 * @Description: 路径综合Ⅲ
 */
public class Solution_437_Hot100 {


    public int roadNumbers = 0;
    public long targetVal = 0;

    public int pathSum(TreeNode root, int targetSum) {
        targetVal = targetSum;
        dfs(root);
        return roadNumbers;
    }

    public void dfs(TreeNode curNode){
        if (curNode == null){
            return;
        }
        doSearch(curNode, targetVal);
        dfs(curNode.left);
        dfs(curNode.right);
    }

    public void doSearch(TreeNode curNode, long curVal){
        if(curNode == null){
            return;
        }
        if(curNode.val == curVal){
            roadNumbers++;
        }

        doSearch(curNode.left, curVal-curNode.val);
        doSearch(curNode.right, curVal-curNode.val);

//        doSearch(curNode.left, targetVal-curNode.val);
//        doSearch(curNode.right, targetVal-curNode.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        Solution_437_Hot100 solution437Hot100 = new Solution_437_Hot100();
        int num = solution437Hot100.pathSum(root, 8);
        System.out.printf(""+num);

    }

}
