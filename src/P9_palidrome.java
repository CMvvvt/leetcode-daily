import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class P9_palidrome {
    /**
     * method-1
     * @param x
     * @return
     */
    public boolean isPalindrome_method1(int x) {
        String s = x + "";
        int flag = 0;
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            if(s.charAt(start) == s.charAt(end)) {
                start += 1;
                end -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_method2(int x) {
        String s = (new StringBuilder(x + "").reverse().toString());
        return s.equals(x + "");
    }

    public boolean isPalindrome_method3(int x) {
        if(x < 0) {
            return false;
        }
        int flag = 1;
        while(x / flag >= 10) {
            flag = flag * 10;
        }
        while (x > 0) {
            int first = x / flag;
            int last = x % 10;
            if (first != last) {
                return false;
            }
            x = (x - flag * first) / 10;
            flag = flag / 100;
        }
        return true;
    }


    public boolean isPalindrome_method4(int x) {
        if (x < 0 || (x % 10 == 0 && x > 0)) {
            return false;
        }
        int reverseNum = 0;
        while(x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }
        return (x == reverseNum ||x == reverseNum / 10);
    }

    @Test
    public void testIsPalindrome() {
        int test1 = 12321;
        int test2 = 12344321;
        int test3 = -121;
        assertEquals(true,isPalindrome_method1(test1));
        assertEquals(true,isPalindrome_method1(test2));
        assertEquals(false,isPalindrome_method1(test3));
    }

    @Test
    public void testIsPalindrome_method2() {
        int test1 = 12321;
        int test2 = 12344321;
        int test3 = -121;
        assertEquals(true,isPalindrome_method2(test1));
        assertEquals(true,isPalindrome_method2(test2));
        assertEquals(false,isPalindrome_method2(test3));
    }


    @Test
    public void testIsPalindrome_method3() {
        int test1 = 12321;
        int test2 = 12344321;
        int test3 = -121;
        assertEquals(true,isPalindrome_method3(test1));
        assertEquals(true,isPalindrome_method3(test2));
        assertEquals(false,isPalindrome_method3(test3));
    }


    @Test
    public void testIsPalindrome_method4() {
        int test1 = 12321;
        int test2 = 12344321;
        int test3 = -121;
        assertEquals(true,isPalindrome_method4(test1));
        assertEquals(true,isPalindrome_method4(test2));
        assertEquals(false,isPalindrome_method4(test3));
    }
}


