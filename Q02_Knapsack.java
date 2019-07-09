package top50_questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: Given a list of items with values and weights, as well as a max weight,
 * find the maximum value you can generate from items where the sum of the 
 * weights is less than the max.
 * 
 * [Approach1] Recursion
 * sol1) brute force
 * - find all combinations of Item
 * - filter out overweight items
 * - find max value combination.
 * 
 * sol2) apply the constraints
 * - find combinations within the maxWeight
 * 
 * sol3) keep only one result
 * - keep the combination only if new value is greater than curr result value.
 * 
 * sol4) avoid recomputing
 * - By creating Result class(with List<Item> result, int maxValue), 
 *   avoid recomputing of values.
 *   
 * [Approach2] DP 
 * - if w >= wi, dp[i][j] = max(dp[i-1][w], dp[i - 1][w - wi] + vi)
 *   -> don't pick or pick curr item.
 *   
 *   otherwise, dp[i][j] = dp[i-1][w].
 *   -> can't pick curr item anyway.
 *   
 * [Time/Space Analysis]
 * time & space: O(maxWeight * item number) => Pseudo-polynomial 
 * @author Sunny Park
 *
 */
public class Q02_Knapsack {
    private static class Item {
        private final int weight;
        private final int value;
        private final int id;
        private static int number;
        
        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.id = number;
            number++;
        }
        
        @Override
        public String toString() {
            return "Item" + String.valueOf(id) + "(w" + weight + "-v" + value + ")";
        }
    }
    
    public static int knapsack_dp(Item[] items, int maxWeight) {
        int[][] dp = new int[items.length + 1][maxWeight + 1];
        for (int i = 1; i <= items.length; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                Item currItem = items[i - 1];
                dp[i][w] = Math.max(dp[i - 1][w], (currItem.weight > w)? 0 
                        : (dp[i - 1][w - currItem.weight] + currItem.value));
            }
        }
        return dp[items.length][maxWeight];
    }
    
    public static int knapsack_recursion(Item[] items, int maxWeight) {
        Result result = new Result();
        knapsack(result, new ArrayList<>(), items, maxWeight, 0, 0, 0);
        return result.maxValue;
    }
    
    private static void knapsack(Result result, List<Item> tmp, Item[] items, int maxWeight, int currWeight, int currValue, int ptr) {
        if (currWeight > maxWeight) return;
        if (ptr == items.length) {
            if (result.maxValue < currValue) {
                result.result = new ArrayList<>(tmp);
                result.maxValue = currValue;
            }
            return;
        }
        
        tmp.add(items[ptr]);
        knapsack(result, tmp, items, maxWeight, currWeight + items[ptr].weight, currValue + items[ptr].value, ptr + 1);
        tmp.remove(tmp.size() - 1);
        knapsack(result, tmp, items, maxWeight, currWeight, currValue, ptr + 1);
        
    }
    
    private static class Result {
        List<Item> result;
        int maxValue;
        
        Result() {
            result = new ArrayList<>();
            maxValue = 0;
        }
    }
    
    public static void main(String[] args) {
        Item[] input = {new Item(5, 2), new Item(3, 7), new Item(2, 5), new Item(6, 3)};
        System.out.println(knapsack_dp(input, 6));
        System.out.println(knapsack_recursion(input, 6)); // pick input[1], input[2]
    }
    
}
