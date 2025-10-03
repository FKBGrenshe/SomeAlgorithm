/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-06-05
 * @Description: 计算布尔二叉树的值
 */
public class Solution_2331 {

//    private boolean result;

    public boolean evaluateTree(TreeNode root) {
        return dfs(root) == 1;
    }

    private int dfs(TreeNode curNode){

        if (curNode.val >= 2){
            // curNode是运算符 -- 非叶子节点
            boolean left = dfs(curNode.left) == 1;
            boolean right = dfs(curNode.right) == 1;
            if (curNode.val == 2){
                // left || right
                return left || right ? 1 : 0;
            }else {
                // left && right
                return left && right ? 1 : 0;
            }
        }else {
            // curNode是参与运算的数 -- 叶子节点
            return curNode.val;
        }

    }

    public static void main (String... args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(0);
        root.left.left = new TreeNode(0);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);

        Solution_2331 solution2331 = new Solution_2331();
        System.out.println(solution2331.evaluateTree(root));

    }

}
