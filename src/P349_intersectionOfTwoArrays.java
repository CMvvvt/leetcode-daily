public class P349_intersectionOfTwoArrays {
    /**
     *  set method
     */
    class Solution1 {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for(int num: nums1) {
                set1.add(num);
            }
            for(int num: nums2) {
                set2.add(num);
            }
            return intersect(set1, set2);
        }

        private int[] intersect(Set<Integer> set1, Set<Integer> set2) {
            if(set2.size() < set1.size()) return intersect(set2, set1);
            Set<Integer> interSet = new HashSet<>();
            for(int num: set1) {
                if(set2.contains(num)) {
                    interSet.add(num);
                }
            }
            int[] res = new int[interSet.size()];
            int index = 0;
            for(int num: interSet) {
                res[index++] = num;
            }
            return res;
        }
    }


    /**
     * double pointer method added
     *
     */
    class Solution2 {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            Set<Integer> set = new HashSet<>();
            int i = 0, j = 0;
            while(i < nums1.length && j < nums2.length) {
                if(nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
                if(nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            int[] res = new int[set.size()];
            int index = 0;
            for(int num: set) {
                res[index++] = num;
            }
            return res;
        }
    }
}
