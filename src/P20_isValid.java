import static org.junit.Assert.*;
import org.junit.Test;

import javax.print.attribute.standard.SheetCollate;
import java.util.*;

public class P20_isValid {
    public boolean isValid_mothod1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.peek() == '(' && s.charAt(i) == ')'){
                stack.pop();
            } else if(stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
            } else if(stack.peek() == '{' && s.charAt(i) =='}') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static final Map<Character,Character> map = new HashMap<>(){
        {
            put('(',')');
            put('[',']');
            put('{','}');
            put('?','?');
        }
    };

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        Stack<Character> stack = new Stack<>(){
            {push('?');}
        };
        for(Character c: s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            }else if(map.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }


    @Test
    public void test() {
        String s = "{[()]}";
        assertEquals(true,isValid(s));
    }


    class Solution2 {
        public boolean isValid(String s) {
            int n = s.length();
            if(n % 2 != 0) return false;
            Stack<Character> stack = new Stack();
            for(int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if(isOpen(ch)) {
                    stack.push(ch);
                    continue;
                }
                if(stack.isEmpty()) return false;
                if(!isMatch(ch, stack.pop())) return false;
            }
            return stack.isEmpty();
        }

        private boolean isOpen(Character ch) {
            return ch == '(' || ch == '{' || ch == '[';
        }

        private boolean isMatch(Character ch1, Character ch2) {
            if(ch1 == ')') return ch2 =='(';
            if(ch1 == ']') return ch2 == '[';
            return ch2 == '{';
        }
    }
}
