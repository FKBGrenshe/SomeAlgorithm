package dataStructure.trees.bTrees;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-01-18
 * @Description: B树定义
 */
public class BTree {

    static class bTreeNode{
        boolean leaf= true; // 是否为叶子节点
        int[] keys; //关键字树组
        bTreeNode[] childs; //孩子树组
        int t; // 最小度数
        int keyNumber; // 有效关键字数目

        public bTreeNode(int t) {
            this.t = t;
            keys = new int[2*t];
            childs = new bTreeNode[2*t];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }


        // 多路查找
        bTreeNode get(int key){
            // 遍历Key树组，找到第1个＞key的关键字Key位置i -- 即应该去第i个Child中迭代查找
            int i = 0;
            while (i != keyNumber){
                if (keys[i] == key){
                    // 正好找到key，当前节点就是要找的节点，返回
                    return this;
                }
                if (keys[i] > key){
                    // 找到第1个＞key的关键字Key位置i -跳出循环- 应该去第i个Child中迭代查找
                    break;
                }
                i++;
            }
            // 遍历后，有两种情况，
            // 1）找到第1个＞key的关键字Key位置i -跳出循环- 应该去第i个Child中迭代查找
            // 2）没有找到＞key的关键字 -向最后一个Child中继续寻找，最后一个Child刚好就是此时的第i个Child

            if (leaf){
                // 如果当前节点无叶子节点，则无此key，返回
                return null;
            }
            return childs[i].get(key);
        }

        // 向keys指定索引处，插入新key
        void insertKey(int key, int index){
            System.arraycopy(keys,index,keys,index+1,keyNumber-index);
            keys[index]=key;
            keyNumber++;
        }

        // 向childs指定索引处插入新child
        void insertChild(bTreeNode child,int index){
            System.arraycopy(childs,index,childs,index+1,keyNumber-index);
            childs[index]=child;
        }

        int removeKey(int index){
            int t = keys[index];
            System.arraycopy(keys, index+1, keys, index, --keyNumber-index);
            return t;
        }

        int removeLeftmostKey(){
            return removeKey(0);
        }

        int removeRightmostKey(){
            return removeKey(keyNumber - 1);
        }

        bTreeNode removeChild(int index){
            bTreeNode child = childs[index];
            System.arraycopy(childs, index+1, childs, index, keyNumber - index);
            childs[keyNumber] = null;
            return child;
        }

        bTreeNode removeLeftmostChild(){
            return removeChild(0);
        }
        bTreeNode removeRightmostChild(){
            return removeChild(keyNumber);
        }

        // index 孩子处左边的兄弟
        bTreeNode childLeftSibling(int index){
            return index > 0 ? childs[index - 1] : null;
        }

        bTreeNode childRightSibling(int index){
            return index == keyNumber ? null : childs[index + 1];
        }

        // 复制当前节点的所有key和child到target中
        void moveToTarget(bTreeNode target){
            int start = target.keyNumber;
            if (!leaf) {
                // 如果不是叶子节点 - 当前节点有孩子 - 将当前节点的孩子追加到目标节点
                for (int i = 0; i <= keyNumber; i++){
                    target.childs[start+i] = childs[i];
                }
            }
            // 将key也追加在当前节点上
            for (int i = 0; i < keyNumber;  i++){
                target.keys[target.keyNumber++] = keys[i];
            }
        }

        bTreeNode leftSibiling(int index){
            return index > 0 ? childs[index-1] : null;
        }
        bTreeNode rightSibiling(int index){
            return  index == keyNumber ? null : childs[index + 1];
        }

    }

    int t;
    final int MIN_KEY_NUMBER;
    final int MAX_KEY_NUMBER;
    bTreeNode root;

    public BTree() {
        this.t=2;
        MIN_KEY_NUMBER = t-1;
        MAX_KEY_NUMBER = 2*t-1;
    }

    public BTree(int t) {
        this.t = t;
        root = new bTreeNode(t);
        MIN_KEY_NUMBER = t-1;
        MAX_KEY_NUMBER = 2*t-1;
    }

    // contain
    public boolean contain(int key){
        return Objects.isNull(root.get(key));
    }
    // insert
    public void put(int key){
        doPut(root,key,null,0);
    }

    public void doPut(bTreeNode curNode, int key, bTreeNode parent, int index){
        int i = 0;
        while (i != curNode.keyNumber){
            if (curNode.keys[i] == key){
                // todo 更新流程
                return;
            }
            if (curNode.keys[i] > key){
                // 找到第1个＞key的位置
                break;
            }
            i++;
        }
        if (curNode.leaf){
            // leafNode 直接插入即可
            curNode.insertKey(key,i);
        }else {
            // 非leaf节点，向其child递归插入
            doPut(curNode.childs[i], key, curNode, i);
        }

        // 插入完成后，需要检查是否需要分裂，由于分裂会向父节点插入新key，所以也需要在递归逻辑中，对每个节点进行检查
        if (curNode.keyNumber == 2*t-1) {
            // 需要分裂
            this.splite(curNode,parent,index);
        }
    }

    public void remove(int key){
        doRemove(null,root,0,key);
        //todo

    }

