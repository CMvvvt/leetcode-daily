import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class pb3 {
    /**
     * Leetcode problem3
     * @param s
     * @return the Number of characters of the longest Substring.
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while(rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }



    @Test
    public void testForLengthOfLongestSubstring() {
        String s = "aaurruijgd";
        assertEquals(6,lengthOfLongestSubstring(s));
    }


}

