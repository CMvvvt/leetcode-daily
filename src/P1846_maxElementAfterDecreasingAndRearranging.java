public class P1846_maxElementAfterDecreasingAndRearranging {
    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            Arrays.sort(arr);
            arr[0] = 1;
            for(int i = 1; i < arr.length; i++) {
                if(Math.abs(arr[i] - arr[i-1]) > 1) {
                    arr[i] = arr[i-1] + 1;
                }
            }
            return arr[arr.length-1];
        }
    }


    /**
     *  O(n) method added
     */
    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            int n = arr.length;
            int[] cnt = new int[n+1];
            for(int v: arr) {
                cnt[Math.min(v, n)]++;
            }
            int miss = 0;
            for(int i = 1; i <= n; i++) {
                if(cnt[i] == 0) {
                    miss++;
                } else {
                    miss -= Math.min(cnt[i]-1, miss);
                }
            }
            return n - miss;
        }
    }
}
