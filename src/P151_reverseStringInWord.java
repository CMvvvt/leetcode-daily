public class P151_reverseStringInWord {、class Solution {
    public String reverseWords(String s) {
        String string = s.replaceAll(" +", " ");
        string = string.trim()
        int len = string.length();
        if(len <= 1) return string;
        StringBuilder str = new StringBuilder();

        int space = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            char ch = string.charAt(i);
            if(ch == ' ') {
                stack.push(string.substring(space,i));
                space = i+1;
            } else if(i == len - 1) {
                stack.push(string.substring(space));
            }
        }
        while(!stack.isEmpty()) {
            str.append(stack.pop());
            if(!stack.isEmpty()) {
                str.append(" ");
            }
        }
        return str.toString();
    }
}

    class Solution2 {
        public String reverseWords(String s) {
            StringBuilder res = new StringBuilder();
            String str = s.replaceAll(" +", " ");
            str = str.trim();
            int len = str.length();
            int space = 0;
            for(int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                if(ch == ' ') {
                    res.insert(0, str.substring(space, i));
                    if(space == 0) res.insert(0, " ");
                    space = i;
                } else if(i == len-1) {
                    res.insert(0, str.substring(space));
                }
            }
            String ans = res.toString();
            return ans.trim();
        }
    }
}
