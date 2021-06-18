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

    /**
     * merge sort method added.
     * form top to bottom
     */
    class Solution2 {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode mid = getMid(head);
            ListNode l1 = head;
            ListNode l2 = mid.next;
            mid.next = null;
            l1 = sortList(l1);
            l2 = sortList(l2);
            return mergeList(l1, l2);
        }
        private ListNode getMid(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode slow = head, fast = head;
            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        private ListNode mergeList(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode prev = dummyHead;
            while(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            prev.next = l1 == null ? l2: l1;
            return dummyHead.next;
        }
    }
}
