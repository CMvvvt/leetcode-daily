public class P5727_findTheWinner {

    class Solution {
        public int findTheWinner(int n, int k) {
            if(n == 1) return 1;
            boolean[] nums = new boolean[n];
            int flag = -1;
            for(int i = 0; i < n - 1; i++){
                int times = 0;
                while(times != k) {
                    if(!nums[(flag+1) % n]) {
                        times++;
                        flag = (flag+1) % n;
                    } else {
                        flag = (flag+1) % n;
                    }
                }
                nums[flag] = true;
            }
            while(nums[flag]) {
                flag = (flag+1) % n;
            }
            return  flag+1 ;
        }
    }
}
