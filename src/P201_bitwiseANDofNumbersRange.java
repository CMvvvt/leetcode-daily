public class P201_bitwiseANDofNumbersRange {
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            int shift = 0;
            while(left < right) {
                right >>= 1;
                left >>= 1;
                shift++;
            }
            return left << shift;
        }
    }

    /**
     * Brian Kernighan algorithm added.
     * n & (n-1) would remove the last '1' of the integer, utill integer right <= integer left, then we have pre-string
     * in common and all filled 0s at the right of integer right.
     */
    class Solution2 {
        public int rangeBitwiseAnd(int left, int right) {
            while(left < right) {
                right &= right-1;
            }
            return right;
        }
    }
}
