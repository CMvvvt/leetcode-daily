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
}
