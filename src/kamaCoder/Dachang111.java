package kamaCoder;

import java.util.Scanner;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-08-31
 * @Description: 2023Oppo
 */
public class Dachang111 {

    public static void main(String[] args) {

        int a,b,c,d;
        int value = 0;
        boolean reverse = false;

        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
            value = scanner.nextInt();
//        }

        // 合法性校验
        if (value > 400){
            System.out.println(-1);
            return;
        }
        //
        reverse = value < 0;
        if (reverse){
            value = -1 * value;
        }

        int prodAD = value+1;
        int prodBC = 1;

        int[] ad = null;
        int[] bc = null;
        while ((ad = findADorBC(prodAD)) != null && prodAD <= 400){
            if ((bc = findADorBC(prodBC))!= null){
                // finding answer
                if (reverse){
                    System.out.println(bc[0] + " " + ad[0]);
                    System.out.println(ad[1] + " " + bc[1]);
                }else {
                    System.out.println(ad[0] + " " + bc[0]);
                    System.out.println(bc[1] + " " + ad[1]);
                }
                return;
            }
            prodAD++;
            prodBC++;
        }


        System.out.println(-1);
        return;

    }

    static int[] findADorBC(int product){
        int val1 = 1;
        int val2 = 0;
        while (val1 <= 20 && val1 <= product){
            if (product % val1 == 0){
                val2 = product / val1;
                return new int[]{val1, val2};
            }
            val1++;
        }
        return null;
    }


/*
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        if (x < -399 || x > 399) {
            System.out.print(-1);
        } else {
            for (int i = 1; i <= 20; i++) {
                for (int j = 1; j <= 20; j++) {
                    for (int k = 1; k <= 20; k++) {
                        for (int z = 1; z <= 20; z++) {
                            if (i * j - k * z == x) {
                                System.out.println(i + " " + k);
                                System.out.println(z + " " + j);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }*/


}


