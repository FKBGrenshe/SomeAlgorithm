import java.util.*;
import java.util.stream.Stream;

public class Solution_76_Hot100 {
    public String minwindowVersion0(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }

        // 记录每个字母出现的次数
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> tempCharTimes = new HashMap<>(hashMap);

        int minStartIdx = -1, tempStartIdx = 0;
        int minEndIdx = -1, tempEndIdx = 0;
        int minLength = Integer.MAX_VALUE;

        while (tempEndIdx < s.length()){
            // 确保当前字串s[tempStartIdx,tempEndIdx]是覆盖子串
            while (findMaxValueGreaterThanZero(tempCharTimes) && tempEndIdx < s.length()){
                //说明tempEndIdx还得往后扩，还不是覆盖子串
                if (hashMap.containsKey(s.charAt(tempEndIdx))){
                    tempCharTimes.put(s.charAt(tempEndIdx), tempCharTimes.get(s.charAt(tempEndIdx))-1);
                }
                tempEndIdx++;
            }
            //当前子串已经是覆盖子串了，可以将startIdx右移，缩小子串了
            while (!findMaxValueGreaterThanZero(tempCharTimes)){
                if (hashMap.containsKey(s.charAt(tempStartIdx))){
                    tempCharTimes.put(s.charAt(tempStartIdx), tempCharTimes.get(s.charAt(tempStartIdx))+1);
                }
                tempStartIdx++;
            }
            // 当前子串可能是最小长度了，
            if (tempEndIdx-tempStartIdx+1 < minLength){
                minStartIdx = tempStartIdx;
                minEndIdx = tempEndIdx;
                minLength = tempEndIdx-tempStartIdx+1;
            }

            // 下一轮的初始化 -- 可以直接从endIdx开始
            tempStartIdx = tempEndIdx;
            tempCharTimes = new HashMap<>(hashMap);

        }

        return s.substring(minStartIdx, minEndIdx);

        /*for (tempStartIdx = 0; tempStartIdx < s.length(); tempStartIdx++) {
            if (t.contains(s.substring(tempStartIdx,tempStartIdx+1))){
                // 只有在开始小标已经包含了t中字母时，才进行下面的操作（才有可能是最小长度）
                tempEndIdx = tempStartIdx;
                while (findMaxValue(tempCharTimes) > 0){
                    //表示还没有找完
                    if (tempEndIdx >= s.length()){
                        //表示已经找完了s，但依然没有包含完整t字符串
                        //后续也无需遍历了，肯定依然不包含t
                        //直接return
                        if (minLength == Integer.MAX_VALUE){
                            return "";
                        }else {
                            return s.substring(minStartIdx, minEndIdx);
                        }
                    }
                    if (tempCharTimes.containsKey(s.charAt(tempEndIdx))){
                        tempCharTimes.put(s.charAt(tempEndIdx), tempCharTimes.get(s.charAt(tempEndIdx))-1);
                    }
                    tempEndIdx ++;
                }
                // 所有t中已经包含全找完了
                if (tempEndIdx-tempStartIdx+1 < minLength){
                    minStartIdx = tempStartIdx;
                    minEndIdx = tempEndIdx;
                    minLength = tempEndIdx-tempStartIdx+1;
                }
                // 下一轮的初始化
                tempCharTimes = new HashMap<>(hashMap);
            }
        }
        if (minLength == Integer.MAX_VALUE){
            return "";
        }else {
            return s.substring(minStartIdx, minEndIdx);
        }*/
    }
    boolean findMaxValueGreaterThanZero(HashMap<Character,Integer> map) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() > 0){
                return true;
            }
        }
        return false;
    }

    public int minLength = Integer.MAX_VALUE;
    public int minLengthEndIdx = -1;

    public String minWindowVersion1(String s, String t) {

        HashMap<Character, Integer> org = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (org.containsKey(c)){
                org.put(c,org.get(c)+1);
            }else {
                org.put(c,1);
            }
        }

        HashMap<Character,Integer> cur = new HashMap<>();

        //=======================第一次放入=========================//
        int start=0, end=0;
        while (end < s.length()){
            // 属于t的字符，放入map
            char curChar = s.charAt(end);
            if (org.containsKey(curChar)){
                if (cur.containsKey(curChar)){
                    cur.put(curChar,cur.get(curChar)+1);
                }else {
                    cur.put(curChar,1);
                }
                end++;
                // 将初始时，s的头的无效字符删去
                while (!org.containsKey(s.charAt(start))){
                    start++;
                }
                while (checkIng(cur, org, end, start)){
                    // 当前已经覆盖，则移动start
//                    Character startChar = s.charAt(start);
                    // 找到滑动窗口中第一个属于t的char，删且仅删掉t的一个char
                    while (!org.containsKey(s.charAt(start))){
                        start++;
                    }
                    cur.put(s.charAt(start), cur.get(s.charAt(start))-1);
                    start++;
                    // 将其余无效字符删除
                    while (start < s.length() && !org.containsKey(s.charAt(start))){
                        start++;
                    }
                }
            }else {
                end++;
            }


        }
        //=========================================================//
        if (minLengthEndIdx != -1){
            return s.substring(minLengthEndIdx-minLength, minLengthEndIdx);
        }else {
            return "";
        }

    }

    public boolean checkIng(HashMap<Character, Integer> cur, HashMap<Character, Integer> org, int end, int start) {
        // 检查当前是否已经覆盖t
        for (Character c : org.keySet()) {
            if (!cur.containsKey(c) || cur.get(c) < org.get(c)){
                return false;
            }
        }
        // 当前已经完全覆盖
        int curLength = end - start;
        if (curLength < minLength){
            minLength = curLength;
            minLengthEndIdx = end;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution_76_Hot100 solution76 = new Solution_76_Hot100();
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
        String s = "ab";
        String t = "b";
        System.out.println(":"+solution76.minWindowVersion1(s, t));
    }
}



class Solution {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}

        /*作者：力扣官方题解
        链接：https://leetcode.cn/problems/minimum-window-substring/solutions/257359/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/