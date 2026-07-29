package Time3Hot100;

public class Solution_226_Hot100 {

    public TreeNode invertTree(TreeNode root) {
        doInverse(root);
        return root;
    }

    private void doInverse(TreeNode root) {
        if (root == null){
            return;
        }

        doInverse(root.left);

        doInverse(root.right);

        /*do inverse*/
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


    public static void main(String[] args) {

        Solution_226_Hot100 solution226Hot100 = new Solution_226_Hot100();

        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root.levelOrderPrint();

        solution226Hot100.doInverse(root);


        System.out.println("--------------");
        root.levelOrderPrint();


    }
}
