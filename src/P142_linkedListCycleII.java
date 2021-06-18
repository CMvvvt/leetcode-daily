public class P142_linkedListCycleII {
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
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null) return null;
            Set<ListNode> set = new HashSet<>();
            while(head != null) {
                if(!set.contains(head)) {
                    set.add(head);
                    head = head.next;
                } else {
                    return head;
                }
            }
            return null;
        }
    }

    /**
     * method 2 added
     */
    public class Solution2 {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while(true) {
                if(fast == null || fast.next == null) return null;
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast) {
                    break;
                }
            }
            while(head != slow) {
                head = head.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
