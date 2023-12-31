package src.com.leetcode.java.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Trie {

        class Node{
            HashMap<Character , Node> child = new LinkedHashMap<>();
            boolean isEnd = false;
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for(int i=0 ; i<word.length();i++){
                char ch = word.charAt(i);
                if(!curr.child.containsKey(ch)){
                    curr.child.put(ch, new Node());
                }
                curr = curr.child.get(ch);
            }
            curr.isEnd = true;
        } //Tc : O(n) and SC: O(n)

        public boolean search(String word) {
            Node curr = root;
            for(int i=0;i<word.length();i++){
                char ch= word.charAt(i);
                if(!curr.child.containsKey(ch)) return false;
                curr= curr.child.get(ch);
            }
            return curr.isEnd;
        } //TC : O(n) and SC : O(1)

        public boolean startsWith(String prefix) {
            Node curr =root;
            for(int i=0 ;i<prefix.length() ; i++){
                char ch = prefix.charAt(i);
                if(! curr.child.containsKey(ch)) return false;
                curr = curr.child.get(ch);
            }
            return true;
        }//TC : O(n) and SC : O(1)

    public List<String> getWords() {
        List<String> words = new ArrayList<>();
        getWordsRecursive(root, "", words);
        return words;
    } //TC : O(n) and SC : O(n)

    private void getWordsRecursive(Node node, String currentWord, List<String> words) {
        if (node.isEnd) {
            words.add(currentWord);
        }
        for (char ch : node.child.keySet()) {
            Node childNode = node.child.get(ch);
            getWordsRecursive(childNode, currentWord + ch, words);
        }
    }
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */


}
