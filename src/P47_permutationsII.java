import java.util.*;

public class P47_permutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs(len, 0, nums, path, res, used);
        return res;
    }

    private void dfs(int len, int depth, int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        if(depth == len) {
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < len; i++) {
            if(i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            if(used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(len, depth + 1, nums, path, res, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
