public class P162_findPeakElemeny {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode head1 = headA;
            ListNode head2 = headB;
            while(head1 != head2) {
                if(head1 != null) {
                    head1 = head1.next;
                } else {
                    head1 = headB;
                }
                if(head2 != null) {
                    head2 = head2.next;
                } else {
                    head2 = headA;
                }
            }
            return head1;
        }
    }

    class Solution2 {
        public int findPeakElement(int[] nums) {
            int n = nums.length;
            return helper(nums, 0, n-1);
        }
        private int helper(int[] nums, int l, int r) {
            if(l == r) return l;
            int mid = (l+r)/2;
            if(nums[mid] > nums[mid+1]) return helper(nums, l, mid);
            return helper(nums, mid+1, r);
        }
    }
}