    public void doRemove(bTreeNode parent, bTreeNode curNode, int index , int key){
        int i = 0;
        while (i != curNode.keyNumber){
            if (curNode.keys[i] >= key){
                break;
            }
            i++;
        }
        if (curNode.leaf){
            if (notfound(curNode, key, i)){
                // case1：当前节点是叶子节点，没找到
                return;
            }else {
                // case2：当前节点是叶子节点，找到了
                 curNode.removeKey(i);
            }
        }else {
            if (notfound(curNode, key, i)){
                //case3：当前节点是非叶子节点，没找到 -> 到当前节点的child中继续查找
                doRemove(curNode,curNode.childs[i],i,key);
            }else {
                //case4：当前节点是非叶子节点，找到了 -> 找到后继节点，进行替换，然后再删除后继key
                bTreeNode s = curNode.childs[i + 1];
                while (!s.leaf){
                    s = s.childs[0];
                }
                // s 是后继节点 -sKey是后继key
                int sKey = s.keys[0];
                // 用后继key替换待删除key
                curNode.keys[i] = sKey;
                // 删除后继key
                doRemove(curNode,curNode.childs[i+1], i+1, sKey);
            }
        }
        if (curNode.keyNumber < MIN_KEY_NUMBER){
            // case5 & 6
            balance(curNode, index, parent);

        }
    }

    private void balance(bTreeNode curNode, int index, bTreeNode parent){
        // case 6 root 节点
        if (curNode == this.root){
            // 根节点可以小于最小度数
            // 当合并后，根节点有可能为空，其keyNumber=0，将左子节点当作新的根节点
            if (root.keyNumber == 0 && Objects.nonNull(root.childs[0])){
                root = root.childs[0];
            }
            return;
        }
        bTreeNode leftSibiling = parent.leftSibiling(index);
        bTreeNode rightSibiling = parent.rightSibiling(index);
        // case 5.1 -- 左边富裕 - 右旋
        if (Objects.nonNull(leftSibiling) && leftSibiling.keyNumber > MIN_KEY_NUMBER) {
            // 将父节点中index-1的key（前驱key）旋转下来
            curNode.insertKey(parent.keys[index-1],0);
            // 如果左边兄弟有孩子，将最右边的孩子移动给当前节点的最左边
            if (!leftSibiling.leaf) {
                curNode.insertChild(leftSibiling.removeRightmostChild(),0);
            }
            // 左边兄弟富裕的key旋转到父节点中
            parent.keys[index-1] = leftSibiling.removeRightmostKey();
            return;
        }
        // case 5.2 -- 右边富裕 - 左旋
        if (Objects.nonNull(rightSibiling) && rightSibiling.keyNumber > MIN_KEY_NUMBER) {
            // 将父节点中index的key（后继key）左旋转下来
            curNode.insertKey(parent.keys[index], curNode.keyNumber);
            // 如果右边兄弟有孩子，将最左边的孩子移动给当前节点的最右边
            if (!rightSibiling.leaf){
                curNode.insertChild(rightSibiling.removeLeftmostChild(), curNode.keyNumber+1);
            }
            // 右边兄弟富裕的key左旋转到父节点最右边
            parent.keys[index] = rightSibiling.removeLeftmostKey();
            return;
        }
        // case 5.3 -- 左右都不富裕 - 合并
        if (Objects.nonNull(leftSibiling)){
            // 向左兄弟合并
            /* 需要合并的节点：当前节点， 父节点中的一个key，左兄弟
            *  合并目的地： 左兄弟
            *  合并流程：父节点中的一个key 是指 当前节点索引前的key，即父节点中索引inde-1的key
            *    1. 先将父节点中的一个key合并到左兄弟上
            *    2. 再将当前节点合并到左兄弟上
            * */
            // 将当前节点从父节点中删除
            parent.removeChild(index);
            leftSibiling.insertKey(parent.removeKey(index-1), leftSibiling.keyNumber);
            curNode.moveToTarget(leftSibiling); // 将当前节点的所有孩子和key移动到左兄弟(追加到末尾)
        }else {
            // 左兄弟为空，向自己合并
            /* 将自己当作左兄弟，右兄弟当作“当前节点”，所有index+1
            * */
            parent.removeChild(index+1);
            curNode.insertKey(parent.removeKey(index), curNode.keyNumber);
            rightSibiling.moveToTarget(curNode);
        }



    }

    private boolean notfound(bTreeNode curNode, int key, int i) {
        return i >= curNode.keyNumber || (i < curNode.keyNumber && curNode.keys[i] != key);
    }

    /**
     * 分裂流程
     * @param left 待分裂节点 - 分裂后变为偏左子孩子所以名为left
     * @param parent 父节点
     * @param index 待分裂节点在父节点的索引号
     */
    private void splite(bTreeNode left, bTreeNode parent, int index){
        if (Objects.isNull(parent)){
            // 分裂的是Root节点
            bTreeNode newRoot = new bTreeNode(t);
            newRoot.leaf = false;
            newRoot.insertChild(left,0);
            this.root = newRoot;
            parent = newRoot;
        }

        bTreeNode right = new bTreeNode(this.t);
        // 分裂出的偏右子节点的leaf属性与原节点一致
        right.leaf = left.leaf;
        // 从原节点中，将偏右需分裂的keys和childs移动到新节点right中
        //System.arraycopy(left.keys,(t-1)+1,right.keys,0,(2*t-1)-(t-1)-1);
        System.arraycopy(left.keys,t,right.keys,0,t-1);
        right.keyNumber=t-1;
        // 以上只是从left拷贝到了right，left中没有进行删除，只是keyNumber标记为无效
        left.keyNumber=t-1;
        if (!right.leaf){
            //System.arraycopy(left.childs,(t-1)+1,right.childs,0,(2*t-1)-(t-1)-1+1);
            System.arraycopy(left.childs,t,right.childs,0,t);
        }
        // 从中间key t-1 插入 父节点
        int middle = left.keys[t-1];
        parent.insertKey(middle,index);
        // right节点作为父节点孩子
        parent.insertChild(right,index+1);
    }

    // delete
}
