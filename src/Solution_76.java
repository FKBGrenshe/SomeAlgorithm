public class Solution_76 {
    public int minCostClimbingStairs(int[] cost) {

        int length = cost.length;

        int minCost = 0;
        //  递推公式：从后往前
        for (int i = length; i > 1; ) {
            if (cost[i - 1] < cost [i - 2]){
                minCost += cost[i-1];
//                if (i == length){
//                    // 如果是第一次跳，可以通过length-1的位置跳两个而不用花费钱
//                    minCost = 0;
//                }
                i -= 1;
            }else {
                minCost += cost[i-2];
                i -= 2;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        Solution_76 solution76 = new Solution_76();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost1 = {10,15,20};
        int[] cost2 = {0,2,2,1};
        System.out.println(solution76.minCostClimbingStairs(cost2));
    }
}
