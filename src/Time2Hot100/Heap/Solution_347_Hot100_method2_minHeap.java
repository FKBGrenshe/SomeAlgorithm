//package Time2Hot100.Heap;
//
//import java.util.HashMap;
//
///**
// * @Author: Bingyu Chen
// * @CreateTime: 2026-03-11
// * @Description: 前k个高频元素
// */
//public class Solution_347_Hot100_method2_minHeap {
//
//    HashMap<Integer, Integer> nodeMap = new HashMap<>();
//
//    public int[] topKFrequent(int[] nums, int k) {
//
//        // 记录出现次数
//        for (int val : nums) {
//            if (nodeMap.containsKey(val)){
//                nodeMap.put(val, nodeMap.get(val)+1);
//            }else {
//                nodeMap.put(val,1);
//            }
//        }
//
//    }
//
//    class minHeap_437{
//
//    }
//
//}
