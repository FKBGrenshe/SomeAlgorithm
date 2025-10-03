public class Solution_98_Hot100 {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        int[] vals = new int[10000];
        int size = 0;
        /**
         * 中序遍历 -- 数值递增
         */
        size = incr(root, vals, size);

        for (int i = 1; i < size; i++) {
            if (vals[i] <= vals[i-1]){
                return false;
            }
        }
        return true;
    }

    private int incr(TreeNode curNode,int[] list,int size){
        if (curNode == null){return size;}
        // 左
        if (curNode.left != null){
            size = incr(curNode.left, list, size);
        }
        // 中
        list[size++] = curNode.val;
        // 右
        if (curNode.right != null){
            size = incr(curNode.right, list ,size);
        }
        return size;

    }
}
