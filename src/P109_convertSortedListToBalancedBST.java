public class P109_convertSortedListToBalancedBST {
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
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null) return null;
            int n = 0;
            ListNode dummy = head;
            while(dummy != null) {
                dummy = dummy.next;
                n++;
            }
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = head.val;
                head = head.next;
            }
            return helper(nums, 0, n-1);
        }

        private TreeNode helper(int[] nums, int start, int end) {
            if(start > end) return null;
            int mid = start + (end-start)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, start, mid-1);
            root.right = helper(nums, mid+1, end);
            return root;
        }
    }

    class Solution2 {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null) return null;
            return helper(head, null);
        }
        private TreeNode helper(ListNode head, ListNode tail) {
            if(head == tail) return null;
            ListNode fast = head;
            ListNode slow = head;
            while(fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            TreeNode root = new TreeNode(slow.val);
            root.left = helper(head, slow);
            root.right = helper(slow.next, tail);
            return root;
        }
    }
}
