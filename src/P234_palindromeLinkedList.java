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
}
