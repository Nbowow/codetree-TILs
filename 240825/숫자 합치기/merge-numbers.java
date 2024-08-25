import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(a, b);
            }
        });
        for (int i=0; i<N; i++) pq.offer(Integer.parseInt(st.nextToken()));

        int sum = 0;
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            sum += (n1+n2);

            pq.offer(n1+n2);
        }

        System.out.println(sum);

    }
}