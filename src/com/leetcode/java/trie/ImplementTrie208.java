package src.com.leetcode.java.trie;

public class ImplementTrie208 {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("suhag");
        t.insert("aman");
        t.insert(" suha");
        System.out.println(t.search("suhag"));
        System.out.println(t.startsWith("suh"));
        System.out.println(t.getWords());
    }
}
