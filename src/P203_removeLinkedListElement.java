public class P203_removeLinkedListElement {
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
        public ListNode removeElements(ListNode head, int val) {
            if(head == null) return null;
            ListNode dummy = head;
            while(dummy.next != null) {
                if(dummy.next.val == val) {
                    dummy.next = dummy.next.next;
                    continue;
                }
                dummy = dummy.next;
            }
            if(head.val == val) return head.next;
            return head;
        }
    }
}
