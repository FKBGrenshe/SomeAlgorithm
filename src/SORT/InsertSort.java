package SORT;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-12
 * @Description: 直接插入排序
 * 空间复杂度：O(1) -- 仅需要有限个变量
 * 时间复杂度：O(n^2) -- 两层for循环嵌套
 * 稳定性：稳定 -- 重复元素可以不交换位置
 */
public class InsertSort {

    public static void sort(int[] arr){
        // 从第二个元素开始，进行排序
        for (int i = 1; i < arr.length; i++) {
            insertX(arr,i);
        }
    }

    /**
     * 单层插入，
     * @param arr 当前数组
     * @param curIdx 当前需要插入元素的位置
     */
    public static void insertX(int[] arr, int curIdx){
        int tempCurValue = arr[curIdx];
        for (int i = curIdx - 1; i >= 0; i--) {
            // 从后往前交换顺序
            if (arr[i] > arr[i+1]){
                arr[i+1] = arr[i];
                arr[i] = tempCurValue;
            }else{
                //说明 arr[i]<= arr[curIdx]
                // 说明当前排序结束，返回
                return;
            }
        }
    }

}
