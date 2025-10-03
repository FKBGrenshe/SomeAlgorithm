/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-05-22
 * @Description: 求根节点到叶节点数字之和
 */
public class Solution_129 {

    public int total = 0;

    public int sumNumbers(TreeNode root) {
        visit(root,"");
        return total;
    }

    public String visit(TreeNode root, String vals){

        if (root == null){
            return "-1";
        }

        vals = vals + String.valueOf(root.val);
        String lefts = visit(root.left, vals);
        String rights = visit(root.right, vals);

        if ("-1".equals(lefts) && "-1".equals(rights)){
            // 当前节点是叶节点
            Integer value = Integer.valueOf(vals);
            total += value;
        }

        return "1";

    }

    public static void main(String[] args) {

    }


}
