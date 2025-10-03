import java.util.Map;

/**
 * 盛最多水的容器
 */
public class Solution_11_Hot100 {

    public static int maxArea(int[] height) {

        int len = height.length;
        int leftTemp = 0; int left;
        int rightTemp = len-1; int right;
        int containMax = 0;
        int containTemp;

        while (leftTemp < rightTemp){
            containTemp = Math.min(height[rightTemp], height[leftTemp]) * (rightTemp - leftTemp);
            if (containTemp > containMax){
                left = leftTemp;
                right = rightTemp;
                containMax = containTemp;
            }else {
                if (height[leftTemp] < height[rightTemp]){
                    leftTemp++;
                }else {
                    rightTemp--;
                }
            }

        }
        return containMax;
    }

    /**
     * 相向双指针版
     * @param height
     * @return
     */
    public int maxAreaV2(int[] height) {

        int l = 0;
        int r = height.length-1;

        int biggest = 0;

        while (l < r){
            int cur = (r-l)*Math.min(height[l],height[r]);
            if (cur > biggest){
                biggest = cur;
            }

            if (height[l] >= height[r]){
                r--;
            }else {
                l++;
            }

        }



        return biggest;
    }

    /*private static int getContainTemp(int[] height, int rightTemp, int leftTemp) {
        return Math.min(height[rightTemp], height[leftTemp]) * (rightTemp - leftTemp);
    }*/

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        maxArea(arr);

        Solution_11_Hot100 solution11Hot100 = new Solution_11_Hot100();
        System.out.println(solution11Hot100.maxAreaV2(arr));
    }
}
