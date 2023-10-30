package src.com.leetcode.java.trie;

//208. Implement Trie (Prefix Tree)

public class ImplementTrie208 {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("suhag");
        t.insert("aman");
        t.insert(" suha");
        t.insert("ankit");
        System.out.println(t.search("suhag"));
        System.out.println(t.startsWith("suh"));
        System.out.println(t.getWords());
    }
}
