public class P11_containerWithMostWater {
    /**
     * brute force
     */
    class Solution1 {
        public int maxArea(int[] height) {
            int maxArea = 0;
            for(int i = 0; i < height.length; i++) {
                for(int j = i + 1; j < height.length; j++) {
                    maxArea = Math.max(maxArea, (j-i)*Math.min(height[i], height[j]));
                }
            }
            return maxArea;
        }
    }

    /**
     * double pointer method
     */
    class Solution2 {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1, maxArea = 0;
            while(l < r) {
                maxArea = Math.max(maxArea, (r-l)*Math.min(height[l], height[r]));
                if(height[l] <= height[r]) {
                    l++;
                } else {
                    r--;
                }
            }
            return maxArea;
        }
    }
}
