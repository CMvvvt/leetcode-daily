import java.util.Map;

public class P26_removeDuplicates {
    public int removeDuplicates(int[] nums){
        if(nums.length == 0) {
            return 0;
        }
        int res = -1;
        int point = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0) {
                res++;
                continue;
            }
            if(nums[i] > nums[res]){
                nums[res + 1] = nums[i];
                res++;
            } else {
                continue;
            }
        }
        return res + 1;
    }
}
