package ACM;

import java.util.Scanner;

// https://www.nowcoder.com/discuss/591715786872434688

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-13
 * @Description: ACM模式下的输入输出
 */
public class InputAndOutput {

    /**
     *  全都是数字输入，每行数字个数不确定
     */
    public static void PureNumberInput_UncertaintyNums(){
        // 输入例子：
        // 1 2 3
        // 4 5
        // 0 0 0 0 0

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            int sum = 0;
            for (String s : arr) {
                int x = Integer.parseInt(s);
                sum += x;
            }
        }
    }

    /**
     * 每行第一个数字为确定的数字N，后面跟着N个数字
     */
    public static void PureNumberInput_WithXNums(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int nums = scanner.nextInt();
            for (int i = 0; i < nums; i++) {
                int x = scanner.nextInt();
                System.out.printf("x",x);
            }
        }
    }






}
