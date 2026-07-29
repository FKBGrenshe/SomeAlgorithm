package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_102_Hot100 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curLevel = new ArrayList<>();
    List<TreeNode> curLevelNode = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        curLevelNode.add(root);
        doInsert();
        return ans;
    }

    private void doInsert() {
        curLevel.clear();
        if (curLevelNode.isEmpty()){
            return;
        }

        int curLength = curLevelNode.size();
        for (int i = 0; i < curLength; i++) {
            TreeNode curRemoveNode = curLevelNode.removeFirst();
            curLevel.add(curRemoveNode.val);
            if (curRemoveNode.left != null){
                curLevelNode.addLast(curRemoveNode.left);
            }
            if (curRemoveNode.right != null){
                curLevelNode.addLast(curRemoveNode.right);
            }
        }
        ans.add(new ArrayList<>(curLevel));
        doInsert();
    }


    public static void main(String[] args) {
        // 3
        // 9 20
        //   15 7

        TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Solution_102_Hot100 solution102Hot100 = new Solution_102_Hot100();
        root.levelOrderPrint();
        solution102Hot100.levelOrder(root);


    }
/*
* java.lang.NullPointerException: Cannot read field "val" because the return value of "java.util.List.removeFirst()" is null
  at line 35, Solution.doInsert
  at line 23, Solution.levelOrder
  at line 56, __DriverSolution__.__helper__
  at line 86, __Driver__.main
*
* */
}
