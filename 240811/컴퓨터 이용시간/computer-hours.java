import java.util.*;
import java.io.*;

public class Main {

    static class Tuple implements Comparable<Tuple>{
        int idx, val;
        boolean isStart;

        public Tuple(int idx, int val, boolean isStart) {
            this.idx = idx;
            this.val = val;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Tuple t) {
            return Integer.compare(this.val, t.val);
        }
    }

    static int N;
    static List<Tuple> times;
    static int[] ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        times = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            times.add(new Tuple(i, s, true));
            times.add(new Tuple(i, e, false));
        }

        Collections.sort(times);
        // 오름차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(a, b);
            }
        });
        for (int i=1; i<=N; i++) pq.offer(i);

        ans = new int[N];
        for (int i=0; i<times.size(); i++) {
            Tuple cur = times.get(i);

            // 컴퓨터를 사용 시작하는 시각일 경우
            if (cur.isStart) {
                int useC = pq.poll(); // 사용가능한 컴퓨터 idx
                ans[cur.idx] = useC;
            }
            
            // 컴퓨터를 사용 종료하는 시각일 경우
            else {
                pq.offer(ans[cur.idx]); // 사용 종료한 컴퓨터 idx 우선순위 큐에 삽입
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.println(sb);
    }
}