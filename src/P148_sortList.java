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
    class Solution5 {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) return head;
            int n = 0;
            ListNode node = head;
            while(node != null) {
                n++;
                node = node.next;
            }
            ListNode dummyHead = new ListNode(-1, head);
            for(int subLength = 1; subLength < n; subLength <<= 1) {
                ListNode prev = dummyHead, curr = dummyHead.next;
                while(curr != null) {
                    ListNode head1 = curr;
                    for(int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for(int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if(curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }
                    ListNode merged = merge(head1, head2);
                    prev.next = merged;
                    while(prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummyHead.next;
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            if(l1.val <= l2.val) {
                l1.next = merge(l1.next, l2);
                return l1;
            }
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
