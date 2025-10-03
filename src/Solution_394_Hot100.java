public class Solution_394_Hot100 {
    public static String decodeString(String s){

        int rightIdx = 0;
        int leftIdx = 0;

        String copyString = "";
        String headString = "";
        String tailString = "";

        while((rightIdx = s.indexOf("]")) != -1){
            tailString = s.substring(rightIdx+1);
            for (int i = rightIdx-1; i > 0; i--) {
                if (s.charAt(i) == '['){
                    leftIdx = i;
                    break;
                }
            }
            copyString = s.substring(leftIdx+1,rightIdx);
            // 找数字
            int number = -1;
            for (int i = leftIdx -1; i >= 0; i--){
                if (!(s.charAt(i)>=48 && s.charAt(i)<=57)){
                    number = Integer.valueOf(s.substring(i+1,leftIdx));
                    headString = s.substring(0,i+1);
                    break;
                }
            }
            if (number == -1){
                number = Integer.valueOf(s.substring(0,leftIdx));
            }
            for (int i = 0; i < number; i++) {
                headString += copyString;
            }
            s = headString + tailString;
            headString = "";
            tailString = "";
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(s.substring(0, 1));

        System.out.println(decodeString(s));
    }
}
