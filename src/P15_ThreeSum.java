import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output_arr = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int target = 0 - nums[i];
                while(low < high) {
                    if(nums[low] + nums[high] == target) {
                        output_arr.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while (low < high && nums[low] == nums[low+1]){low++;}
                        while (low < high && nums[high] == nums[high-1]){high--;}
                        low++;
                        high--;
                    } else if(nums[low] + nums[high] < target) {
                        low++;
                    } else{
                        high--;
                    }
                }
            }
        }
        return output_arr;
    }
}
