public class P92_reverseLinkedListII {
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(left == right) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            for(int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode rightHead = pre.next;
            for(int i = 0; i < right-left; i++) {
                rightHead = rightHead.next;
            }
            ListNode middleHead = pre.next;
            ListNode end = rightHead.next;

            pre.next = null;
            rightHead.next = null;
            pre.next = reverse(middleHead);
            middleHead.next = end;
            return dummy.next;
        }
        private ListNode reverse(ListNode head) {
            ListNode p = null;
            while(head != null) {
                ListNode next = head.next;
                head.next = p;
                p = head;
                head = next;
            }
            return p;
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
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head.next == null) return head;
            ListNode beforeStart = new ListNode();
            beforeStart.next = head;
            ListNode dummy = head;
            int flag = left;
            while(right > 1) {
                left--;
                right--;
                if(left == 1) {
                    beforeStart = dummy;
                }
                dummy = dummy.next;
            }
            ListNode start = beforeStart.next;
            ListNode beforeEnd = dummy;
            ListNode end = beforeEnd.next;
            beforeEnd.next = null;
            beforeStart.next = reverse(start);
            start.next = end;
            return flag == 1? beforeEnd: head;
        }
        private ListNode reverse(ListNode head) {
            if(head == null) return head;
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
