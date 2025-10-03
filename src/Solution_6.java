import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-23
 * @Description: Z字形排列
 */
public class Solution_6 {

    List<List<Character>> org = new ArrayList<>();

    public String convert(String s, int numRows) {

        for (int i = 0; i < numRows; i++) {
            org.add(new ArrayList<>());
        }

        int curHang = 0;
        // true -> curHang++ ; false curHang--
        boolean direction = true;

        char[] sCharArray = s.toCharArray();

        for (int i = 0; i < sCharArray.length; i++) {
            org.get(curHang).add(sCharArray[i]);

            curHang = direction ? (curHang+1)%numRows : (curHang-1)%numRows;
            if (curHang == 0){
                direction = true;
            }
            if (curHang == numRows-1){
                direction = false;
            }

        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < org.size(); i++) {
            org.get(i).forEach(c -> stringBuilder.append(c));
        }
        String string = stringBuilder.toString();
        return string;

    }

    public static void main(String[] args) {
        Solution_6 solution6 = new Solution_6();
        System.out.println(solution6.convert(
                "PAYPALISHIRING"
//                "P"
                ,
                4
        ));
    }

}
