package top50_questions;

/**
 * Q.  Given an n x m array where all rows and columns are in sorted order, 
 * write a function to determine whether the array contains an element x.
 * 
 * [Approach] Binary search
 * while searching, calculate row #, col # to check the 2d arr grid.
 * => proceed with lo, hi, mid.
 * => convert mid into the index every time.
 * @author Sunny Park
 *
 */
public class Q09_MatrixSearch {
    public static boolean binarySearch(int[][] grid, int k) {
        int len =  grid[0].length;
        int lo = 0, hi = grid.length * len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int currRow = mid / len;
            int currCol = mid % len;
            // System.out.println(hi + " " + lo + " " + mid + " : " + currRow + ", " +  currCol);
            if (grid[currRow][currCol] == k) {
                // System.out.println(currRow + ", " +  currCol);
                return true;
            } 
            if (grid[currRow][currCol] < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4}, {5,6,7,8}, {9,10,13,15}};
        System.out.println(binarySearch(grid, 15));
    }
}
