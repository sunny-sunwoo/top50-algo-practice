package top50_questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Q26. Smallest Change
 * Given an input amount of change x, 
 * write a function to determine the minimum number of coins required to make that amount of change.
 * 
 * [Approach1] dp
 * [Approach2] recursion
 * @author Sunny Park
 *
 */
public class Q26_SmallestChange {
    public static int smallestChange_topDown(int[] coins, int amount) {
        return smallestChange(new HashMap<Integer, Integer>(), coins, amount);
    }
    
    private static int smallestChange(Map<Integer, Integer> memo, int[] coins, int amount) {
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) return memo.get(amount);
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;
            int curr = smallestChange(memo, coins, amount - coin);
            if (curr < min) {
                min = curr;
            }
        }
        
        min = min == Integer.MAX_VALUE ? min : min + 1;
        memo.put(amount, min);
        return min;
    }
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(smallestChange_topDown(coins, amount));
    }
}
