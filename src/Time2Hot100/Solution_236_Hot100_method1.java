package Time2Hot100;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-10
 * @Description: 二叉树的最近工共祖先
 */
public class Solution_236_Hot100_method1 {

    ArrayList<TreeNode> p_road = new ArrayList<>();
    ArrayList<TreeNode> q_road = new ArrayList<>();
    boolean p_flag = false;
    boolean q_flag = false;
    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = root;
        doSearchBuildRoad(root,p,p_road);
        doSearchBuildRoad(root,q,q_road);
        return findAncestor();
    }

    private TreeNode findAncestor() {
        int min = Math.min(p_road.size(), q_road.size());
        for (int i = 0; i < min; i++) {
            if (!Objects.equals(p_road.get(i),q_road.get(i))){
                return result;
            }
            result = p_road.get(i);
        }
        return result;
    }

    private boolean doSearchBuildRoad(TreeNode curNode, TreeNode targetNode, ArrayList<TreeNode> target_road) {
        if (curNode == null){
            return false;
        }

        if (Objects.equals(curNode,targetNode)){
            target_road.add(curNode);
            return true;

        }

        target_road.add(curNode);
        boolean findFlag = doSearchBuildRoad(curNode.left,targetNode,target_road) || doSearchBuildRoad(curNode.right,targetNode,target_road);
        if (!findFlag)
            target_road.remove(curNode);
        return findFlag;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left;
//        TreeNode q = root.right;
        TreeNode q = p.right.right;

        Solution_236_Hot100_method1 solution236Hot100 = new Solution_236_Hot100_method1();
        System.out.println(solution236Hot100.lowestCommonAncestor(root, p, q).val);


    }
}
