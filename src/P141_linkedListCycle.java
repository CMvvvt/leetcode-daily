public class P141_linkedListCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null) return false;
            while(head != null) {
                if(head.val == Integer.MAX_VALUE) {
                    return true;
                }
                head.val = Integer.MAX_VALUE;
                head = head.next;
            }
            return false;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null) return false;
            ListNode slow = head;
            ListNode fast = head.next;
            while(slow != fast) {
                if(fast == null || fast.next == null) return false;
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
