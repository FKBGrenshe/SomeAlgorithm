/*
package luogu;


import java.io.*;
import java.util.*;

public class P484Comparator {

    // 随机生成一个长度为 len 的字符串，字符范围为小写字母
    public static String generateRandomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append((char) ('a' + Math.random() * 26));  // 生成一个随机小写字母
        }
        return sb.toString();
    }

    // 随机生成一个测试用例
    public static String generateTestCase() {
        // 随机生成 S 和 T 的长度
        int lenS = 10 + (int) (Math.random() * 50);  // 生成 10 到 50 之间的长度
        int lenT = 1 + (int) (Math.random() * Math.min(lenS, 10));  // T 的长度小于等于 S

        // 生成 S 和 T
        String S = generateRandomString(lenS);
        String T = generateRandomString(lenT);




        return S + "\n" + T + "\n";  // 返回 S 和 T 作为测试用例
    }

    public static void main(String[] args) throws IOException {

        P4824Answer p4824Answer = new P4824Answer();
        P4824 p4824 = new P4824();
        P4824.S = "";

        // 测试用例数量
        int testCaseCount = 1000;

        // 输出到文件
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < testCaseCount; i++) {
            String testCase = generateTestCase();


            writer.write(testCase + "\n");
        }

        writer.flush();
        writer.close();
    }
}
*/
