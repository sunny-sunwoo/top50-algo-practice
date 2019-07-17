package top50_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q45_Autocomplete {
    private static class Node {
        String prefix;
        Map<Character, Node> children;
        boolean isWord;
        
        Node(String prefix) {
            this.prefix = prefix;
            children = new HashMap<>();
        }
    }
    
    Node trie;
    Q45_Autocomplete(List<String> dict) {
        trie = new Node("");
        for (String word : dict) {
            insertWord(word);
        }
    }
    
    private void insertWord(String word) {
        Node curr = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(word.substring(0, i + 1)));
            }
            curr = curr.children.get(c);
            if (i == word.length() - 1) curr.isWord = true;
        }
    }
    
    public List<String> findWordsByPrefix(String pre) {
        List<String> result = new ArrayList<>();
        Node curr = trie;
        for (int i = 0; i < pre.length(); i++) {
            char c = pre.charAt(i);
            if (!curr.children.containsKey(c)) {
                return result;
            }
            curr = curr.children.get(c);
        }
        findAll(result, curr);
        return result;
    }
    
    private void findAll(List<String> result, Node node) {
        if (node.isWord) {
            result.add(node.prefix);
        }
        for (Character c : node.children.keySet()) {
            findAll(result, node.children.get(c));
        }
    }
    
    public static void main(String[] args) {
        Q45_Autocomplete ac = new Q45_Autocomplete(Arrays.asList("a", "ab", "bc"));
        System.out.println(ac.findWordsByPrefix("a"));
    }
}
