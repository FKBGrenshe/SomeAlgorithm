public class Que {
    int size = 0;
    TreeNode[] arr = new TreeNode[2000];
    int begin = 0, end = 0;

    public TreeNode pop(){
        if (isEmpty()){
            return null;
        }
        // 从对头弹出
        size--;
        return arr[begin++];

    }

    public boolean push(TreeNode treeNode){
        if (isFull()){
            return false;
        }
        arr[end++] = treeNode;
        size++;
        return true;
    }

    public TreeNode getNIdxNode(int idx){
        if (idx < end){
            return arr[idx];
        }else {
            return null;
        }
    }

    public boolean isFull(){
        return size == 2000;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
