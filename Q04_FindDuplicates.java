package top50_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q. Given an array of integers where each value 1<= x <= len(array),
 * write a function that finds all the duplicates in the array.
 * 
 * dups([1,2,3]) = []
 * dups([1,2,2]) = [2]
 * dups([2,1,2,1]) = [1,2]
 * 
 * @author Sunny Park
 *
 */
public class Q04_FindDuplicates {
    public static int[] findDuplicates(int[] nums) {
        int[] freqArr = new int[nums.length];
        for (int n : nums) {
            freqArr[n - 1]++;
        }
        
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        for (int f : freqArr) {
            if (f > 1) result.add(idx + 1);
            idx++;
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public static void main(String[] args) {
        int[] nums = {3,3,3};
        System.out.print(Arrays.toString(findDuplicates(nums)));
    }
}
