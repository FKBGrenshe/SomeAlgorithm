import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-19
 * @Description: 报数
 */
public class LCR135 {
    public int[] countNumbers(int cnt) {
        int numbers = (int)Math.pow(10, cnt);
        int[] ans = new int[numbers-1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i+1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LCR135 lcr135 = new LCR135();
        int[] ints = lcr135.countNumbers(3);
        System.out.println(Arrays.toString(ints));
    }
}
