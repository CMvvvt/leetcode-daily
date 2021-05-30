public class evalRPN {
    class Solution {
        public int evalRPN(String[] tokens) {
            int res = 0;
            int length = tokens.length;
            Stack<Integer> stack = new Stack();
            for(int i = 0; i < length; i++) {
                String ch = tokens[i];
                if(!isNumber(ch)) {
                    int first = stack.pop();
                    int second = stack.pop();
                    int result = 0;
                    switch(ch) {
                        case "+": {
                            result = second + first;
                            break;
                        }
                        case "-": {
                            result = second - first;
                            break;
                        }
                        case "*": {
                            result = second * first;
                            break;
                        }
                        case "/": {
                            result = second / first;
                            break;
                        }
                    }
                    stack.push(result);
                } else {
                    int result = Integer.parseInt(String.valueOf(ch));
                    stack.push(result);
                }
            }
            return stack.pop();
        }
        private boolean isNumber(String token) {
            return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
        }
    }
}
