package top50_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Question: Given a list of strings, write a function 
 * to get the kth most frequently occurring string.
 * 
 * kthMostFrequent({"a","b","c","a","b","a"}, 0) = "a"
 * kthMostFrequent({"a","b","c","a","b","a"}, 1) = "b"
 * kthMostFrequent({"a","b","c","a","b","a"}, 2) = "c"
 * kthMostFrequent({"a","b","c","a","b","a"}, 3) = null
 * 
 * @author Sunny Park
 *
 */
public class Q51_KthMostFreqString {
    public static String kthMostFrequent(List<String> strs, int k) {
        Map<String, Integer> cache = populate(strs);
        PriorityQueue<String> maxHeap = new PriorityQueue<>((s1, s2) -> cache.get(s2) - cache.get(s1));
        cache.entrySet().forEach(e -> maxHeap.offer(e.getKey()));
//        maxHeap.stream().forEach(e -> System.out.println(e));
        String result = null;
        if (k >= strs.size()) {
            return result;
        }
        while (k + 1 > 0) {
            result = maxHeap.poll();
            k--;
        }
        return result;
    }
    
    private static Map<String, Integer> populate(List<String> strs) {
        Map<String, Integer> cache = new HashMap<>();
        for (String str : strs) {
            cache.put(str, cache.getOrDefault(str, 0) + 1);
        }
        return cache;
    }
    
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("a","b","c","a","b","a");
        System.out.println(kthMostFrequent(strs, 0)); // a
        System.out.println(kthMostFrequent(strs, 1)); // b
        System.out.println(kthMostFrequent(strs, 2)); // c
        System.out.println(kthMostFrequent(strs, 3)); // null
    }
}
