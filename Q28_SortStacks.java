package top50_questions;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Stack;

/**
 * Question: Given a stack, sort the elements in the stack using one additional stack.
 * 
 * [Approach] utilize the space of input stack to keep smaller numbers.
 * 
 *              temp = 3
 *  1
 *  2
 *  4       3
 *  -       -
 * input    newStack
 * 
 * 1. create a new stack and push 1 elem from input.
 * 2. while input is not empty
 *    -> temp = popped number from input
 *    -> while newStack is not empty AND temp > peeked number from newStack.
 *       keep newStack's top in the input stack.
 *    -> push temp to the newStack. (placed in sorted order)
 * 
 * @author Sunny Park
 *
 */
public class Q28_SortStacks {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        checkArgument(!checkNotNull(input).isEmpty());
        Stack<Integer> newStack = new Stack<>();
        newStack.push(input.pop());
        while (!input.isEmpty()) {
            int tmp = input.pop();
            while (!newStack.isEmpty() && tmp > newStack.peek()) {
                input.push(newStack.pop());
            }
            newStack.push(tmp);
        }
        return newStack;
    }
    
    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(4);
        input.push(2);
        input.push(3);
        input.push(1);
        input.push(5);
        
        System.out.println(input);
        System.out.println(sortStack(input));
    }
}
