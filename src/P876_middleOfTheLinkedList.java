public class P876_middleOfTheLinkedList {
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
        public ListNode middleNode(ListNode head) {
            if(head.next == null) return head;
            ListNode slow = head, fast = head;
            while(fast.next != null) {
                if(fast.next.next == null) {
                    slow = slow.next;
                    break;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
