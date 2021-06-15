public class P852_peakIndexInMountain {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int len = arr.length;
            int low = 0, high = len - 1;
            while(low <= high) {
                int mid = low + (high - low)/2;
                if(arr[mid] > arr[mid+1]) {
                    high = mid;
                    if(arr[mid] > arr[mid-1]) {
                        return mid;
                    }
                } else {
                    low = mid;
                }
            }
            return low;
        }
    }
}
