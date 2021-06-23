public class 剑指15_numsOf1InBinary {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            for(int i = 0; i < 32; i++) {
                if((n & (1 << i)) != 0) {
                    count++;
                }
            }
            return count;
        }
    }
}
