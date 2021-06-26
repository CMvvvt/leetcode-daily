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

    /**
     * two pointer method
     */
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            HashSet<List<Integer>> set = new HashSet<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 2; i++) {
                int left = i + 1, right = nums.length - 1;
                int target = 0 - nums[i];
                while(left < right) {
                    if(nums[left] + nums[right] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left++]);
                        list.add(nums[right--]);
                        set.add(list);
                        continue;
                    }
                    if(nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            res = new ArrayList<>(set);
            return res;
        }
    }


    /**
     * two pointers optimal
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
                if(i == 0 || nums[i] != nums[i-1]) {
                    twoSum(nums, i, res);
                }
            }
            return res;
        }

        private void twoSum(int[] nums, int i, List<List<Integer>> res) {
            int left = i + 1, right = nums.length -1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}
