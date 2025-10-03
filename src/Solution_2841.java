import java.util.*;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-29
 * @Description:
 */
public class Solution_2841 {

    long sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public long maxSum(List<Integer> nums, int m, int k) {

        long curSum = 0;
        int start = 0;
        int end = 0;

        for (end = 0; end < k; end++) {

            int curKey = nums.get(end);
            curSum += curKey;

            if (!map.containsKey(curKey)){
                map.put(curKey,1);
            }else {
                map.put(curKey,map.get(curKey)+1);
            }
        }

        if (map.size() >= m){
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sum += (long) entry.getKey() *entry.getValue();
            }
        }

        for ( end = k; end < nums.size(); end++,start++) {

            boolean lastLoop = map.keySet().size() >= m;


            int delKey = nums.get(start);
            int delTimes = map.get(delKey);
            if (delTimes == 1){
                map.remove(delKey);
            }else {
                map.put(delKey, delTimes-1);
            }

            int incrKey = nums.get(end);
            boolean exist = map.containsKey(incrKey);
            if (exist){
                map.put(incrKey,map.get(incrKey)+1);
            }else {
                map.put(incrKey,1);
            }
            //todo 存疑
            /*curSum = 0;
            if (map.size() >= m){
                if (delKey < incrKey || !lastLoop){
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        curSum += (long) entry.getKey() *entry.getValue();
                    }
                    if (curSum > sum){
                        sum = curSum;
                    }
                }
            }*/

            curSum = curSum + incrKey - delKey;
            if (map.size() >= m && curSum > sum){
                sum = curSum;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution_2841 solution2841 = new Solution_2841();

        int[] ints = new int[]{
//                2,6,7,3,1,7
//                5,9,9,2,4,5,4
//                1,2,1,2,1,2,1
//                1
                996021492,996021492,973489433,66259330,554129007,713784351,646092981,328987029,469368828,685679486,66259330,165954500,731567840,595800464,552439059,14673238,157622945,521321042,386913607,733723177,330475939,462727944,69696035,958945846,648914457,627088742,363551051,50748590,400980660,674779765,439950964,613843311,385212079,725525766,813504429,385212079,66563232,578031878,935017574,554725813,456892672,245308625,626768145,270964388,554725813,768296675,676923124,939689721,115905765,625193590,717796816,27972217,277242430,768296675,480860474,659230631,570682291,601689140,955632265,767424000,251696645,675750691,767424000,251696645,767424000,675750691,675750691,251696645
        };

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            arr.add(ints[i]);
        }
        int m = 8;
        int k = 8;

        System.out.println(solution2841.maxSum(
                arr,m,k
        ));
    }

}
