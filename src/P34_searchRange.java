public class P34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        if(nums.length == 1) {
            if(target == nums[0]) {
                return new int[]{0,0};
            }else{
                return new int[]{-1,-1};
            }
        }
        int low = 0;
        int high = nums.length - 1;
        int mid  = 0;
        while(low <= high) {
            mid = (high - low) / 2 + low;
            if(nums[mid] == target) {
                if(mid == 0) {
                    int right = goRight(nums,mid,target);
                    return new int[]{mid,right};
                }
                if(mid == nums.length -1){
                   int left = goLeft(nums,mid,target);
                   return new int[] {left,mid};
                }
                int left = goLeft(nums,mid,target);
                int right = goRight(nums,mid,target);
                return new int[]{left,right};
            }
            if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    private int goLeft(int[] nums, int bar, int target) {
        int res = 0;
        while (nums[bar] == target) {
            res = bar;
            bar--;
            if(bar == -1){
                return 0;
            }
        }
        return res;
    }

    private int goRight(int[] nums, int bar, int target){
        int res = 0;
        while (nums[bar] == target) {
            res = bar;
            bar++;
            if(bar == nums.length) {
                return nums.length -1;
            }
        }
        return res;
    }
}
