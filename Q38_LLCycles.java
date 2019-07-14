package top50_questions;

/**
 *           x
 *          / \
 * x - x - x   x <- meeting point.
 *          \ /
 *           x
 * 
 * slow: x + y (before meeting point)
 * fast: x + y + z + y
 * 
 * if there is cycle.
 * 2 * (x + y) = x + 2y + z
 * 
 * x = z. 
 * 
 * @author Sunny Park
 *
 */
public class Q38_LLCycles {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    private static class ListNode {
        ListNode next;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        ListNode n3 = new ListNode();
        ListNode n4 = new ListNode();
        ListNode n5 = new ListNode();
        ListNode n6 = new ListNode();
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        
        System.out.println(hasCycle(n1));
        
    }
}
