public class P5773_maxValue {
    class Solution {
        public String maxValue(String n, int x) {
            StringBuffer str = new StringBuffer(n);
            char first = n.charAt(0);
            int place = 0;
            if(first == '-') {
                place = getPlace(n, x, true);
            } else {
                place = getPlace(n, x, false);
            }
            str.insert(place, x + "");
            return str.toString();
        }
        private int getPlace(String n, int x, boolean isNegative){
            int length = n.length();
            if(isNegative) {
                for(int i = 1; i < length; i++) {
                    int val = Integer.parseInt(String.valueOf(n.charAt(i)));
                    if(val > x) {
                        return i;
                    }
                }
            } else{
                for(int i = 0; i < length; i++) {
                    int val = Integer.parseInt(String.valueOf(n.charAt(i)));
                    if(val < x) {
                        return i;
                    }
                }
            }
            return length;
        }
    }
}
