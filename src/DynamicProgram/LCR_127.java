package DynamicProgram;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-11
 * @Description: 跳跃训练
 */
public class LCR_127 {

    long mode = 1000000007;

    long[] nums = new long[110];
    public int trainWays(int num) {

        // nums[i] = num[i-1]+num[i-2]
        nums[0] = 1;
        nums[1] = 1;
        // 1, 1, 2, 3, 5, 8...

        for (int i = 2; i <= num; i++) {
            nums[i] = (nums[i-1] + nums[i-2])%mode;
        }

        return (int) (nums[num]%mode);
    }

    public static void main(String[] args) {
        LCR_127 lcr127 = new LCR_127();
        System.out.println(lcr127.trainWays(92));

//        int val = 10%1000000007;

//        System.out.println(val);

    }
}
