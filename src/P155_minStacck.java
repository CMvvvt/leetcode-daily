public class P155_minStacck {
    class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int val) {
            if(! stack.isEmpty()) {
                stack.push(val);
                minStack.push(Math.min(minStack.peek(), val));
            } else {
                stack.push(val);
                minStack.push(val);
            }

        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
