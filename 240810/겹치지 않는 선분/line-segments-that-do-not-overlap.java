import java.util.*;
import java.io.*;

public class Main {

    static class Point implements Comparable<Point>{
        int s, e;

        public Point(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Point p) {
            if (this.s == p.s) {
                return Integer.compare(this.e, p.e);
            }
            return Integer.compare(this.s, p.s);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            points[i] = new Point(s, e);
        }

        Arrays.sort(points);

        int[] LM = new int[N]; // x0` < x0 인 x에 대해 가장큰 x1`값 기록
        LM[0] = points[0].e;
        for (int i=1; i<N; i++) {
            LM[i] = Math.max(LM[i-1], points[i].e);
        }

        int[] RM = new int[N]; // x0` > x0 인 x에 대해 가장 작은 x1`값 기록
        RM[N-1] = points[N-1].e;
        for (int i=N-2; i>=0; i--) {
            RM[i] = Math.min(RM[i+1], points[i].e);
        }

        // System.out.println(Arrays.toString(LM));
        // System.out.println(Arrays.toString(RM));

        int totalCount = 0;
        if (RM[1] > points[0].e) totalCount++;
        if (LM[N-2] < points[N-1].e) totalCount++;
        for (int i=1; i<N-1; i++) {
            if (LM[i-1] < points[i].e && RM[i+1] > points[i].e) totalCount++;
        }

        System.out.println(totalCount);
    }
}