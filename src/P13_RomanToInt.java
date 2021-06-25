import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class P13_RomanToInt {
    /**
     * USING MAP DATA STRUCTURE TO STROE EVERYTHING
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M",1000);

        int res = 0;
        for (int i = 0; i < s.length();)
        if (i + 1 < s.length() && map.containsKey(s.substring(i,i+2))) {
            res = res + map.get(s.substring(i, i+2));
            i += 2;
        }else {
            res = res + map.get(s.substring(i, i + 1));
            i += 1;
        }
        return res;
    }

    public int romanToInt_mothod2(String s) {
        int sum = 0;
        int num = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            num = getValue(s.charAt(i));

            if(preNum < num) {
                sum = sum - preNum;
            } else {
                sum = sum + preNum;
            }
            preNum = num;
        }
        sum = sum + preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    @Test
    public void test() {
        String s = "MMCCCXLIX";
        assertEquals(2349,romanToInt(s));
        assertEquals(2349,romanToInt_mothod2(s));

    }

    class Solution3 {
        static Map<String, Integer> values = new HashMap<>();

        static {
            values.put("I", 1);
            values.put("V", 5);
            values.put("X", 10);
            values.put("L", 50);
            values.put("C", 100);
            values.put("D", 500);
            values.put("M", 1000);
        }
        public int romanToInt(String s) {
            int sum = 0;
            int i = 0;
            while(i < s.length()) {
                String symbol = s.substring(i, i+1);
                int currValue = values.get(symbol);
                int nextValue = 0;
                if(i + 1< s.length()) {
                    nextValue = values.get(s.substring(i + 1, i + 2));
                }
                if(currValue < nextValue) {
                    sum += nextValue - currValue;
                    i += 2;
                } else {
                    sum += currValue;
                    i++;
                }
            }
            return sum;
        }
    }
}
