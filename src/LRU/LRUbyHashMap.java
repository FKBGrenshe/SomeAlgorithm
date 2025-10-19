package LRU;

import java.util.HashMap;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-10-19
 * @Description: 基于双向链表和哈希表的LRU算法
 */
public class LRUbyHashMap {

    class DLinkNode{
        Integer key;
        Integer value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public DLinkNode() {
        }
    }

    HashMap<Integer,DLinkNode> hashMap = new HashMap<>();
    DLinkNode head = new DLinkNode();
    DLinkNode tail = new DLinkNode();
    int capacity;

    public LRUbyHashMap(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if (!contain(key)) {
            return -1;
        }

        DLinkNode curNode = hashMap.get(key);
        move2Head(curNode);
        return curNode.value;
    }
    public void put(int key, int value){
        DLinkNode curNode = null;
        if (!contain(key)){
            if (hashMap.size() >= capacity){
                // 逐出最久未使用node
                DLinkNode oldestNode = deleteOldestNode();
                hashMap.remove(oldestNode.key);
            }
            // 插入
            curNode = new DLinkNode(key,value);
            hashMap.put(key,curNode);
            insertIntoHead(curNode);
        }else {
            // 更新数据值
            curNode = hashMap.get(key);
            curNode.value = value;
            // move2Head
            move2Head(curNode);
        }
    }

    public void insertIntoHead(DLinkNode curNode) {
        // todo
        insertCurNode(curNode,head, head.next);

    }

    public DLinkNode deleteOldestNode() {
        // 删除最久的
        DLinkNode oldestNode = tail.prev;
        deleteCurNode(oldestNode);
        return oldestNode;
    }

    public void deleteCurNode(DLinkNode curNode){
        DLinkNode prevNode = curNode.prev;
        DLinkNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        curNode.prev = null;
        curNode.next = null;
    }

    public void insertCurNode(DLinkNode curNode, DLinkNode prevNode, DLinkNode tailNode){
        prevNode.next = curNode;
        curNode.next = tailNode;
        ////////////////////////
        tailNode.prev = curNode;
        curNode.prev = prevNode;
    }

    public void move2Head(DLinkNode curNode){
        // 将其移至对头
        deleteCurNode(curNode);
        insertCurNode(curNode,head,head.next);
    }


    public boolean contain(int key){
        return hashMap.containsKey(key);
    }


    public static void main(String[] args) {
        LRUbyHashMap map = new LRUbyHashMap(2);

        map.put(1,1);
        map.put(2,2);
        map.get(1);
        map.put(3,3);
        map.get(2);
        map.put(4,4);
        map.get(1);
        map.get(3);
        map.get(4);


    }

}
