package KMP;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-20
 * @Description: KMP算法详解
 */
public class kmpAlgorithm {

    /**
     * 找出Str1字符串中，匹配Str2的第一个下标位置
     * @param haystack -- str1
     * @param needle -- str2
     * @return 下标
     */
    public int strStr(String haystack, String needle) {

        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        // 计算str2的next数组
        int[] next = findNext(str2);

        // todo KMP全流程
        // str1、str2的下标指针
        int str1Pointer=0, str2Pointer=0;
        while (str1Pointer < str1.length && str2Pointer < str2.length){
            if (str1[str1Pointer] == str2[str2Pointer]){
                // 如果匹配，则两个指针往后移动
                str1Pointer++;
                str2Pointer++;
            }else {
                // 如果不匹配
                if (next[str2Pointer]==-1){
                    //特殊情况判断：str2Pointer如果跳到了str2的头，则没办法使用next，只能从str2[0]开始与str1Pointer进行匹配(往后一个一个挪)
                    str1Pointer++;
                }else {
                    // 将str2的第next[str2Pointer]的值，与str1[str1Pointer]进行比较
                    str2Pointer = next[str2Pointer];
                }
            }
        }

        if (str2Pointer >= str2.length){
            return str1Pointer-str2.length;
        }
        else {
            return -1;
        }

    }

    private int[] findNext(char[] str2) {
        // 对str进行next数组
        int[] next = new int[str2.length];
        int temp=0;
        while(temp < 2 && temp < next.length){
            /**
             next[0] = -1;
             next[1] = 0;
             */
            next[temp] = temp-1;
            temp++;
        }

        for (int i = 2; i < next.length; i++) {
            calNext(str2, next, i);
        }

        return next;
    }

    private void calNext(char[] str2, int[] next, int i) {
        // 比对的idx
        int curIdx = i-1;
        while (curIdx > 0){
            if ( str2[next[curIdx]] == str2[i-1] ){
                next[i] = next[curIdx] +1;
                return;
            }else {
                curIdx = next[curIdx];
            }
        }

        // curIdx 挪到头了，没有
        next[i] = 0;
    }


    public static void main(String[] args) {
        kmpAlgorithm kmpAlgorithm = new kmpAlgorithm();
//        System.out.println(kmpAlgorithm.strStr(
//                "sadbutsad",
//                "sad"
//        ));
//        System.out.println(kmpAlgorithm.strStr(
//                "leetcode",
//                "leeto"
//        ));
        System.out.println(kmpAlgorithm.strStr(
                "a",
                "a"
        ));

        //aabaabs
        // a   a  b  a  a  b  s
        // -1  0  0  0  1  2  3

        // l   e  e  t  o
        // -1  0  0  0  0
    }


}
