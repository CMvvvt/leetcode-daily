import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;



public class P8_atoi {
    public int myAtoi(String s) {
        char[] charArray = s.toCharArray();
        int index = 0;
        int ans = 0;
        boolean negative = false;
        //Skip the ' ';
        while(index < charArray.length && charArray[index] == ' '){
            index++;
        }

        if(index < charArray.length && charArray[index] == '-') {
            negative = true;
            index++;
        }else if(index < charArray.length && charArray[index] == '+') { //注意“-+222” 输出 -222 即遇到符号就跳过所有符号
            index++;
        } else if(!Character.isDigit(charArray[index])) {
            return 0;
        }
        while(index < charArray.length && Character.isDigit(charArray[index])) {
            int digit = (int) charArray[index] - (int)'0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                if(negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            ans = 10 * ans + digit;
            index ++;
        }
         return negative? -ans: ans;
    }

    @Test
    public void testAtoi(){
        String s = "48";
        assertEquals(48,myAtoi(s));
    }

    class Solution {
        public int myAtoi(String s) {
            int index = 0;
            int sign = 1;
            int total = 0;
            // 1. Empty String
            if(s.length() == 0) return 0;

            // 2. Remove Spaces
            while(index < s.length() && s.charAt(index) == ' ') {
                index++;
            }

            // 3. Handle Signs
            if(index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
                sign = s.charAt(index) == '+' ? 1: -1;
                index++;
            }

            // 4. Convert Number and Avoid Overflows
            while(index < s.length()) {
                int digit = s.charAt(index) - '0';
                if(digit < 0 || digit > 9) break;

                // check total would be overflow after 10 times and add digit
                if(Integer.MAX_VALUE/10 < total|| (Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 < digit))
                    return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
                total = total * 10 + digit;
                index++;
            }
            return sign*total;
        }
    }
}
