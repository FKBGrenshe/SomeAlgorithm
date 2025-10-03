import java.util.*;

public class Solution_146_Hot100 {

    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        System.out.println(lRUCache.get(1));    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));    // 返回 3
//        System.out.println(lRUCache.get(4));    // 返回 4
        //["LRUCache","put","get","put","get","get"]
        //[[1],        [2,1],[2], [3,2], [2], [3]]
//        lRUCache.put(2, 1);
//        System.out.println(lRUCache.get(2));
//        lRUCache.put(3, 2);
//        System.out.println(lRUCache.get(2));
//        System.out.println(lRUCache.get(3));

        // ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
        // [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.put(3, 3);
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(1));
        lRUCache.put(5, 5);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(5));


    }
}

class LRUCache {

    private int capacity;
    private Dnode head = new Dnode(-1,-1,null,null);
    private Set<Integer> keySet = new HashSet<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keySet.contains(key)){
            // 节点存在，返回值，并放到头
            Dnode tempIdx = findNode(key);
            int value = tempIdx.value;
            putInfront(tempIdx);
            return value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (keySet.size() == 0){
            // 插入第一个元素
            Dnode newNode = new Dnode(key,value,head,null);
            head.next = newNode;
            keySet.add(key);
        }
        else if (keySet.contains(key)) {
            // 已经存在，则更改值，并将该节点放到头
            Dnode tempIdx = findNode(key);
            tempIdx.value = value;
            putInfront(tempIdx);
        }else {
            // 不存在
            if (keySet.size() == capacity){
                // size 不可以放入，删除尾节点
                Dnode tempIdx = head.next;
                while (tempIdx.next != null){
                    tempIdx = tempIdx.next;
                }
                tempIdx.pre.next = null;
                tempIdx.pre = null;
                keySet.remove(tempIdx.key);
            }

            if (keySet.size() == 0){
                // 插入第一个元素
                Dnode newNode = new Dnode(key,value,head,null);
                head.next = newNode;
                keySet.add(key);
            }else {
                // 头插法
                Dnode newNode = new Dnode(key,value,head,head.next);
                head.next = newNode;
                newNode.next.pre = newNode;
                keySet.add(key);
            }
        }
    }

    private Dnode findNode(int key) {
        Dnode tempIdx = head;
        while (tempIdx.key != key){
            tempIdx = tempIdx.next;
        }
        return tempIdx;
    }

    public void putInfront(Dnode curNode){
        if (head.next == curNode){
            // 说明当前节点就是头节点，不需要操作
            return;
        }
        if (curNode.next == null){
            // 说明当前节点就是尾节点
            curNode.pre.next = null;
            curNode.pre = head;
            curNode.next = head.next;
            curNode.next.pre = curNode;
            head.next = curNode;
            return;
        }
        // 将prev节点连到next
        curNode.pre.next = curNode.next;
        // 将next节点连到prev
        curNode.next.pre = curNode.pre;
        // 将curNode连到head
        curNode.next = head.next;
        curNode.pre = head;
        head.next.pre = curNode;
        head.next = curNode;

    }

}

class  Dnode{
    int key;
    int value;
    Dnode pre;
    Dnode next;

    public Dnode(int key, int value, Dnode pre, Dnode next) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    public Dnode() {
    }
}


/*class LURCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LURCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }


    public int get(int key){
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return size() > capacity;
    }
}*/
