package Time3Hot100;

public class TreeNode {

    int val;
    TreeNode left, right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode leftChild, TreeNode rightChild) {
        this.val = val;
        this.left = leftChild;
        this.right = rightChild;
    }
// leetcode 没有这两个代码
//    public void setLeftChild(TreeNode leftChild) {
//        this.leftChild = leftChild;
//    }
//
//    public void setRightChild(TreeNode rightChild){
//        this.rightChild = rightChild;
//    }

    // 层序遍历打印（从上到下、从左到右，按层输出）
    public void levelOrderPrint() {
        if (this == null) {
            return;
        }
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            StringBuilder levelSb = new StringBuilder();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSb.append(node.val).append(" ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println(levelSb.toString().trim());
        }
    }

}