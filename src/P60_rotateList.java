public class P60_rotateList {
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
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null) {
                return null;
            }
            int len = 1;
            ListNode pointer = head;
            while(pointer.next != null) {
                pointer = pointer.next;
                len++;
            }
            int kk = k % len;
            if(kk == 0) {
                return head;
            }
            int flag = 0;
            ListNode newHead = head;
            ListNode res = head;
            while(newHead != null) {
                if(flag == len - kk - 1) {
                    res = newHead.next;
                    newHead.next = null;
                }
                newHead = newHead.next;
                flag++;
            }
            pointer.next = head;
            return res;
        }
    }


    /**
     * second time
     */
    class Solution3 {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null || head.next == null) return head;
            int n = 0;
            ListNode node = head;
            while(node != null) {
                node = node.next;
                n++;
            }
            k = k % n;
            if(k == 0) return head;
            ListNode slow = head, fast = head;
            for(int i = 0; i < k; i++) fast = fast.next;
            while(fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            ListNode newHead = slow.next;
            slow.next = null;
            fast.next = head;
            return newHead;
        }
    }
}
