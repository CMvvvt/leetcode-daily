public class P202_happyNumber {
    class Solution {
        public boolean isHappy(int n) {
            int slow = n, fast = getNext(n);
            while(slow != fast) {
                slow = getNext(slow);
                fast = getNext(getNext(fast));
            }
            return slow == 1;
        }
        private int getNext(int n) {
            int sum = 0;
            while(n > 0) {
                int remainder = n % 10;
                sum += remainder*remainder;
                n /= 10;
            }
            return sum;
        }
    }
}
