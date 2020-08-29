import org.junit.Test;
import java.util.Stack;
import static org.junit.Assert.assertEquals;

public class P33_search {
    public int search(int[] nums, int target){
        int length = nums.length;
        if(length == 0 || nums == null) {
            return -1;
        }
        if(length <= 3) {
            for (int i = 0; i < length; i++) {
                if(target == nums[i]) {
                    return i;
                }
            }
            return  -1;
        }
        int bar = nums[0];
        if(target == bar) {
            return 0;
        }
        boolean position = false;
        if(target >= bar) {
            position = true; // 左边数组中
        } else {
            position = false;
        }
        if(nums[length -1] > nums[0]) {
            return searchValue(nums, 0, length -1,target);
        }
        int sideBar = position ? searchBar(nums,0, length - 1): searchBar(nums,0,length - 1) + 1;
        if(nums[sideBar] == target) {
            return sideBar;
        }
        if(position && target > nums[sideBar]) {
            return -1;
        }
        if(!position && target < nums[sideBar]) {
            return -1;
        }
        int res = position ? searchValue(nums,0,sideBar,target) : searchValue(nums, sideBar, length - 1,target);
        return res;
    }

    private int searchBar(int[] nums, int start, int end) {
        int bar =  (end - start) / 2 + start;
        if(nums[bar] > nums[bar+1] && nums[bar] > nums[bar-1]){
            return bar; //finded
        } else if(nums[bar] < nums[bar - 1] && nums[bar] < nums[bar + 1]) {
            return --bar;
        } else if(nums[bar] >= nums[0]) {
            return searchBar(nums, bar, end);
        } else {
            return searchBar(nums, start, bar);
        }
    }

    private int searchValue(int[] nums, int start, int end, int target) {
        if(start == end && start == 0 || start == end && end == nums.length -1){
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        if(end - start == 1) {
            if(nums[end] == target) {
                return end;
            } else{
                return -1;
            }
        }
        int bar = (end - start) / 2 + start;
        if(nums[bar] == target) {
            return bar;
        } else if(nums[bar] < target) {
            return searchValue(nums, bar, end, target);
        } else {
            return searchValue(nums, start, bar, target);
        }

    }

    @Test
    public void test() {
        int[] nums = {2,3,5,6,8,9,0};
        assertEquals(-1, search(nums,1));
    }
}
