/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-06-02
 * @Description: 统计二叉树中好节点的数目
 */
public class Solution_1148 {

    private int cnt = 0;
    private int curmax = Integer.MIN_VALUE;

    public int goodNodes(TreeNode curNode) {

        if (curNode == null){
            return cnt;
        }
        // 记录当前节点之前的最大值
        int tmp = curmax;
        if (curNode.val >= curmax){
            cnt++;
            curmax = Math.max(curNode.val, curmax);
        }
        goodNodes(curNode.left);
        goodNodes(curNode.right);
        curmax = tmp;
        return cnt;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);

        Solution_1148 solution1148 = new Solution_1148();
        System.out.println(solution1148.goodNodes(root));

    }


}
