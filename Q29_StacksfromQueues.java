package top50_questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Question: Implement a LIFO stack with basic functionality (push and pop) 
 * using FIFO queues to store the data.
 * 
 * [Approach]
 * 1. push method
 *    poll n times and offer the rest to the end
 *    to keep the curr elem 
 * stack = [1, 2, 3]
 *  0) keep the size in n
 *  1) offer(to the end) 4
 *  2) poll n times -> offer to the end
 *  
 * stack = [ 4, 1, 2, 3, ]
 * 
 * 2. pop method
 * 
 * 
 * @author Sunny Park
 *
 */
public class Q29_StacksfromQueues {
    Queue<Integer> stack;
    Q29_StacksfromQueues() {
        stack = new LinkedList<>();
    }
    public void push(int x) {
        int currSize = stack.size();
        stack.offer(x);
        while (currSize > 0) {
            stack.offer(stack.poll());
            currSize--;
        }
    }
    
    public int pop() {
        return stack.poll().intValue();
    }
    
    public int size() {
        return stack.size();
    }
    
    public static void main(String[] args) {
        Q29_StacksfromQueues stack = new Q29_StacksfromQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size()); // 3
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
    }
}
