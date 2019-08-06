package top50_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Question: Given an array, write a function to find any subarray 
 * that sums to zero, if one exists.
 * 
 * e.g.
 * zeroSum({1, 2, ‐5, 1, 2, ‐1}) = [2, ‐5, 1, 2]
 * 
 * [Approach] when is zerosum?
 * 
 * 1, 2, -5,  1,  2, -1
 * 0, 1,  3, -2, -1,  1, 0 
 *    ^               ^
 * => when same sum appears, 
 *    that means the range sum is ZERO!
 * 
 * => linear scan while filling the hashmap(sum -> index)
 * 
 * @author Sunny Park
 *
 */
public class Q11_ZeroSumSubarray {
    public static int[] zeroSumSubarray(int[] input) {
        Map<Integer, Integer> cache = new HashMap<>();
        int sum = 0;
        for (int i = 0; i <= input.length; i++) { // NOTE! index range!
            Integer oldIndex = cache.get(sum);
            if (oldIndex == null && i == input.length) { 
                return null;
            } 
            
            if (oldIndex == null) {
                cache.put(sum, i);
                sum += input[i];
                continue;
            }
            return Arrays.copyOfRange(input, oldIndex, i);
        }
        return null;
    }
    
    public static void main(String[] args) {
        int[] input = {1, 2, -5, 1, 2};
        System.out.print(Arrays.toString(zeroSumSubarray(input)));
    }
}
