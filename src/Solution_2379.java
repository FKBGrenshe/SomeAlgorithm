/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-29
 * @Description: 得到 K 个黑块的最少涂色次数
 */
public class Solution_2379 {

    public static int times = 0;

    public int minimumRecolors(String blocks, int k) {

        char[] charArray = blocks.toCharArray();
        int curTimes = 0;
        for (int i = 0; i < k; i++) {
            if (charArray[i] == 'W'){
                curTimes++;
            }
        }
        times = curTimes;

        for (int i = k; i < charArray.length; i++) {
            curTimes += charArray[i] == 'W' ? 1 : 0;
            curTimes -= charArray[i-k] == 'W' ? 1 : 0;
            if (curTimes < times){
                times = curTimes;
            }
        }


        return times;
    }

    public static void main(String[] args) {
        Solution_2379 solution2379 = new Solution_2379();
        System.out.println(solution2379.minimumRecolors(
                "WBBWWBBWBWBBBBBBB",
                7
        ));
    }

}
