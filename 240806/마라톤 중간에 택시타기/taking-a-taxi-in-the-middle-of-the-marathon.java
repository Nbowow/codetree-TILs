import java.util.*;
import java.io.*;

public class Main {

    static class Check {
        int x, y;

        public Check(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Check[] points = new Check[N];
        int[] pSum = new int[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Check(x, y);
            if (i == 0) pSum[i] = Math.abs(x)+Math.abs(y);
            else {
                pSum[i] = pSum[i-1] + Math.abs(points[i].x - points[i-1].x) + Math.abs(points[i].y - points[i-1].y);
            }
        }

        // 맨 앞과 맨 뒤는 제외
        int minD = Integer.MAX_VALUE;
        int total = pSum[N-1];
        for (int i=1; i<N-1; i++) {
            int gap = pSum[i+1] - pSum[i-1];
            minD = Math.min(minD, total - gap + Math.abs(points[i+1].x - points[i-1].x) + Math.abs(points[i+1].y - points[i-1].y));
        }

        System.out.println(minD);


    }
}