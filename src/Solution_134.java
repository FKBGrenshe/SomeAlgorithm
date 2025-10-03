/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-23
 * @Description: 加油站
 */
public class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] res = new int[cost.length];
        boolean[] canArrive = new boolean[cost.length];

        int totalRes = 0;
        int maxRes = Integer.MIN_VALUE;
        int maxResIdx = -1;

        for (int i = 0; i < res.length; i++) {
            res[i] = gas[i] - cost[i];
            totalRes += res[i];
            if (res[i] > maxRes){
                maxResIdx = i;
                maxRes = res[i];
            }
        }
        if (totalRes < 0){
            return -1;
        }

        // 从最大剩余油量位置往前第一个有累积油量的位置开始
        int startIdx = maxResIdx;
        while (true){
            if (startIdx == 0){
                if (res[res.length-1] >= 0){
                    startIdx = res.length-1;
                }else {
                    break;
                }
            }

            if (res[(startIdx-1)%res.length] < 0){
                break;
            }
            startIdx = (startIdx-1)%res.length;
            if (startIdx == maxResIdx){
                // 全是正数，转了一圈回来了
                return maxResIdx;
            }
        }

        int curOil = 0;
        int curIdx = startIdx;
        for (int count = 0; count < res.length; count++) {
            curOil += res[curIdx];
            if (curOil < 0 ){
                // 表明：当前油量累积段不足以支撑到[curIdx]位置，从[curIdx+1]位置，重新开始
                startIdx = (curIdx+1)%res.length;
                // 重新初始化
                curOil = 0;
                curIdx = startIdx;
                count = 0;

            }else {
                curIdx = (curIdx+1)%res.length;
            }
        }

        /*int curOil = res[startIdx];
        for (int i = (startIdx+1)%res.length; i != startIdx;  i = (i+1)%res.length) {
            curOil += res[i];
            if (curOil < 0 ){
                // 表明：当前油量累积段不足以支撑到[i]位置，从[i+1]位置，重新开始
                startIdx = i;
                curOil = 0;
            }
        }*/

        return startIdx;
    }

    public static void main(String[] args) {
        Solution_134 solution134 = new Solution_134();
        System.out.println(solution134.canCompleteCircuit(
                new int[]{3,1,1},
                new int[]{1,2,2}
        ));
    }
}
