package Time2Hot100;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-02
 * @Description:
 */
public class Solution_104_Hot100 {

    int maxDeep = 0;
    int curDeep = 0;

    public int maxDepth(TreeNode root) {

        doDeepSearch(root);
        return maxDeep;

    }

    private void doDeepSearch(TreeNode curNode) {
        if (curNode == null){
            return;
        }

        curDeep++;
        maxDeep = maxDeep > curDeep ? maxDeep: curDeep;

        doDeepSearch(curNode.left);
        doDeepSearch(curNode.right);
        curDeep--;
    }

}
