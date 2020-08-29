import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class P1_twoSum {
    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public  int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no result");
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        for (int j = 0; j < nums.length; j++ ) {
            int complement = target - nums[j];
            if(map.containsKey(complement) && map.get(complement) != j) {
                return new int[]{j,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No result");
    }




    @Test
    public void test(){
        int[] test = new int[]{1,2,7,9};
        assertEquals(new int[]{1,2}, twoSum1(test,9));
    }
}
