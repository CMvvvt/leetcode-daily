import  java.util.ArrayList;
import  java.util.List;

public class P49_permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList();
        if(len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList();
        dfs(nums, len, 0, path, res, used);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, List<List<Integer>> res, boolean[] used ) {
        if(depth == len) {
            res.add(new ArrayList(path));
        }
        for(int i = 0; i < len; i++) {
            if(!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, len, depth + 1, path, res, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}

