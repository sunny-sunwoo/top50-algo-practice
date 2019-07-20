package top50_questions;

/**
 * Question: Given two strings, write a function that returns the longest common substring.
 * e.g. longestSubstring("ABAB", "BABA") = "ABA"
 * 
 * @author Sunny Park
 *
 */
public class Q47_LongestCommonSubstring {
    public static String lcs(String s1, String s2) {
        int i = 0, j = 0;
        String s = "";
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                s += s1.charAt(i);
                i++;
                j++;
            } else {
                if (s1.length() >= s2.length()) i++;
                else j++;
            }
        }
        return s;
    }
    
    public static void main(String[] args) { 
        System.out.println(lcs("AB", "BABA"));
        System.out.println(lcs("ABAB", "BABA"));
        System.out.println(lcs("ABABAAAAAAAAA", "BABAAAAA"));
    }
}
