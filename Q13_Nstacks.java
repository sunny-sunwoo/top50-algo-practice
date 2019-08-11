package top50_questions;

import java.util.Arrays;

/**
 * Question: Implement N > 0 stacks using a single array to store all stack data
(you may use auxiliary arrays in your stack object, but all of the objects 
in all of the stacks must be in the same array). No stack should be full 
unless the entire array is full.

    e.g.  
    N = 3;
    capacity = 10;
    Stacks stacks = new Stacks(N, capacity);
    stacks.put(0, 10);
    stacks.put(2, 11);
    stacks.pop(0) = 10;
    stacks.pop(2) = 11;

 * [Approach] 
 * 1. set instance fields
 *  int[] topOfStack - keep top idx of each stack
 *  int[] stackData - values in the stack
 *  int[] nextIndex - to keep next index (for put method) OR prev index (for pop method)
 *  int nextAvailable - to mark next index
 *  
 * [Note]
 * 1) N = 1
 *    use 1 pointer to mark stack top.
 *    
 * 2) N = 2
 *     i.  split by half -> would waste empty space.
 *     ii. place pointers at both ends.
 *     
 * 3) N = 3+
 *    need to keep track of next available idx(to put OR to revert when popping) 
 *    using 1 variable and 1 array
 *    
 *    1 array of length n. to keep top's idx for each stack.
 *    
 *    1 array of length capacity. to keep real data.
 * 
 * @author Sunny Park
 *
 */
public class Q13_Nstacks {
    int[] topOfStack;
    int[] stackData;
    int[] nextIndex;
    int nextAvailable;
    
    public Q13_Nstacks(int n, int capacity) {
        this.topOfStack = new int[n];
        Arrays.fill(topOfStack, -1);
        this.stackData = new int[capacity];
        this.nextIndex = new int[capacity];
        initNextIndex();
        this.nextAvailable = 0;
    }
    
    private void initNextIndex() {
        for (int i = 0; i < nextIndex.length - 1; i++) {
            nextIndex[i] = i + 1;
        }
        nextIndex[nextIndex.length - 1] = -1;
    }
    
    public void put(int n, int val) {
        int idx = nextAvailable;
        nextAvailable = nextIndex[idx];
        stackData[idx] = val;
        nextIndex[idx] = topOfStack[n];
        topOfStack[n] = idx;
        printStatus();
    }
    
    public int pop(int n) {
        int idx = topOfStack[n];
        int toReturn = stackData[idx];
        topOfStack[n] = nextIndex[idx]; 
        nextIndex[idx] = nextAvailable;
        nextAvailable = idx;
        printStatus();
        return toReturn;
    }
    
    private void printStatus() {
        System.out.println("///////");
        System.out.println(Arrays.toString(topOfStack));
        System.out.println(Arrays.toString(stackData));
        System.out.println(Arrays.toString(nextIndex));
        System.out.println(nextAvailable);
    }
    
    public static void main(String[] args) {
        Q13_Nstacks stack = new Q13_Nstacks(3, 6);
        stack.put(0, 5);
        stack.put(0, 6);
        stack.put(2, 7);
        System.out.println("POP: " + stack.pop(0));
        stack.put(1, 8);
        System.out.println("POP: " + stack.pop(1));
        stack.put(1, 9);
        stack.put(1, 10);
        System.out.println("POP: " + stack.pop(1));
    }
}
