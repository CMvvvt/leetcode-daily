import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class P38_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res  = new ArrayList();
        if(len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }

    @Test
    public void test(){
        List<List<Integer>> res = new ArrayList<>();
        int[] test = new int[]{2,3,6,7};
        List<Integer> obj1 = Arrays.asList(2,2,3);
        List<Integer> obj2 = Arrays.asList(7);
        res.add(obj1);
        res.add(obj2);
        assertEquals(res,combinationSum(test,7));
    }
}
