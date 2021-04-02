import java.util.Deque;
import java.util.LinkedList;

public class P1117_vol {
    public static int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] str) {
        int[] l = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(l));
    }

}
