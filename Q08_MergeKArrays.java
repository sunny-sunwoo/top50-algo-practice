package top50_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.w3c.dom.Node;

/**
 *  Question: Given k sorted arrays, merge them into a single sorted array.
 *  
 *  e.g.
 *  merge({{1, 4, 7},{2, 5, 8},{3, 6, 9}}) = {1, 2, 3, 4, 5, 6, 7, 8, 9}
 *  
 *  [Approach] PQ + Node class (with val & iter)
 *  1. create a pq.
 *  2. init pq - offer all node from each list.
 *  3. while pq is not empty
 *     1) poll the top. add to the result list.
 *     2) top has next? put next node. 
 *  
 * @author Sunny Park
 *
 */
public class Q08_MergeKArrays {
    public static List<Integer> mergeKSortedArr(List<List<Integer>> input) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getValue));
        for (List<Integer> currList : input) {
            Iterator<Integer> iter= currList.iterator();
            if (!iter.hasNext()) continue;
            pq.offer(Node.of(iter.next(), iter));
        }
        
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            result.add(top.getValue());
            if (top.hasNext()) {
                pq.offer(top.toNext());
            }
        }
        
        return result;
    }
    
    private static class Node {
        int val;
        Iterator<Integer> iter;
        
        private Node(int val, Iterator<Integer> iter) {
            this.val = val;
            this.iter = iter;
        }
        
        static Node of(int val, Iterator<Integer> iter) {
            return new Node(val, iter);
        }
        
        int getValue() {
            return this.val;
        }
        
        boolean hasNext() {
            return iter.hasNext();
        }
        
        Node toNext() {
            return Node.of(iter.next(), iter);
        }
        
    }
    
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 4, 7));
        input.add(Arrays.asList(2, 5, 8));
        System.out.println(mergeKSortedArr(input));
    }
}
