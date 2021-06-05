public class P168_excelSheetColumnTitle {
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder res = new StringBuilder();
            int remainder = columnNumber;
            int residue = 0;
            while(remainder != 0) {
                int dividend = remainder - 1;
                remainder = dividend / 26;
                res.insert(0, Character.toString((char)(65 + dividend % 26)));
            }
            return res.toString();
        }
    }
}
