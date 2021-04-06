public class P88_mergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int cur;
            int tail = m + n - 1;
            while(p1 >= 0 || p2 >= 0) {
                if(p1 == -1) {
                    cur = nums2[p2--];
                } else if (p2 == -1) {
                    cur = nums1[p1--];
                } else if (nums1[p1] > nums2[p2]) {
                    cur = nums1[p1--];
                } else {
                    cur = nums2[p2--];
                }
                nums1[tail--] = cur;
            }
        }
    }

//法二 提前结束，当第二个数组全部放入数组一时，提前结束
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int tail = m + n - 1;
            while(p1 >= 0 || p2 >= 0) {
                if(p2 == -1) {
                    return;
                } else if(p1 == -1) {
                    nums1[tail--] = nums2[p2--];
                } else if (nums1[p1] > nums2[p2]) {
                    nums1[tail--] = nums1[p1--];
                } else {
                    nums1[tail--] = nums2[p2--];
                }
            }
        }
}

