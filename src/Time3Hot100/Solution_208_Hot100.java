package Time3Hot100;
// todo
import java.util.ArrayList;
import java.util.List;

/*
* 示例：

输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
*
* */


class Trie{

    TrieNode root;

    class TrieNode{
        Character curVal;
        List<TrieNode> childs;
        boolean isEnd; // 标记从根到该节点是否构成一个完整单词

        public TrieNode(Character curVal) {
            this.curVal = curVal;
            this.childs = new ArrayList<>();
            this.isEnd = false;
        }
    }

    public Trie() {
        root = new TrieNode(null); // 哨兵根节点，curVal 不存实际字符
    }

    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            TrieNode match = null;
            for (TrieNode child : curNode.childs) {
                if (child.curVal.equals(curChar)) {
                    match = child;
                    break;
                }
            }
            if (match == null) {
                match = new TrieNode(curChar);
                curNode.childs.add(match);
            }
            curNode = match;
        }
        curNode.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // 返回 prefix 对应的最后一个节点；若前缀不存在返回 null
    private TrieNode searchPrefix(String prefix) {
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curChar = prefix.charAt(i);
            TrieNode match = null;
            for (TrieNode child : curNode.childs) {
                if (child.curVal.equals(curChar)) {
                    match = child;
                    break;
                }
            }
            if (match == null) {
                return null;
            }
            curNode = match;
        }
        return curNode;
    }
}


public class Solution_208_Hot100 {
}


