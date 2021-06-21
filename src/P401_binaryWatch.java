public class P401_binaryWatch {
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> list = new ArrayList<>();
            for(int h = 0; h <= 11; h++) {
                for(int m = 0; m <= 59; m++) {
                    if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                        list.add(h + ":" + (m  < 10 ? "0": "")+ m);
                    }
                }
            }
            return list;
        }
    }
}
