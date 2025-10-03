package kamaCoder;

import java.util.Scanner;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-08-31
 * @Description: 小欧的平均数
 *
 * 后面才搞懂原来是要把所有的数全部变成奇数，或者全部变成偶数所需要的最小的步数。结果就是0和1 没有别的。逆天题……
 */
public class Dachang114 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long x = scanner.nextInt();
        long y = scanner.nextInt();
        long z = scanner.nextInt();

        int ji = 0;
        int ou = 0;

        if (x%2 == 0){
            ji++;
        }else{
            ou++;
        }
        if (y%2 == 0){
            ji++;
        }else{
            ou++;
        }
        if (z%2 == 0){
            ji++;
        }else{
            ou++;
        }

        System.out.println(Math.min(ji,ou));



    }

}
