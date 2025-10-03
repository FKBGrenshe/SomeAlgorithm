import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class Solution_118_Hot100 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> finalAnswer = new ArrayList<>();
        List<Integer> tempRow = new ArrayList<>();

        tempRow.add(1);
        finalAnswer.add(new ArrayList<>(tempRow));
        if (numRows == 1){
            return finalAnswer;
        }
        tempRow.add(1);
        finalAnswer.add(new ArrayList<>(tempRow));
        if (numRows == 2){
            return finalAnswer;
        }
        tempRow.clear();

        int[] arrold = new int[numRows];
        int[] arrnew = new int[numRows];
        Arrays.fill(arrold , -1);
        Arrays.fill(arrnew , -1);
        arrold[0] = 1;arrold[1] = 1;
        arrnew[0] = 1;arrnew[1] = 1;
        for (int i = 3; i <= numRows; i++) {
            for (int idx = 0; idx < i; idx++) {
                if (idx == 0 || idx == i-1){
                    arrnew[idx] = 1;
                    tempRow.add(1);
                }else {
                    arrnew[idx] = arrold[idx-1] + arrold[idx];
                    tempRow.add(arrnew[idx]);
                }
            }
            finalAnswer.add(new ArrayList<>(tempRow));
            tempRow.clear();
            arrold = arrnew.clone();
            Arrays.fill(arrnew , -1);
        }

        return finalAnswer;
    }

    public static void main(String[] args) {
        Solution_118_Hot100 solution118Hot100 = new Solution_118_Hot100();
        System.out.println(solution118Hot100.generate(5));
    }
}
