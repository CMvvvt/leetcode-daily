public class P5789_theNumOfFullRoundsYouHavePlayed {

    class Solution {
        public int numberOfRounds(String startTime, String finishTime) {
            int startHour = Integer.parseInt(startTime.substring(0,2));
            int startMin = Integer.parseInt(startTime.substring(3));
            int finishHour = Integer.parseInt(finishTime.substring(0,2));
            int finishMin = Integer.parseInt(finishTime.substring(3));
            // 同 hour
            if(startHour == finishHour) {
                if(startMin < finishMin) {
                    return getMin(startMin, finishMin);
                } else {
                    int val = 23*4 + getMin(0, finishMin) + getMin(startMin, 59) + 1;
                    return startMin > 45 ? val - 1: val;
                }
            }
            if(startHour > finishHour) {
                int hours = 24 - startHour + finishHour;
                int val = getMin(0, finishMin) + getMin(startMin, 59) + 1 + (hours-1) * 4;
                return  startMin > 45 ? val-1 : val;
            }
            if(startHour == finishHour - 1) {
                int val = getMin(startMin, 59) + 1 + getMin(0, finishMin);
                return startMin > 45 ? val - 1: val;
            } else{
                int val = (finishHour - startHour - 1)*4 + getMin(startMin, 59) + 1 + getMin(0 , finishMin);
                return startMin > 45 ? val - 1: val;
            }
        }
}
