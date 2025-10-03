import java.util.*;
import java.util.function.ToIntFunction;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-09-27
 * @Description: 无重叠区间
 */
public class Solution_435 {

    // 活动选择问题 -- Activity selection problem
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[1]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int[] prev = intervals[0];


        for (int i = 1; i < intervals.length; i++) {

            int[] cur = intervals[i];

            if (cur[0] >= prev[1]){
                result.add(cur);
                prev = cur;
            }

            /*int oldEnd = result.get(result.size() - 1)[1];

            if (oldEnd <= intervals[i][0]){
                result.add(intervals[i]);
            } else if (oldEnd <= intervals[i][1]) {
                // 替换
                result.remove(result.size() - 1);
                result.add(intervals[i]);
            }*/
        }

//        System.out.println(Arrays.toString(result.toArray()));

        return intervals.length - result.size();
    }


    public static void main(String[] args) {
        Solution_435 solution435 = new Solution_435();
        int[][] intervals = {
                new int[]{1,2},
                new int[]{2,3},
                new int[]{3,4},
                new int[]{1,3}
        };
        System.out.println(solution435.eraseOverlapIntervals(intervals));
    }

}
