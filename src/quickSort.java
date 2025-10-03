/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-28
 * @Description: 快排
 */
public class quickSort {

    public static int[] quickSort(int[] arr, int left, int right){
        if(left < right){
            int pivotIdx = partition(arr, left, right);
            //递归 -- left -- right
            quickSort(arr,left, pivotIdx-1);
            quickSort(arr, pivotIdx+1, right);
        }

        return arr;

    }

    // 分区函数
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; //基准值
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j); // 小的移动到左边
            }
        }
        // left = right , pivot 移动到中间
        swap(arr, i+1, right);
        return i+1;

    }

    //
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

        int[] arr = { 5, 2, 3, 4, 6, 7, 8, 9, 10, 1};
        int[] res = quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }

}
