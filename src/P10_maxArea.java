import static org.junit.Assert.*;
import org.junit.Test;


public class P10_maxArea {
    /**
     * method-1 Brutal solution.
     * @param height
     * @return
     */
    public int maxArea_method1(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j ++) {
                if (height[i] >= height[j]) {
                    area = (j - i) * height[j];
                } else {
                    area = (j - i) * height[i];
                }
                if(area >= maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public int maxArea_method2(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        int area = 0;
        while (start < end) {
            if (height[start] <= height[end]) {
                area = (end - start) * height[start];
                start = start + 1;
            } else {
                area = (end - start) * height[end];
                end = end - 1;
            }
            if (maxArea <= area) {
                maxArea = area;
            }
        }
        return maxArea;
    }


    @Test
    public void testMaxArea() {
        int[] test1 = {1,8,6,2,5,4,8,3,7};
        assertEquals(49,maxArea_method1(test1));
        assertEquals(49,maxArea_method2(test1));
    }
}
