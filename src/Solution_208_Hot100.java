/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-22
 * @Description: 208前缀树
 */
public class Solution_208_Hot100 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class Trie{

    Trie[] childs;
    char val;
    boolean isEnd;

    public Trie() {
        childs = new Trie[26];
        val = ' ';
    }

    public Trie(char val) {
        childs = new Trie[26];
        this.val = val;
    }

    public void insert(String word) {
        if (this.childs[word.charAt(0) - 'a'] == null){
            this.childs[word.charAt(0) - 'a'] = new Trie(word.charAt(0));
        }
        if (word.length() == 1){
            this.childs[word.charAt(0) - 'a'].isEnd = true;
        }
        if (word.length() > 1){
            this.childs[word.charAt(0) - 'a'].insert(word.substring(1));
        }
    }

    public boolean search(String word) {
        if (word.length() == 1 && this.childs[word.charAt(0) - 'a'] != null){
            return this.childs[word.charAt(0) - 'a'].isEnd;
        }
        if (this.childs[word.charAt(0) - 'a'] == null){
            return false;
        }else {
            return this.childs[word.charAt(0) - 'a'].search(word.substring(1));
        }
    }

    public boolean startsWith(String prefix) {
        if (prefix.length() == 1 && this.childs[prefix.charAt(0) - 'a'] != null){
            return true;
        }
        if (this.childs[prefix.charAt(0) - 'a'] == null){
            return false;
        }else {
            return this.childs[prefix.charAt(0) - 'a'].startsWith(prefix.substring(1));
        }
    }
}


