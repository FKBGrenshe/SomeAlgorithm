package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_236_Hot100 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> plist = new ArrayList<>();
        List<TreeNode> qlist = new ArrayList<>();

//        plist.addLast(root);
//        qlist.addLast(root);

        findTreeNode(root,p, plist);
        findTreeNode(root,q,qlist);


        return findCommonAncestor(plist, qlist);
    }

    private TreeNode findCommonAncestor(List<TreeNode> plist, List<TreeNode> qlist) {
        TreeNode ancestor = plist.getFirst();

        int minLen = Integer.min(plist.size(),qlist.size());

        for (int i = 0; i < minLen; i++) {
            if (plist.get(i).val == qlist.get(i).val){
                ancestor = plist.get(i);
            }else {
                return ancestor;
            }
        }
        return ancestor;
    }

    private boolean findTreeNode(TreeNode curNode, TreeNode targeNode, List<TreeNode> targeList){
        if (curNode == null){
            return false;
        }

        targeList.addLast(curNode);

        if (curNode.val == targeNode.val){
            return true;
        }

        if (curNode.left != null){
            if(findTreeNode(curNode.left, targeNode, targeList)){
                return true;
            }
        }

        if (curNode.right != null){
            if(findTreeNode(curNode.right, targeNode, targeList)){
                return true;
            }
        }

        targeList.remove(curNode);
        return false;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(1);
//
//        root.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(2);
//
//        root.right.right = new TreeNode(8);

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        Solution_236_Hot100 solution236Hot100 = new Solution_236_Hot100();
        System.out.println(solution236Hot100.lowestCommonAncestor(root, root.right, root));
    }

}
