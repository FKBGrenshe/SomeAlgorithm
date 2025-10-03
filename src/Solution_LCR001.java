public class Solution_LCR001 {
    static public int divide(int a, int b) {
        if (a == -2147483647 && b == -1){
            return 2147483647;
        }
        int x = 0;
        if(a == 0 || b==0){
            return 0;
        }
        if(a > 0 && b > 0){
            return func(a,b);
        }else if(a < 0 && b < 0){
            return func(-a,-b);
        }
        else{
            if(a < 0){
                a *= -1;
                x = func(a,b);
            }
            if(b<0){
                b *= -1;
            }
            x = func(a,b);
            return -x;
        }
    }

    static public int func(int a, int b){
        int x = 0;
        while( a >= b){
            a -= b;
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}