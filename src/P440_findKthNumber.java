import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P440_findKthNumber {
    public int findKthNumber_brutal(int n, int k) {
        PriorityQueue<String> queue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return s1.compareTo(s2);
            }
        });
        for(int i = 1; i <= n; i++) {
            queue.offer(String.valueOf(i));
        }

        for (int j = 1; j < k; j++) {
            queue.poll();
        }
        return Integer.parseInt(queue.poll());
    }


    public int findKthNumber(int n, int k) {
        return 0;
    }
}
