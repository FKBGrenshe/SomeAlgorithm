import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，
 * 同一字母最多出现在一个片段中。
 *  例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 *
 *  示例 2：
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 *
 *  提示：
 * 1 <= s.length <= 500
 * s 仅由小写英文字母组成
 */
public class Solution_763_Hot100 {
    public List<Integer> partitionLabels(String s) {

        int[][] charIdx = new int[26][2];
        for (int i = 0; i < charIdx.length; i++) {
            Arrays.fill(charIdx[i],-1);
        }

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // 存储每个字母的区间范围
            if (charIdx[charArray[i] - 'a'][0] == -1 || charIdx[charArray[i] - 'a'][0] > i) {
                charIdx[charArray[i] - 'a'][0] = i;
            }
            if (charIdx[charArray[i] - 'a'][1] == -1 || charIdx[charArray[i] - 'a'][1] < i){
                charIdx[charArray[i] - 'a'][1] = i;
            }
        }

        // 将整个字母范围数组由小到达排序
        Arrays.sort(charIdx, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < charIdx.length; i++) {
            if (charIdx[i][0] == -1){
                continue;
            }
            if (list.isEmpty()){
                list.add(charIdx[i]);
                continue;
            }

            // 如果新区间的左边界 都要大于等于 旧区间的右边界，直接添加
            if (charIdx[i][0] >= list.get(list.size()-1)[1]){
                list.add(charIdx[i]);
            } // 新区间左边界和右边界有重合，即需要合并区间
            else if(charIdx[i][1] > list.get(list.size()-1)[1]){
                    list.set(list.size()-1,new int[]{list.get(list.size()-1)[0],charIdx[i][1]});
            }

        }

        List<Integer> ans = new ArrayList<>();

        for (int[] ints : list) {
            ans.add(ints[1] - ints[0] + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_763_Hot100 solution763 = new Solution_763_Hot100();
        String s = "ntswuqqbidunnixxpoxxuuupotaatwdainsotwvpxpsdvdbwvbtdiptwtxnnbtqbdvnbowqitudutpsxsbbsvtipibqpvpnivottsxvoqqaqdxiviidivndvdtbvadnxboiqivpusuxaaqnqaobutdbpiosuitdnopoboivopaapadvqwwnnwvxndpxbapixaspwxxxvppoptqxitsvaaawxwaxtbxuixsoxoqdtopqqivaitnpvutzchkygjjgjkcfzjzrkmyerhgkglcyffezmehjcllmlrjghhfkfylkgyhyjfmljkzglkklykrjgrmzjyeyzrrkymccefggczrjflykclfhrjjckjlmglrmgfzlkkhffkjrkyfhegyykrzgjzcgjhkzzmzyejycfrkkekmhzjgggrmchkeclljlyhjkchmhjlehhejjyccyegzrcrerfzczfelzrlfylzleefgefgmzzlggmejjjygehmrczmkrc";
        System.out.println(solution763.partitionLabels(s));
    }
}
