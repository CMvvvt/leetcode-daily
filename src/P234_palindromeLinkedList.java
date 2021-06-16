public class P234_palindromeLinkedList {
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
        public boolean isPalindrome(ListNode head) {
            int n = 0;
            ListNode dummy = head;
            while(dummy != null) {
                dummy = dummy.next;
                n++;
            }
            if(n == 1) return true;
            int mid = n / 2;
            Stack<Integer> stack = new Stack<>();
            for(int i = mid; i > 0; i--) {
                stack.push(head.val);
                head = head.next;
            }
            if(n % 2 != 0) {
                head = head.next;
            }
            while(head != null) {
                int val = head.val;
                if(val != stack.pop()) return false;
                head = head.next;
            }
            return true;
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
    class Solution2 {
        public boolean isPalindrome(ListNode head) {
            ListNode mid = getMid(head);
            ListNode reverseHead = reverse(mid.next);
            ListNode p1 = head, p2 = reverseHead;
            boolean result = true;
            while(result && p2 != null) {
                if(p1.val != p2.val) {
                    result = false;
                    break;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
            mid.next = reverse(reverseHead);
            return result;
        }
        private ListNode getMid(ListNode head) {
            ListNode slow = head, fast = head;
            while(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
        private ListNode reverse(ListNode head) {
            if(head == null || head.next == null) return head;
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
