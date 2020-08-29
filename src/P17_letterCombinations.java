import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


public class P17_letterCombinations {
    String letterMap[] = {
            "",     //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    ArrayList<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits){
        if(digits == "") {
            return new ArrayList<String>();
        }

        findCombination(digits,"",0);
        return res;
    }



    private void findCombination(String str, String letter, int index) {
        if(index == str.length()) {
            res.add(letter);
            return;
        }

        char c = str.charAt(index);
        int pos = c - '0';
        String mapString = letterMap[pos];
        for(int i = 0; i < mapString.length(); i++) {
            findCombination(str, letter + mapString.charAt(i), index + 1);
        }
    }

    @Test
    public void test() {
        String[] ans = {"ad","ae","af","bd","be","bf","cd","ce","cf"};
        assertEquals(ans, letterCombinations("23"));
    }
}
