import java.util.*;

public class Solution_49_Hot100 {
    public List<List<String>> groupAnagrams(String[] strs) {

        /*List<List<String>> results = new ArrayList<>();*/

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!map.containsKey(key)){
                List<String> newlist = new ArrayList<>();
                newlist.add(str);
                map.put(key,newlist);
            }else {
                map.get(key).add(str);
            }
        }

        return map.values().stream().toList();

    }


    public static void main(String[] args) {
        Solution_49_Hot100 solution49_hot100 = new Solution_49_Hot100();

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(solution49_hot100.groupAnagrams(strs));

    }

}
