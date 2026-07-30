package Time3Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_46_Hot100 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] orgArr;

    public List<List<Integer>> permute(int[] nums) {
        orgArr = nums;
        doSearch(path);
        return ans;
    }

    private void doSearch(List<Integer> path) {
        if (path.size() == orgArr.length){
            ans.add(new ArrayList<>(path));
        }

        for (int i = 0; i < orgArr.length; i++) {
            if (!path.contains(orgArr[i])){
                path.add(orgArr[i]);
                doSearch(path);
                path.remove(Integer.valueOf(orgArr[i]));
            }
        }
    }


    public static void main(String[] args) {
        Solution_46_Hot100 solution46Hot100 = new Solution_46_Hot100();
        List<List<Integer>> permute = solution46Hot100.permute(
                new int[]{
//                        1, 2, 3

                        1
                }
        );

        for (List<Integer> integers : permute) {
            System.out.println(integers.toString());
        }
    }
}
