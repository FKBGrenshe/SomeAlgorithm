/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-29
 * @Description: 可获得的最大点数
 */
public class Solution_1423 {

    int maxVal = 0;

    public int maxScore(int[] cardPoints, int k) {

        int curVal = 0;
        for (int i = 0; i < k; i++) {
            curVal += cardPoints[i];
        }
        maxVal = curVal;

        for (int i = 0; i < k; i++) {
            int delLeftIdx = k-i-1;
            int incrRightIdx = cardPoints.length-1-i;
            curVal = curVal + cardPoints[incrRightIdx] - cardPoints[delLeftIdx];
            maxVal = Math.max(curVal,maxVal);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution_1423 solution1423 = new Solution_1423();

        int[] cardPoints = {
                1,79,80,1,1,1,200,1
        };
        int k = 3;

        System.out.println(solution1423.maxScore(
                cardPoints,k
        ));
    }
}
