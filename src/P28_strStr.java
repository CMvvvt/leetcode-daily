import static org.junit.Assert.*;
import org.junit.Test;


public class P28_strStr {
    public int strStr(String haystack, String needle) {
        if( needle == null) {
            return 0;
        }
        int res = 0;
        int length = needle.length();
        for(int i = 0; i < haystack.length() - length; i++) {
            if(haystack.charAt(i) != needle.charAt(0)) {
                continue;
            } else if(!haystack.substring(i, i + length).equals(needle)) {
                continue;
            } else {
                res = i;
                break;
            }
        }
        return res;
    }

    @Test
    public  void test() {
        assertEquals("hello".substring(2,4), "ll");
        //assertEquals(2,strStr("hello","ll"));
    }

    class Solution2 {
        public int strStr(String haystack, String needle) {
            int m = haystack.length();
            int n = needle.length();
            if(n == 0) return 0;
            if(m < n) return -1;
            for(int i = 0; i < m - n + 1; i++) {
                if(haystack.substring(i, i + n).equals(needle)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
