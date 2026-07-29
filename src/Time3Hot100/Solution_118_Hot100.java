package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_118_Hot100 {

    List<Integer> curLevel, preLevel;
    List<Integer> level1 = new ArrayList<>();
    List<Integer> level2 = new ArrayList<>();

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return ans;
        }
        level1.addLast(1);
        level2.addLast(1);
        level2.addLast(1);

        ans.add(level1);
        if (numRows == 1){
            return ans;
        }
        ans.add(level2);
        if (numRows == 2){
            return ans;
        }

        preLevel = level2;
        for (int i = 3; i <= numRows; i++) {
            newLevel(i);
        }
        return ans;
    }

    private void newLevel(int size){
        curLevel = new ArrayList<>(size);
        curLevel.addFirst(1);
        for (int i = 1; i < size-1; i++) {
            curLevel.addLast(preLevel.get(i-1)+preLevel.get(i));
        }
        curLevel.addLast(1);
        ans.addLast(new ArrayList<>(curLevel));
        preLevel = curLevel;
    }


    public static void main(String[] args) {
        Solution_118_Hot100 solution118Hot100 = new Solution_118_Hot100();
        System.out.println(solution118Hot100.generate(5));
    }
}
