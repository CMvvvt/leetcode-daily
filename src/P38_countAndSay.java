import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;


public class P38_countAndSay {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        String str = countAndSay(n - 1);
        int length = str.length();
        int start = 0;
        for( int i = 1; i < length + 1; i++) {
            if(i == length) {
                res.append(i - start).append(str.charAt(start));
            } else if(str.charAt(i) != str.charAt(start)) {
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();

    }

    @Test
    public void test() {
        String res1 = "1";
        String res2 = "11";
        String res3 = "21";

        assertEquals(res2,countAndSay(2));
    }
}
