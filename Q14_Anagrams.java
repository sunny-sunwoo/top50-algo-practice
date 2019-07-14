package top50_questions;

public class Q14_Anagrams {
    public static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        if (a.length() == 0 || b.length() == 0) {
            return a.length() == 0 && b.length() == 0;
        }
        
        if (a.length() != b.length()) {
            return false;
        }
        
        int[] counter = new int[26];
        // Sol1) iterate over 2 strs, then check arr.
//        for (int i = 0; i < a.length(); i++) {
//            counter[a.charAt(i) - 'a']++;
//            counter[b.charAt(i) - 'a']--;
//        }
//
//        for (int i = 0; i < counter.length; i++) {
//            if (counter[i] != 0) {
//                return false;
//            }
//        }
        
        // Sol2) build counter arr with a string a.
        for (int i = 0; i < a.length(); i++) {
            counter[a.charAt(i) - 'a']++;
        }
        
        for (int j = 0; j < b.length(); j++) {
            int idx = b.charAt(j) - 'a';
            counter[idx]--;
            if (counter[idx] < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isAnagram("AB", "abc"));
    }
}
