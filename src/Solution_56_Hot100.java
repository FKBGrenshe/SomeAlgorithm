import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_56_Hot100 {
    public int[][] merge(int[][] intervals) {

        // 对整个二维数组左端点进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.isEmpty()){
                list.add(interval);
            }else {
                int tempStart = interval[0];
                int tempEnd = interval[1];
                int[] result = list.get(list.size()-1);

                if (result[1] < tempStart){
                    list.add(interval);
                }else {
                    if (result[1] < tempEnd){
                        result[1] = tempEnd;
                    }
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Solution_56_Hot100 solution56Hot100 = new Solution_56_Hot100();
        // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        // 输出：[[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(solution56Hot100.merge(new int[][]{
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        })));

        // 输入：intervals = [[1,4],[5,6]]
        // 输出：[[1,4],[5,6]]
        System.out.println(Arrays.deepToString(solution56Hot100.merge(new int[][]{
                {1,4},
                {5,6}
        })));
    }
}
