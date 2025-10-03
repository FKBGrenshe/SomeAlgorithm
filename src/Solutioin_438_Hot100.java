import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solutioin_438_Hot100 {
    public List<Integer> findAnagramsMethod1(String s, String p) {

        ArrayList<Integer> results = new ArrayList<>();

        int loopLength = s.length() - p.length() + 1;
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        for (int i = 0; i < loopLength; i++) {

            char[] subSArray = s.substring(i,i+p.length()).toCharArray();
            Arrays.sort(subSArray);
            boolean equals = Arrays.equals(subSArray, pArray);
            if (equals){
                results.add(i);
            }
        }
        return results;
    }


    public List<Integer> findAnagramsMethod2(String s, String p) {
        /*ArrayList<Integer> results = new ArrayList<>();
        char[] pArray = p.toCharArray();
        int leftIdx = 0;
        int rightIdx = p.length()-1;
        boolean previousFlag = false;

        while (rightIdx < s.length()){
            if (previousFlag){
                previousFlag = false;
                if (s.charAt(leftIdx-1) == s.charAt(rightIdx)){
                    previousFlag = true;
                }
                leftIdx ++; rightIdx ++;
            }else {
                int idx = 0;
                previousFlag = true;
                while ( previousFlag && idx<pArray.length ) {
                    previousFlag = (s.charAt(leftIdx+idx) == pArray[idx]) ? true : false;
                    idx++;
                }
                if (previousFlag){
                    results.add(leftIdx);
                }
            }


        }
        return results;*/
        return null;
    }

    public static void main(String[] args) {
        Solutioin_438_Hot100 solutioin438Hot100 = new Solutioin_438_Hot100();
        System.out.println(solutioin438Hot100.findAnagramsMethod2("cbaebabacd", "abc"));
        System.out.println(solutioin438Hot100.findAnagramsMethod2("abab", "ab"));
    }


}
