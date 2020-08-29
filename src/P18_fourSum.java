import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P18_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output_arr = new LinkedList<>();
        Arrays.sort(nums);

        if(nums == null || nums.length < 4) {
            return output_arr;
        }
        for(int i = 0; i < nums.length - 3; i++) {
            if(i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
                for(int j = i + 1; j < nums.length - 2; j++) {
                    if(j == i + 1 ||( j > i + 1 && nums[j] != nums[j-1])) {
                        int low = j + 1;
                        int high = nums.length - 1;
                        int sum = target - nums[i] - nums[j];
                        while (low < high) {
                            if(nums[low] + nums[high] == sum) {
                                output_arr.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while(low < high && nums[low] ==nums[low+1]){
                                    low++;
                                }
                                while(low < high && nums[high] == nums[high-1]){
                                    high--;
                                }
                                low++;
                                high--;
                            } else if(nums[low] + nums[high] < sum){
                                low++;
                            } else{
                                high--;
                            }
                        }
                    }
                }
            }
        }
        return output_arr;
    }
}
