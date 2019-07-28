package top50_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Q. Given a directed graph, find the shortest path between two nodes if one exists.
 * e.g.
 *  1 -> 2, 3 -> 5 -> 4 -> 3, 1 
 *  shortestPath(2, 3) = 2 ‐> 5 ‐> 4 ‐> 3
 *  
 *  [Approach] bfs. child - parent map
 *  1. create a hashmap. queue.
 *  2. init with the starting point - put in the map and queue.
 *  3. while q is not empty,
 *     - poll
 *     - if top is the dest -> break.
 *     - if top's children is empty -> continue
 *     - otherwise, put in the hm and q
 *  4. if dest is not contained in the map -> rt null.
 *  5. build result in reverse.
 *  
 * @author Sunny Park
 *
 */
public class Q16_ShortestPath {
    public static List<Node> shortestPath(Node src, Node dest) {
        Map<Node, Node> cache = new HashMap<>();
        Queue<Node> toVisit = new LinkedList<>();
        
        cache.put(src, null);
        toVisit.offer(src);
        
        while (!cache.isEmpty()) {
            Node top = toVisit.poll();
            
            if (top.equals(dest)) break;
            if (top.children.isEmpty()) break;
            
            for (Node child : top.children) {
                if (!cache.containsKey(child)) {
                    cache.put(child, top);
                    toVisit.offer(child);
                }
            }
        }
        
        LinkedList<Node> result = new LinkedList<>();
        if (!cache.containsKey(dest)) return result;
        
        Node curr = dest;
        while (curr != null) {
            result.addFirst(curr);
            curr = cache.get(curr);
        }
        
        return result;
        
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        
        n1.addChild(n2);
        n1.addChild(n3);
        
        n2.addChild(n5);
        
        n5.addChild(n4);
        n4.addChild(n1);
        n4.addChild(n3);
        
        System.out.println(shortestPath(n2, n3));
    }
    
    private static class Node {
        int val;
        List<Node> children;
        
        Node (int val) {
            this.val = val;
            children = new ArrayList<>();
        }
        
        void addChild(Node n) {
            children.add(n);
        }
        
        @Override
        public String toString() {
            return String.valueOf(val);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) {
                return false;
            }
            Node other = (Node) obj;
            return other.val == this.val;
        }
        
        @Override
        public int hashCode() {
            return val;
        }
        
    }
    
}
