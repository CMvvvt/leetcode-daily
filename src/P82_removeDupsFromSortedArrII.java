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
    class Solution1 {
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

//    递归解法
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
    class Solution2 {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null) return head;
            if(head.val != head.next.val) {
                head.next = deleteDuplicates(head.next);
            } else {
                ListNode end = head;
                while(end != null && end.val == head.val) {
                    end = end.next;
                }
                return deleteDuplicates(end);
            }
            return head;
        }
    }
}
