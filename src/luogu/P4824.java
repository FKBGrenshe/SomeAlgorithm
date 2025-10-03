package luogu;

import java.io.*;
import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-27
 * @Description:
 *删除规则如下：反复找到当前 S 中第一个出现的子串 T 并删除，直到 S 中不再包含 T。注意，删除操作可能产生新的 T 子串。
 *
 * 请输出最终处理完成的字符串 S。
 *
 * 输入格式
 * 第一行输入字符串 S。
 * 第二行输入字符串 T。
 * 保证 T 的长度不超过 S，且 S 和 T 均由小写字母组成。删除过程中保证 S 不会变为空。
 */


public class P4824 {

    public static String S = "";
    public static String T = "";
    public static int[] next;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));

        S = bufferedReader.readLine();
        T = bufferedReader.readLine();
        next = new int[T.length()];

        calculateNext(T);

        while (findFirstAndDelete(S,T)){

        }


        printWriter.write(S);
        printWriter.flush();
        bufferedReader.close();
        printWriter.close();

        /*String s2 = "moo";
        next = new int[s2.length()];
        calculateNext(s2);
        System.out.println(Arrays.toString(next));*/

    }

    // 从s1中找到第一个s2并删除，如果没有则返回false
    public static boolean findFirstAndDelete(String s1, String s2){

        int p1 = 0, p2 = 0;

        while (p1 < s1.length() && p2 < s2.length()){
            if (s1.charAt(p1) == s2.charAt(p2)){
                p1++;
                p2++;
            }else if (next[p2] == -1){
                // 如果 s2的该位置next值=-1说明无重复子串，只能越过重新开始匹配
                p2 = 0;
                p1++;
            }else {
                p2 = next[p2];
            }
        }

        if (p1 >= s1.length() && p2 < s2.length()){
            // 说明父串全部过了一遍都没找到
            return false;
        }

        if (p2 >= s2.length()){
            String newS = "";
            // 说明子串完全匹配上了，找到当前第一个匹配子串
            // 删除当前子串所在的位置
            int startIdx = p1-s2.length();
            String head = "";
            String tail = "";
            if (startIdx != 0){
                head = s1.substring(0,startIdx);
                newS = head;
            }
            if (p1 < s1.length()){
                tail = s1.substring(p1);
                newS = newS.concat(tail);
            }
            if ("".equals(head) && "".equals(tail)){
                S = newS;
                return false;
            }
            S = newS;
            return true;
        }

        return false;
    }

    // 计算next数组
    public static void calculateNext(String s){
        next[0] = -1;
        if (s.length() == 1){
            return;
        }
        next[1] = 0;
        if (s.length() == 2){
            return;
        }
        for (int i = 2; i < s.length(); i++) {
            int tempIdx = next[i-1];
            while (true){
                if (tempIdx == -1){
                    next[i] = 0;
                    break;
                }else if(s.charAt(i-1) == s.charAt(tempIdx)){
                    next[i] = next[i-1]+1;
                    break;
                } else {
                    tempIdx = next[tempIdx];
                }
            }
        }
    }

}
