public class P332_reconstructItinerary {
    class Solution {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> itinerary = new LinkedList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for(List<String> ticket: tickets) {
                String src = ticket.get(0);
                String dst = ticket.get(1);
                if(! map.containsKey(src)) {
                    map.put(src, new PriorityQueue<String>());
                }
                map.get(src).offer(dst);
            }
            dfs("JFK");
            Collections.reverse(itinerary);
            return itinerary;
        }

        private void dfs(String curr) {
            while(map.containsKey(curr) && map.get(curr).size() > 0) {
                String temp = map.get(curr).poll();
                dfs(temp);
            }
            itinerary.add(curr);
        }
    }
}
