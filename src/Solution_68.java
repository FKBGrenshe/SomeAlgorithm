/*
import java.util.ArrayList;
import java.util.List;

*/
/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-23
 * @Description: 文本左右对齐
 *//*

public class Solution_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int[] sizeArray = new int[words.length];
        for (int i = 0; i < sizeArray.length; i++) {
            sizeArray[i] = words[i].length()+1;
        }

        int startIdx = 0;
        int endIdx = 0;
        int curLength = 0;
        // 空格数
        int nullLength = 0;
        while (endIdx < sizeArray.length){

            // 找到最大塞进的单词
            while (curLength < maxWidth){
                curLength += sizeArray[endIdx];
                endIdx++;
            }
            // 单词数 = endIdx - startIdx
            int numbers = endIdx - startIdx;
            // 总空格数
            nullLength = maxWidth - curLength;
            // 每个空格数量
            int perNull = nullLength 




        }

    }
}
*/
