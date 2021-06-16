public class P442_findAllDuplicatesInAnArray {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++) {
                if(set.contains(nums[i])) {
                    list.add(nums[i]);
                    continue;
                }
                set.add(nums[i]);
            }
            return list;
        }
    }

    class Solution2 {
        public List<Integer> findDuplicates(int[] nums) {
            int n = nums.length;
            for(int num: nums) {
                int x = (num-1) % n;
                nums[x] += n;
            }
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(nums[i] > 2 * n) {
                    list.add(i+1);
                }
            }
            return list;
        }
    }
}
