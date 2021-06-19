public class P108_convertSortedArrToBST {
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length-1);
        }
        private TreeNode helper(int[] nums, int start, int end) {
            if(start > end) return null;
            int mid = start + (end-start)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, start, mid - 1);
            root.right = helper(nums, mid + 1, end);
            return root;
        }
    }


    class Solution2 {
        public TreeNode sortedArrayToBST(int[] nums) {
            int n = nums.length - 1;
            TreeNode root = binary(nums, 0, n);
            return root;
        }

        private TreeNode binary(int[] nums, int left, int right) {
            if(left > right) {return null;}
            int mid = left + (right-left)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = binary(nums, left, mid-1);
            node.right = binary(nums, mid+1, right);
            return node;
        }
    }
}
