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
}
