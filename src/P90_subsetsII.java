public class P90_subsetsII {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Arrays.sort(nums);
            for(int i = 0; i <= nums.length; i++) {
                dfs(nums, i, 0, path, res);
            }
            return res;
        }

        private void dfs(int[] nums, int k, int begin, List<Integer> path, List<List<Integer>> res) {
            if(path.size() == k) {
                res.add(new ArrayList(path));
                return;
            }
            for(int j = begin; j < nums.length; j++) {
                if(j > begin && nums[j] == nums[j-1]) continue;
                path.add(nums[j]);
                dfs(nums, k, j+1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
