public class P189_rotateArray {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            int[] newArray = new int[n];
            for(int i = 0; i < n; i++) {
                newArray[(i+k)%n] = nums[i];
            }
            System.arraycopy(newArray, 0, nums, 0, n);
            return;
        }
    }
    class Solution2 {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            int count = gcd(n,k);
            for(int i = 0; i < count; i++) {
                int prev = nums[i];
                int curr = i;
                do {
                    int next = (curr+k) % n;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    curr = next;
                } while(curr != i);
            }
            return;
        }

        private int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }
    }
    class Solution3 {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            int count = 0;
            for(int i = 0; i < k && count < n; i++) {
                int prev = nums[i];
                int curr = i;
                do {
                    int next = (curr+k) % n;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    curr = next;
                    count++;
                } while(curr != i);
            }
            return;
        }
    }
}
