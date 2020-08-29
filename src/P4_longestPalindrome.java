import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class P4_longestPalindrome {

    public String longestPalindromeBrute(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxlen = 1;
        int begin = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                if (j - i + 1 > maxlen && isPalindrome(array, i, j)) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }


    /**
     * Leetcode problem5 using dynamic programming;
     * @param s
     * @return
     */
    public String longestPalindromeDynamic(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int begin = 0;
        int maxlen = 1;
        boolean[][] dp = new boolean[n][n];
        char[] charArray = s.toCharArray();
        // initialize the dp
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // fill the table
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (j - i + 1 > maxlen && dp[i][j]) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }


    public String longestPalindromeKuoSan(String s) {
        int n = s.length();
        if(s == null) {
            return "";
        }
        if (n < 2) {
            return  s;
        }

        int begin = 0;
        int end = 1;
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - begin) {
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        if(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(right)) {
                L--;
                R++;
        }
        return R - L - 1;
    }

    public boolean isPalindrome(char[] charArray, int i, int j){
        int left = i;
        int right = j;
        while(left < right) {
            if(charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    @Test
    public void testIsPalindrome() {
        String s1 = "baby";
        assertEquals(true,isPalindrome(s1.toCharArray(),0,2));
        assertEquals(false,isPalindrome(s1.toCharArray(),0,3));
    }


    @Test
    public void testLongestPalindrome() {
        String s1 = "bhdgblmdiuyuiyg";
        String s2 = "cbbd";
        assertEquals("iuyui",longestPalindromeBrute(s1));
        assertEquals("iuyui",longestPalindromeDynamic(s1));
        assertEquals("bb",longestPalindromeDynamic(s2));
        assertEquals("bb",longestPalindromeKuoSan(s2));
        assertEquals("iuyui",longestPalindromeKuoSan(s1));
    }


}
