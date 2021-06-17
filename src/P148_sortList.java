public class P148_sortList {
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
    /**
     * recursion method
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode newHead;
            head.next = sortList(head.next);
            if(head.val < head.next.val) {
                return head;
            } else {
                newHead = head.next;
                ListNode next = newHead;
                head.next = null;
                int val = head.val;
                while(next.next != null && next.next.val < val) {
                    next = next.next;
                }
                ListNode temp = next.next;
                next.next = head;
                head.next = temp;
                return newHead;
            }
        }
    }
}
