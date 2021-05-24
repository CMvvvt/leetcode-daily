public class P147_insertionSOrtList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if(head == null) return head;
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode lastSorted = head;
            ListNode curr = head.next;
            while(curr != null) {
                if(lastSorted.val <= curr.val) {
                    lastSorted = curr;
                } else {
                    ListNode prev = dummy;
                    while(prev.next.val <= curr.val) {
                        prev = prev.next;
                    }
                    lastSorted.next = curr.next;
                    curr.next = prev.next;
                    prev.next = curr;
                }
                curr = lastSorted.next;
            }
            return dummy.next;
        }
    }
}
