public class P1710_findMajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int candidate = -1;
            int count = 0;
            for(int num: nums) {
                if(count == 0) {
                    candidate = num;
                }
                if(candidate == num) {
                    count++;
                }
                if(candidate != num) {
                    count--;
                }
            }
            count = 0;
            for(int num: nums) {
                if(candidate == num) {
                    count++;
                }
            }
            return count*2 > nums.length? candidate: -1;
        }
    }
}
