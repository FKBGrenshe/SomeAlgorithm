import java.util.*;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-06-02
 * @Description: 二叉树的垂序遍历
 */
public class Solution_987 {

    List<List<Integer>> ans = new ArrayList<>();

    HashMap<Integer, List<int[]>> tmpAns = new HashMap<>();

    Deque<TreeNode> nodeDeque = new LinkedList<>();
    Deque<Integer> rowDeque = new LinkedList<>();
    Deque<Integer> colDeque = new LinkedList<>();


//    public List<List<Integer>> verticalTraversalByDfs(TreeNode root) {
//
//        dfs(root, 0, 0);
//
//        int mincolIdx = Integer.MAX_VALUE;
//        for (Integer colidx : tmpAns.keySet()) {
//            mincolIdx = Math.min(colidx,mincolIdx);
//        }
//
//        while (tmpAns.containsKey(mincolIdx)){
//            ans.add(tmpAns.get(mincolIdx));
//            mincolIdx++;
//        }
//
//        return ans;
//    }
//    public void dfs(TreeNode curNode, int row, int col) {
//        if (curNode == null) {
//            return;
//        }
//
//        if (curNode.val == 7 || curNode.val == 2){
//            System.out.println();
//        }
//
//        List<Integer> list = tmpAns.get(col);
//        if (list == null) {
//            list = new ArrayList<>();
//            list.add(curNode.val);
//            tmpAns.put(col, list);
//        } else {
//            if (list.size() >= row) {
//                Integer brotherVal = list.get(row - 1);
//                if (brotherVal > curNode.val) {
//                    list.remove(row - 1);
//                    list.add(curNode.val);
//                    list.add(brotherVal);
//                } else {
//                    list.add(curNode.val);
//                }
//            } else {
//                list.add(curNode.val);
//            }
//        }
//        dfs(curNode.left, row + 1, col - 1);
//        dfs(curNode.right, row + 1, col + 1);
//    }

    public List<List<Integer>> verticalTraversalByBfs(TreeNode root) {
        nodeDeque.push(root);
        rowDeque.push(0);
        colDeque.push(0);

        while (!nodeDeque.isEmpty()){
            // 取出当前节点
            TreeNode curNode = nodeDeque.pollFirst();
            Integer curRow = rowDeque.pollFirst();
            Integer curCol = colDeque.pollFirst();

            if (curNode.val == 7 || curNode.val == 6){
                System.out.println();
            }
            // 放入当前左右孩子
            if (curNode.left!=null){
                nodeDeque.add(curNode.left);
                rowDeque.add(curRow+1);
                colDeque.add(curCol-1);
            }
            if (curNode.right!= null){
                nodeDeque.add(curNode.right);
                rowDeque.add(curRow+1);
                colDeque.add(curCol+1);
            }
            // 对当前子节点进行操作
            List<int[]> list = tmpAns.get(curCol);
            if (list == null) {
                list = new ArrayList<>();
                list.add(new int[]{curRow,curNode.val});
                tmpAns.put(curCol, list);
            } else {
                list.add(new int[]{curRow,curNode.val});
            }
        }

        int mincolIdx = Integer.MAX_VALUE;
        for (Integer colidx : tmpAns.keySet()) {
            mincolIdx = Math.min(colidx,mincolIdx);
        }

        while (tmpAns.containsKey(mincolIdx)){

            List<int[]> tmp = tmpAns.get(mincolIdx);
            tmp.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
                }
            });

            ArrayList<Integer> curCol = new ArrayList<>(tmp.size());
            for (int[] ints : tmp) {
                curCol.add(ints[1]);
            }

            ans.add(curCol);
            mincolIdx++;
        }

        return ans;
    }


    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(17);*/


        /*TreeNode root = new TreeNode(0);
        root.left = new TreeNode(8);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(2);
        root.right.left.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.left.right.right = new TreeNode(7);
        root.right.right.left.left = new TreeNode(6);*/

        TreeNode root = buildTreeFromLevelOrder(new Integer[]{0, 2, 1, 3, null, null, null, 4, 5, null, 7, 6, null, 10, 8, 11, 9});

        Solution_987 solution987 = new Solution_987();
        List<List<Integer>> lists = solution987.verticalTraversalByBfs(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }


    // 构建函数：层序遍历数组 => 二叉树
    public static TreeNode buildTreeFromLevelOrder(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (current == null) continue;

            // 左子节点
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // 右子节点
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
