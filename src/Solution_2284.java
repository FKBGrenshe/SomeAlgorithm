import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-30
 * @Description:
 */
public class Solution_2284 {
    public int countPairs(List<Integer> nums, int target) {

        Integer[] array = nums.toArray(new Integer[0]);
        Arrays.sort(array);

        int count = 0;

        int start = 0;
        int end = nums.size()-1;

        while (start < end){
            int sum = array[start] + array[end];
            if (sum < target){
                count += end-start;
                start++;
            }else {
                end--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution_2284 solution2284 = new Solution_2284();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        int target = 2;

        System.out.println(solution2284.countPairs(
                list,target
        ));
    }

}
