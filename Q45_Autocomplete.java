package top50_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write an autocomplete class that returns all dictionary words with a given prefix.
 * 
 * [Approach] Prefix trie
 * 1. how to represent Node object?
 *    - 3 fields: 1) String prefix, 2)Map<Character, Node> children, 3) isWord - to mark the last character.
 *    - constructor: pass-in prefix. initialize hashmap.
 *    
 * 2. Autocomplete object: 
 *    - 1 field: trie (to represent the root.)
 *    - constructor: pass in dictionary.
 *    - 2 methods: insert, findWordsByPrefix(+ helper method to find recursively)
 *    
 * 3. how to write the 2 methods of Autocomplete object.
 *   1) insert - linear scan of each char in the string.
 *      1. check if trie's children map contains curr char in the keyset.
 *         - if not, put a new Node with curr char in the children map.
 *         - update curr to iterate. (like LL pointer)
 *         
 *   2) findWordsByPrefix - linear scan of input string.
 *      1. iterate through the charArr.
 *         - if trie's children map contains curr char.
 *           -> go down to the path (like LL)
 *           
 *         - else, 
 *           -> return the result.
 *           
 *      2. if the node of input found, find(node, result)
 *      
 *   3) helper method: find recursively
 *      1. base case: if node.isWord is true -> add curr prefix to the result.
 *      2. traverse down to the children nodes.
 *     
 * @author Sunny Park
 *
 */
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
    Q45_Autocomplete(List<String> dictionary) {
        trie = new Node("");
        for (String word : dictionary) {
            insert(word);
        }
    }
    
    private void insert(String word) {
        Node curr = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(word.substring(0, i + 1)));
            }
            curr = curr.children.get(c);
            if (i == word.length() - 1) {
                curr.isWord = true;
            }
        }
    }
    
    public List<String> findWordByPrefix(String input) {
        List<String> result = new ArrayList<>();
        Node curr = trie;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return result;
            }
        }
        findWordByPrefix(curr, result);
        return result;
    }
    
    private void findWordByPrefix(Node node, List<String> result) {
        if (node.isWord) {
            result.add(node.prefix);
            return;
        }
        for (Character c : node.children.keySet()) {
            findWordByPrefix(node.children.get(c), result);
        }
    }
    
    public static void main(String[] args) {
        Q45_Autocomplete tester = new Q45_Autocomplete(Arrays.asList("a", "abc", "abd", "dog", "dot", "ddd"));
        System.out.println(tester.findWordByPrefix("do"));
    }
    
    
}
