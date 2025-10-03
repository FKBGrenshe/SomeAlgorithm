public class Solution_230_Hot100 {
    public int kthSmallest(TreeNode root, int k){
        // 前序遍历，放入队列，第k个就是
        Que que = new Que();
        findK(root,que,k);
        return que.getNIdxNode(que.begin+que.size-1).val;
    }

    private void findK(TreeNode curNode, Que que, int k){
        // 终止条件
        if (que.size == k){
            return;
        }
        // 中序遍历
        // 左
        if ( que.size != k && curNode.left != null){
            findK(curNode.left, que, k);
        }
        // 中
        if (que.size != k){
            que.push(curNode);
        }

        // 右
        if (que.size != k && curNode.right != null){
            findK(curNode.right, que, k);
        }
    }
}
