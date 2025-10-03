import java.util.ArrayList;
import java.util.Arrays;

public class Solution_42_Hot100 {
    public int trap(int[] height) {

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        Arrays.fill(leftMax,0);
        Arrays.fill(rightMax,0);

        int totalWater = 0;

        int tempLeftIdx = 0;
        int tempLeftMaxVal = -1, tempRightMaxVal = -1;
        int tempRightIdx = height.length-1;
        for (int i = 0; i < height.length; i++) {
            // 计算左墙高度
            if (height[tempLeftIdx] > tempLeftMaxVal){
                tempLeftMaxVal = height[tempLeftIdx];
            }
            // 计算右墙高度
            if (height[tempRightIdx] > tempRightMaxVal){
                tempRightMaxVal = height[tempRightIdx];
            }
            leftMax[tempLeftIdx] = tempLeftMaxVal;
            rightMax[tempRightIdx] = tempRightMaxVal;
            tempLeftIdx++;
            tempRightIdx--;
        }

        for (int i = 0; i < height.length; i++) {
            totalWater += Math.min(leftMax[i],rightMax[i]) - height[i];
        }

        return totalWater;
    }

    /**
     * 雨水量 = Math.min(左墙最大高度,右墙最大高度) - 自身柱子高度
     * @param height
     * @return
     */
    public int trapV2(int[] height) {

        ArrayList<Integer> high = new ArrayList<>(height.length);
        for (int i : height) {
            high.add(i);
        }

        int[] volume = new int[height.length];

        int maxVal = Arrays.stream(height).max().orElse(height[0]);
        int maxIdx = high.indexOf(maxVal);

        int leftDir = 1;
        volume[0] = Math.min(height[0],maxVal);
        while (leftDir < maxIdx){
            volume[leftDir] = Math.max(volume[leftDir-1],height[leftDir]);
            leftDir++;
        }

        int rightDir = height.length-2;
        volume[height.length-1] = Math.min(height[height.length-1],maxVal);
        while (rightDir>maxIdx){
            volume[rightDir] = Math.max(height[rightDir],volume[rightDir+1]);
            rightDir--;
        }


        int count = 0;

        for (int i = 0; i < height.length; i++) {

            count += Math.max( volume[i] - height[i] ,0);

        }
        return count;
    }

    /**
     * 相向双指针 + 数组存储
     * @param height
     * @return
     */
    public int trapV3(int[] height) {

        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];

        int leftMax = 0, rightMax = 0;

        for (int i = 0; i < height.length; i++) {

            int left = i;
            int right = height.length - i - 1;

            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);

            leftHeight[left] = leftMax;
            rightHeight[right] = rightMax;
        }

        int count = 0;
        for (int i = 0; i < height.length; i++) {
            count += Math.max(Math.min(leftHeight[i], rightHeight[i]) - height[i], 0);
        }

        return count;
    }

    /**
     * 相向双指针 + O(1)存储
     * @param height
     * @return
     */
    public int trapV4(int[] height) {
        // 指针
        int left = 0;
        int right = height.length - 1;
        // 左右最高墙高度
        int leftTall = 0;
        int rightTall = 0;
        // 盛水容积
        int count = 0;

        while (left < right){

            if (height[left] <= height[right]){

                if (height[left] > leftTall) {
                    leftTall = height[left];
                }else {
                    count +=  leftTall - height[left];
                }
                left++;

            }else {

                if (height[right] > rightTall){
                    rightTall = height[right];
                }else {
                    count += rightTall - height[right];
                }
                right--;

            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution_42_Hot100 solution42 = new Solution_42_Hot100();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution42.trapV4(height));
    }
}
