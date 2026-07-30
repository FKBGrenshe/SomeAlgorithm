package Time3Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_78_Hot100 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] globalNums;


    public List<List<Integer>> subsets(int[] nums) {
        globalNums = nums;
        doSearch(0);
        return ans;
    }

    private void doSearch(int curIdx) {
        ans.add(new ArrayList<>(path));

        for (int i = curIdx; i < globalNums.length; i++) {
            path.add(globalNums[i]);
            doSearch(i+1);
            path.remove(Integer.valueOf(globalNums[i]));
        }

    }
//List<List<Integer>> globalResult = new ArrayList<>();
//    List<Integer> curResult = new ArrayList<>();
//    int[] globalNums;
//
//    public List<List<Integer>> subsets(int[] nums) {
//        globalNums = nums;
//        backTracing(0);
//        return globalResult;
//    }
//
//    private void backTracing(int beginIdx) {
//        globalResult.add(new ArrayList<>(curResult));
//
//        for (int i = beginIdx; i < globalNums.length; i++) {
//            curResult.add(globalNums[i]);
//            backTracing(i+1);
//            curResult.remove(Integer.valueOf(globalNums[i]));
//        }
//    }


    public static void main(String[] args) {
        Solution_78_Hot100 solution78Hot100 = new Solution_78_Hot100();

        List<List<Integer>> permute = solution78Hot100.subsets(
                new int[]{
                        1, 2, 3

//                        1
                }
        );

        for (List<Integer> integers : permute) {
            System.out.println(integers.toString());
        }

    }

}
