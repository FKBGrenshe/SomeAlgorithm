package Time3Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution_17_Hot100 {

    HashMap<Integer, List<Character>> phone = new HashMap<>();
    List<Character> list2 = new ArrayList<>(List.of('a', 'b', 'c'));
    List<Character> list3 = new ArrayList<>(List.of('d', 'e', 'f'));
    List<Character> list4 = new ArrayList<>(List.of('g', 'h', 'i'));
    List<Character> list5 = new ArrayList<>(List.of('j', 'k', 'l'));
    List<Character> list6 = new ArrayList<>(List.of('m', 'n', 'o'));
    List<Character> list7 = new ArrayList<>(List.of('p', 'q', 'r', 's'));
    List<Character> list8 = new ArrayList<>(List.of('t', 'u', 'v'));
    List<Character> list9 = new ArrayList<>(List.of('w', 'x', 'y', 'z'));
    List<String> globalans = new ArrayList<>();
    StringBuilder curlevel = new StringBuilder();



    public void backTracing(String digits){
        if (curlevel.length() == digits.length()){
            globalans.add(curlevel.toString());
            return;
        }

        int curidx = curlevel.length();
        Integer curNumber = Integer.valueOf(digits.charAt(curidx)-'0');
        List<Character> characters = phone.get(curNumber);
        for (Character character : characters) {
            curlevel.append(character);
            backTracing(digits);
            curlevel.deleteCharAt(curlevel.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        
        
        phone.put(2, list2);
        phone.put(3, list3);
        phone.put(4, list4);
        phone.put(5, list5);
        phone.put(6, list6);
        phone.put(7, list7);
        phone.put(8, list8);
        phone.put(9, list9);

        backTracing(digits);
        return globalans;
    }

    public static void main(String[] args) {
        Solution_17_Hot100 solution17Hot100 = new Solution_17_Hot100();
        List<String> strings = solution17Hot100.letterCombinations("23");
        System.out.println(strings);
    }

}
