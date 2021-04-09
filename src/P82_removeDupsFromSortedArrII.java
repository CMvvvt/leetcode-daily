public class P82_removeDupsFromSortedArrII {
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
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) return null;
            ListNode p = new ListNode(0, head);
            ListNode q = p;
            while(q.next != null && q.next.next != null) {
                if(q.next.val == q.next.next.val) {
                    int x = q.next.val;
                    while(q.next !=  null && q.next.val == x) {
                        q.next = q.next.next;
                    }
                } else {
                    q = q.next;
                }
            }
            return p.next;
        }
    }
}
