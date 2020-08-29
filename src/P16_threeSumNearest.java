import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class P16_threeSumNearest {
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++){
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if(Math.abs(target-sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if(sum > target){
                    high--;
                } else if(sum < target) {
                    low++;
                } else{
                    return ans;
                }
            }
        }
        return ans;
    }
}
