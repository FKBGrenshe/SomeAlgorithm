package test;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int length = 0;
    public static int jicha = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        int finaljicha = Integer.MAX_VALUE;
        int finalLength = 0;

        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] org = new int[n];
            for (int i = 0; i < n; i++) {
                org[i] = in.nextInt();
            }
            //////////
            int[] sortArr = Arrays.copyOf(org, org.length);
            Arrays.sort(sortArr);
            boolean flag = false;
            for (int i = 0; i < sortArr.length; i++) {
                if (sortArr[i] == org[i]){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println(sortArr.length-1);
                continue;
            }

            finaljicha = Integer.MAX_VALUE;
            finalLength = 0;
            length = 0;
            jicha = Integer.MAX_VALUE;
            for (int i = 0; i < org.length; i++) {
                findMinCost(Arrays.copyOfRange(org, i, org.length), i);
                if (jicha < finaljicha){
                    finaljicha = jicha;
                    finalLength = length;
                } else if (jicha == finaljicha) {
                    finalLength = Math.max(finalLength, length);
                }
            }

            System.out.println(org.length - finalLength);
            //////////
        }


    }

    // 相当于求一个数组中的极差最小的最大连续区间
    public static void findMinCost(int[] arr, int startIdx){
        //如果数组只剩最后一个
        if (arr.length == 1){
            jicha = 0;
            length = 1;
            return;
        }
        int endIdx = startIdx+1;
        while (endIdx < arr.length){
            if (Math.abs(arr[endIdx] - arr[startIdx]) <= jicha){
                jicha = Math.abs(arr[endIdx] - arr[startIdx]);
                length = Math.max(endIdx - startIdx+1, length);
            }else {
                break;
            }
            endIdx++;
        }
    }

}
