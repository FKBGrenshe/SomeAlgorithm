public class Solution_136_Hot100 {
    public static int singleNumber(int[] nums) {

        int answer = 0;
        for (int num : nums) {
            answer = answer ^ num;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1};
        System.out.println(singleNumber(arr));
    }

}
