package Time2Hot100.Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-10
 * @Description: 前k个高频元素
 */
public class Solution_347_Hot100_method1_maxHeap {

    HashMap<Integer, Integer> nodeMap = new HashMap<>();
    Heap_437 heap = new Heap_437();

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        // 记录出现次数
        for (int val : nums) {
            if (nodeMap.containsKey(val)){
                nodeMap.put(val, nodeMap.get(val)+1);
            }else {
                nodeMap.put(val,1);
            }
        }
        // 转为Node
        nodeMap.entrySet().forEach(new Consumer<Map.Entry<Integer, Integer>>() {
            @Override
            public void accept(Map.Entry<Integer, Integer> curEntry) {
                System.out.println("{val: " + curEntry.getKey() + ", times: "+curEntry.getValue());
                heap.insertNode(new Node_347(curEntry.getKey(), curEntry.getValue()));
            }
        });

        // pop出前k个元素
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.pop();
        }

        return result;
    }
    static class Node_347{

        // 值
        int val;
        // 出现次数
        int times;

        public Node_347(int val, int times) {
            this.val = val;
            this.times = times;
        }

        public void addTime(){
            times++;
        }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    ", times=" + times +
                    '}';
        }
    }

    static class Heap_437 {

        ArrayList<Node_347> list = new ArrayList<>();

        public void insertNode(Node_347 newNode){
            list.addLast(newNode);
//            swiftDown(0);
            swiftUp(list.size()-1);
        }

        private void swiftUp(int curIdx) {
            if (curIdx == 0) return;
            int fatherIdx = (curIdx-1)/2;
            if (fatherIdx < 0) return;

            if (isBigger(list.get(fatherIdx), list.get(curIdx))){
                exchange(fatherIdx,curIdx);
            }
            swiftUp(fatherIdx);
        }

        private void exchange(int fatherIdx, int curIdx) {
            Node_347 tempNode = list.get(fatherIdx);
            list.set(fatherIdx, list.get(curIdx));
            list.set(curIdx,tempNode);
        }

        private boolean isBigger(Node_347 fatherNode, Node_347 curNode) {
            return curNode.times > fatherNode.times;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("------------\n");
            for (Node_347 curNode : list) {
                sb.append(curNode.toString()+"\n");
            }
            sb.append("\n------------");
            return sb.toString();
        }

        public int pop() {

            int rootVal = list.getFirst().val;
            list.set(0,list.get(list.size()-1));
            list.removeLast();
            swiftDown(0);

            return rootVal;
        }

        private void swiftDown(int curIdx) {
            if (curIdx >= list.size()) return;
            int leftChildIdx = curIdx*2 + 1;
            int rightChildIdx = curIdx*2 + 2;
            int changeIdx;

            if (leftChildIdx >= list.size()) return;
            else if (rightChildIdx >= list.size()) {
                changeIdx = leftChildIdx;
            }else {
                changeIdx = list.get(leftChildIdx).times > list.get(rightChildIdx).times ? leftChildIdx : rightChildIdx;
            }
            if (list.get(curIdx).times < list.get(changeIdx).times){
                exchange(curIdx,changeIdx);
                swiftDown(changeIdx);
            }
        }
    }

    public static void main(String[] args) {
        Solution_347_Hot100_method1_maxHeap solution347Hot100 = new Solution_347_Hot100_method1_maxHeap();
        int[] result = solution347Hot100.topKFrequent(
                new int[]{
//                        1, 1, 1, 2, 2, 3
//                        1
//                        -1,2,1,2,1,-2,3,1,3,-2
                },
                4
        );

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }

    }

}
