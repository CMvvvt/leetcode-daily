public class P137_singleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            Set<Long> set = new HashSet<>();
            long setSum = 0, arraySum = 0;
            for(int n: nums) {
                arraySum += n;
                set.add((long)n);
            }
            for(long n: set) {
                setSum += n;
            }
            return (int)( (3 * setSum - arraySum) / 2);
        }
    }
}
