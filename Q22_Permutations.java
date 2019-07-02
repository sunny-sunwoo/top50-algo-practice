package top50_questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Q. Write a function that returns all permutations of a given list.
 * permutations({1, 2, 3})
 * [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 1, 2]
 * [3, 2, 1]
 * 
 * [Approach] Backtracking
 *  - base case: the tmp size equals to the nums.
 * 
 *  - iterate though the array
 *  - check if the curr was contained. -> continue
 *  - else -> add.
 * 
 * @author Sunny Park
 * 
 */

public class Q22_Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<>(), nums);
        return result;
    }
    
    private static void permute(List<List<Integer>> result, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int num : nums) {
            if (tmp.contains(num)) continue;
            tmp.add(num);
            permute(result, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(permute(nums));
    }
}
