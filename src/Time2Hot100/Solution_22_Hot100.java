//package Time2Hot100;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: Bingyu Chen
// * @CreateTime: 2026-03-06
// * @Description: 括号生成
// */
//public class Solution_22_Hot100 {
//
//    List<String> globalResult = new ArrayList<>();
//    StringBuilder curResult = new StringBuilder();
//
//    public List<String> generateParenthesis(int n) {
//        backTracing();
//        return globalResult;
//    }
//
//    private void backTracing(int leftRes, int rightRes) {
//
//
//        if (leftRes + rightRes == 0){
//            globalResult.add(curResult.toString());
//            return;
//        }
//
//        for (int i = 0; i < leftRes; i++) {
//            for (int j = 0; j < i; j++) {
//                curResult.append("(");
//            }
//            backTracing(leftRes-i, rightRes);
//        }
//
//
//    }
//}
