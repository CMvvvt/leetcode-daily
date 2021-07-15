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


    /**
     * p332 added new approach
     */
    class Solution {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            buildMap(map, tickets);
            dfs("JFK");
            Collections.reverse(res);
            return res;
        }

        private void dfs(String from) {
            PriorityQueue<String> arrivals = map.get(from);
            while(arrivals != null && !arrivals.isEmpty()) {
                String to = arrivals.poll();
                dfs(to);
            }
            res.add(from);
        }

        private void buildMap(Map<String, PriorityQueue<String>> map, List<List<String>> tickets) {
            for(List<String> ticket: tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                if(! map.containsKey(from)) {
                    map.put(from, new PriorityQueue<>());
                }
                map.get(from).offer(to);
            }
        }
    }
}
