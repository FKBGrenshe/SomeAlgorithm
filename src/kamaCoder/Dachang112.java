package kamaCoder;

import java.util.Scanner;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-08-31
 * @Description: Oppo挑战boss
 */
public class Dachang112 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 回合数量
        int huiheshuliang = scanner.nextInt();
        // 基础攻击力
        int jichugongjili = scanner.nextInt();
        // 基础连击伤害
        int jichulianjishanghai = scanner.nextInt();
        // 闪避结果
        char[] shanbijieguo = scanner.next().toCharArray();

        int totalDamage = 0;
        int lianji = 0;

        for (char c : shanbijieguo) {

            totalDamage += jichugongjili + lianji*jichulianjishanghai;

            // 判定当前回合闪避是否成功
            if (c == 'x'){
                lianji = 0;
            }else {
                lianji++;
            }
        }
        System.out.println(totalDamage);
    }
}
