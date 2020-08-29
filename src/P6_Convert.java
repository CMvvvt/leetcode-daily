import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class P6_Convert {

    /**
     * Build numRows StringBuilder and add Characters in s into every StringBuilder.
     * Change the direction by using the flag when encounter the outline.
     * Set variable flag to 1 of -1.
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(s.length() < 2 || numRows == 1) {
            return s;
        }
        List<StringBuilder> Rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            Rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for(char c: s.toCharArray()) {
            Rows.get(i).append(c);
            if(i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder c: Rows) {
            result.append(c);
        }
        return result.toString();
    }

    @Test
    public void testConvert() {
        String s = "Leetcode";
        assertEquals("Lcetoeed",convert(s,3));
    }


}
