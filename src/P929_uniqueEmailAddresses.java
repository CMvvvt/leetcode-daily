public class P929_uniqueEmailAddresses {
    class Solution {
        public int numUniqueEmails(String[] emails) {
            int n = emails.length;
            String[] local = new String[n];
            String[] domain = new String[n];
            for(int i = 0; i < n; i++) {
                String[] split = emails[i].split("\\@");
                local[i] = split[0];
                domain[i] = split[1];
            }
            Set<String> set = new HashSet<>();
            for(int i = 0; i < n; i++) {
                String str = "";
                str = ignore(local[i]) + "@" +  domain[i];
                set.add(str);
            }
            return set.size();
        }
        private String ignore(String str) {
            if(str.indexOf(".") == -1 && str.indexOf("+") == -1) {
                return str;
            }
            String ans = "";
            int dotPos = str.indexOf(".");
            int plusPos = str.indexOf("+");
            if(dotPos == -1) {
                ans = str.substring(0, plusPos);
                return ans;
            }
            if(plusPos == -1) {
                ans = str.replace(".", "");
                return ans;
            }
            ans = str.replace(".", "");
            ans = ans.substring(0, ans.indexOf("+"));
            return ans;

        }
    }
}
