import static org.junit.Assert.*;
import org.junit.Test;


public class P14_longestCommonPrefix {
    public String longestCommonPrefix_method1(String[] strs) {
        int length = strs.length;
        if (length == 1) {
            return strs[0];
        }
        String res = "";
        for (int i = 0; i < length - 1; i++) {
            res = longestCommonPrefix(strs[i], strs[i+1]);
            if (res == "") {
                return "";
            }
        }
        return res;
    }

    private String longestCommonPrefix(String str1, String str2) {
        if (str1 == "" || str2 == "") {
            return "";
        }
        String res = "";
        int index = 0;
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                index++;
            } else {
                break;
            }
        }
        return str1.substring(0,index);
    }


    @Test
    public void test() {
        String[] strs = {"caa","","a","acb"};
        assertEquals("",longestCommonPrefix_method1(strs));
    }
}
