public class P1818_minAbsSumDIff {
    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            final int MOD = 1000000007;
            int n = nums1.length;
            int[] arr = new int[n];
            System.arraycopy(nums1, 0, arr, 0, n);
            Arrays.sort(arr);
            int sum = 0;
            int max = 0;
            for(int i = 0; i < n; i++) {
                int diff = Math.abs(nums1[i] - nums2[i]);
                sum = (sum + diff) % MOD;
                int j = binarySearch(arr, nums2[i]);
                if(j < n) {
                    max = Math.max(max, diff - (arr[j] - nums2[i]));
                }
                if(j > 0) {
                    max = Math.max(max, diff - (nums2[i] - arr[j-1]));
                }
            }
            return (sum - max + MOD) % MOD;
        }

        private int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            if(arr[high] < target) {
                return high + 1;
            }
            while(low < high) {
                int mid = (high-low) / 2 + low;
                if(arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;

        }
    }
}
