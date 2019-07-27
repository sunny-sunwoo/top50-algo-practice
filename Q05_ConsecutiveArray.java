package top50_questions;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Q. Given an unsorted array, find the length of the longest sequence of consecutive numbers in the array.
 * 
 * e.g. 
 * consecutive([4,2,1,6,5]) = 3 (4,5,6)
 * consecutive([5,5,3,1]) = 1 (1 or 3 or 5)
 * 
 * [Approach] create a set. remove while checking.
 * 1. create a set.
 * 2. while checking from curr n to the left OR to the right, increment cnt by 1
 * 3. keep maxcnt only.
 * 
 * @author Sunny Park
 *
 */
public class Q05_ConsecutiveArray {
    public static int consecutiveArray(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxCnt = 1;
        for (int n : nums) {
            if (!set.contains(n)) continue;
            
            int left = n - 1, right = n + 1;
            int cnt = 1;
            while (set.contains(left)) {
                cnt++;
                set.remove(left--);
            }
            
            while (set.contains(right)) {
                cnt++;
                set.remove(right++);
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
    
    public static void main(String[] args) {
        int[] nums = {4,2,1,6,5};
//        int[] nums = {5,5,3,1};
        System.out.println(consecutiveArray(nums));
    }
}
