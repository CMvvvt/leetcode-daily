public class P171_excelSheetColumnNumber {
    class Solution {
        public int titleToNumber(String columnTitle) {
            char[] arr = columnTitle.toCharArray();
            int res = 0;
            for(int i = 0; i < arr.length; i++) {
                res = res*26 + (int)arr[i] -64;
            }
            return res;
        }
    }
}
