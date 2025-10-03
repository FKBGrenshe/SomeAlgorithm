import java.util.Arrays;

public class Solution_983 {

    public static int[] durations = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {

        return findMinDp(days,costs);
    }

    private int findMinDp(int[] days, int[] cost){
        int[] dpList = new int[366];
        Arrays.fill(dpList,0,days.length+1,Integer.MAX_VALUE-cost[2]-1);
        dpList[days.length] = 0;
        ///////////////////////////////////////////////
        for (int i = days.length-1 ; i >= 0; i--) {
            // 从后往前，确定每个数组倒数位置的最小花费
            for (int k = 0, j=i; k < 3; k++) {
                // 尝试每种不同方案的最小花费
                while ( j < days.length && days[i] + durations[k] > days[j]){
                    // 可以越过多少个day
                    j++;
                }
                dpList[i] = Math.min(dpList[i], cost[k] + dpList[j]);
            }
        }
        ///////////////////////////////////////////////
        return dpList[0];
    }


    private int findMin(int[] days, int[] costs, int i) {
        if (i >= days.length) {
            // 后续无旅行
            return 0;
        }
        //  需要找出的第i天及之后的最小花费
        int ans = Integer.MAX_VALUE;
        for (int k = 0, j = i; k < 3; k++) {
            // k是方案编号 : 0 1 2
            while (j < days.length && days[i] + durations[k] > days[j]) {
                // 因为方案2持续的天数最多，30天
                // 所以while循环最多执行30次
                // 枚举行为可以认为是O(1)
                j++;
            }
            ans = Math.min(ans, costs[k] + findMin(days, costs, j));
        }
        return ans;
    }
}
