/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-29
 * @Description:
 */
public class Solution_1052 {

    int maxIncr = 0;
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int orgSum = 0;

        for (int i = 0; i < customers.length; i++) {
            customers[i] = grumpy[i] == 0 ? customers[i] : -1*customers[i];
            orgSum += Math.max(customers[i], 0);
        }

        int curIncr = 0;

        for (int i = 0; i < minutes; i++) {
            curIncr -= Math.min(customers[i], 0);
        }
        maxIncr = curIncr;

        for (int i = minutes; i < customers.length; i++) {
            curIncr -= Math.min(customers[i], 0) - Math.min(customers[i-minutes], 0);
            maxIncr = Math.max(curIncr,maxIncr);
        }

        return orgSum+maxIncr;

    }

    public static void main(String[] args) {
        Solution_1052 solution1052 = new Solution_1052();

        int[] customers = {
                1,0,1,2,1,1,7,5
        };
        int[] grumpy = {
                0,1,0,1,0,1,0,1
        };
        int minutes = 3;

        System.out.println(solution1052.maxSatisfied(
                customers, grumpy, minutes
        ));
    }
}
