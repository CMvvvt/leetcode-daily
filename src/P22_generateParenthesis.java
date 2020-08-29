import static org.junit.Assert.*;
import org.junit.Test;

import javax.print.attribute.standard.SheetCollate;
import java.util.*;


public class P22_generateParenthesis {
    public List<String> generateParenthesis_method_dfs(int n){
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        dfs("",n,n,res);
        return res;
    }

    private void dfs(String parenthesis,int left, int right, List<String> result) {
        if(left == 0 && right == 0) {
            result.add(parenthesis);
            return;
        }

        if(left > right) {
            return;
        }

        if(left > 0) {
            dfs(parenthesis + "(",left-1,right,result);
        }

        if(right > 0){
            dfs(parenthesis+")",left,right-1,result);
        }
    }

    public List<String> generateParenthesisDynamicApproach(int n){
        return null;
    }
}
