import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.BitSet;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-28
 * @Description: 半径为k的子数组平均值
 */
public class Solution_2090 {

    public int[] getAverages(int[] nums, int k) {

        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        int subLen = 2*k + 1;
        long subSum = Long.MIN_VALUE;
        int numIdx = k;
        for (int i = subLen-1; i < nums.length; i++) {
            if (subSum == Long.MIN_VALUE){
                subSum = 0;
                for (int j = 0; j <= i; j++) {
                    subSum += (long)nums[j];
                }
            }else {
                subSum = subSum + nums[i] - nums[i-subLen];
            }
            ans[numIdx++] = (int)(subSum/subLen);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Solution_2090 solution2090 = new Solution_2090();
        int[] averages = solution2090.getAverages(
                new int[]{
                        7, 4, 3, 9, 1, 8, 5, 2, 6
                },
                3
        );

        System.out.println(Arrays.toString(averages));

        int[] test = new int[100000];
        Arrays.fill(test,100000);

        int[] averages1 = solution2090.getAverages(
                test,
                40000
        );
        System.out.println(Arrays.toString(averages1));


        File file = new File("D:\\学习\\实习\\Leetcode\\java_coding\\leetcoding\\src\\s.txt");
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = bufferedReader.readLine();

        String[] strings = string.split(",");
        System.out.println(strings.length);

    }

}
