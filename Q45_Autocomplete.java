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
 *    - 4 fields: 1) String prefix, 2)Map<Character, Node> children, 
 *                3) isWord - to mark the last character, 4)counter - to find uniquePrefix.
 *    - constructor: pass-in prefix. initialize hashmap.
 *    
 * 2. Autocomplete object: 
 *    - 1 field: trie (to represent the root.)
 *    - constructor: pass in dictionary.
 *    - 3 methods: insert, findWordsByPrefix(+ helper method to find recursively), 
 *                 getUniquePrefix(+ helper method for recursion)
 *    
 * 3. how to write the 3 methods of Autocomplete object.
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
 *   2-1) helper method: find recursively
 *      1. base case: if node.isWord is true -> add curr prefix to the result.
 *      2. traverse down to the children nodes.
 *      
 *   3) getUniquePrefix
 *      1. create an AL for result.
 *      2. call private method from the root node. with result.
 *      3. return result
 *      
 *   3-1) helper method: to collect all unique prefix.
 *      1. base case: if the children is empty
 *      2. traverse down to all node. -> iterate over all entryset.
 *          (1) check if it's last word && counter > 1 (e.g. dog, dogt)
 *              -> add the prefix. (dog)
 *          (2) check if counter == 1 (dog, dot, zebra)
 *              -> add the prefix. (z)
 *              -> continue. (bc/ no need to traverse more with zebra)
 *          (3) recursive call on the child node.
 *      
 *     
 * @author Sunny Park
 *
 */
public class Q45_Autocomplete {
    private static class Node {
        private final String prefix;
        private final Map<Character, Node> children;
        private boolean isWord;
        private int counter = 0;
        
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
            curr.counter++;
            if (i == word.length() - 1) {
                curr.isWord = true;
            }
            System.out.println("curr: " + curr.prefix + ", " + curr.counter);
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
    
    public List<String> getUniquePrefix() {
        List<String> result = new ArrayList<>();
        getUniquePrefix(trie, result);
        return result;
    }
    
    private void getUniquePrefix(Node node, List<String> result) {
        if (node.children.isEmpty()) return;
        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            Node child = entry.getValue();
            if (child.isWord && child.counter > 1) {
                result.add(child.prefix);
            }
            if (child.counter == 1) {
                result.add(child.prefix);
                continue;
            }
            getUniquePrefix(child, result);
        }
    }
    
    public static void main(String[] args) {
        Q45_Autocomplete tester = new Q45_Autocomplete(Arrays.asList("dog", "dot", "ddd", "duck", "zebra"));
//        Q45_Autocomplete tester = new Q45_Autocomplete(Arrays.asList("a", "abc", "abd", "dog", "dot", "ddd"));
        System.out.println(tester.findWordByPrefix("do"));
        System.out.println(tester.getUniquePrefix());
    }
    
    
}
