package DynamicProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-07
 * @Description: 杨辉三角
 */
public class Solution_118_Hot100 {

    List<List<Integer>> globalResult = new ArrayList<>();
    List<Integer> lastResult;
    List<Integer> curResult;

    int curLayer = 0;

    public List<List<Integer>> generate(int numRows) {
        curResult = new ArrayList<>();
        curResult.add(1);
        globalResult.add(new ArrayList<>(curResult));
        if (numRows == 1) return globalResult;
        curResult.add(1);
        globalResult.add(new ArrayList<>(curResult));
        if (numRows == 2) return globalResult;

        ///
        curLayer = 3;
        for (; curLayer <= numRows; curLayer++) {
            createAndFillCurLayer(curLayer);
        }

        return globalResult;
    }

    private void createAndFillCurLayer(int curLayer) {

        lastResult = curResult;
        curResult = new ArrayList<>();
        // 开头
        curResult.add(1);
        // 中间
        for (int idx = 1; idx < curLayer-1; idx++) {
            curResult.add(lastResult.get(idx-1) + lastResult.get(idx));
        }
        // 末尾
        curResult.add(1);

        // 插入globalResult
        globalResult.add(new ArrayList<>(curResult));
    }

    public static void main(String[] args) {
        Solution_118_Hot100 solution118Hot100 = new Solution_118_Hot100();
        List<List<Integer>> generate = solution118Hot100.generate(2);

        generate.forEach(x -> System.out.println(x.toString()));

    }

}
