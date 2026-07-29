package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_49_Hot100 {



    List<List<Integer>> charCount = new ArrayList<>();
    List<List<String>> ans = new ArrayList();
    List<Integer> zimuyiweiciCandidates = new ArrayList<>();

    public List<List<String>> groupAnagrams(String[] strs) {

        for(int curwordidx = 0; curwordidx < strs.length; curwordidx++){
            zimuyiweiciCandidates.clear();
            String curstring = strs[curwordidx];


            for (int charidx = 0; charidx < curstring.length(); charidx++) {
                char curchar = curstring.charAt(charidx);

                if (charidx == 0){
                    List<Integer> cadidates = charCount.get(getidx(curchar));
                    if (cadidates.isEmpty()) continue;
                    zimuyiweiciCandidates.addAll(cadidates);
                }else{
                    List<Integer> cadidates = charCount.get(getidx(curchar));
                    for (int i = 0; i < zimuyiweiciCandidates.size(); i++) {
                        if (!cadidates.contains(zimuyiweiciCandidates.get(i))){
                            zimuyiweiciCandidates.remove(zimuyiweiciCandidates.get(i));
                        }
                    }
                }
                doinsert(curchar, curwordidx);
            }

            if (zimuyiweiciCandidates.isEmpty()){
                // insert new
                ArrayList<String> curans = new ArrayList<>();
                curans.add(curstring);
                ans.add(curans);
            }else {
                // already have one
                for (int i = 0; i < ans.size(); i++) {
                    if (ans.get(i).contains(strs[zimuyiweiciCandidates.getFirst()])){
                        ans.get(i).add(curstring);
                        break;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 将每个字母插入到这个Cound的末尾
     * @param curchar
     * @param curwordidx
     */
    private void doinsert(char curchar, int curwordidx) {
        charCount.get(getidx(curchar)).add(curwordidx);
    }

    private int getidx(char input){
        return input - 'a';
    }


    public static void main(String[] args) {

    }
}