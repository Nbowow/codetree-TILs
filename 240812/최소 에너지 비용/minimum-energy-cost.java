import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        int[] dist = new int[N-1];
        for (int i=0; i<N-1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] cost = new int[N];
        for (int i=0; i<N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] min_cost = new int[N];
        min_cost[0] = cost[0];
        // 현재까지 에너지를 채우는데 드는 최소 비용을 저장
        for (int i=1; i<N; i++) {
            min_cost[i] = Math.min(min_cost[i-1], cost[i]);
        }

        long ans = 0;
        for (int i=0; i<N-1; i++) {
            ans += (long) (dist[i] * min_cost[i]);
        }

        System.out.println(ans);
    }
}