import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class P32_longestValidParenthesis {

    public int longestValidParenthesis(String s){
        int length = s.length();
        int num = 0;
        int maxNum = 0;
        Stack<Integer> stack  = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    maxNum = Math.max(maxNum,i - stack.peek());
                }
            }
        }
        return maxNum;
    }



    @Test
    public void test() {
        String s = "((()()()(()(((()(())(())()()";
        assertEquals(14,longestValidParenthesis(s));
    }
 }
