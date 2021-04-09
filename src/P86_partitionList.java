public class P86_partitionList {
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
        public ListNode partition(ListNode head, int x) {
            if(head == null || head.next==null) return head;
            ListNode small = new ListNode(0, head);
            ListNode large = new ListNode(0, head);
            ListNode smallHead = small;
            ListNode largeHead = large;
            while(head != null) {
                if(head.val < x) {
                    smallHead.next = head;
                    smallHead = smallHead.next;
                } else {
                    largeHead.next = head;
                    largeHead = largeHead.next;
                }
                head = head.next;
            }
            largeHead.next = null;
            smallHead.next = large.next;
            return small.next;
        }
    }


}
