import java.util.*;
import java.io.*;

public class Main {

    static class Point implements Comparable<Point>{
        int x, y;
        boolean isAlive;

        public Point(int x, int y, boolean isAlive) {
            this.x = x;
            this.y = y;
            this.isAlive = isAlive;
        }

        @Override
        public int compareTo(Point p) {
            if (this.x == p.x) {
                return Integer.compare(this.y, p.y);
            }
            return Integer.compare(this.x, p.x);
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
            points[i] = new Point(s, e, true);
        }

        Arrays.sort(points);

        Point cur = new Point(points[0].x, points[0].y, true);
        int totalCount = N;
        for (int i=1; i<N; i++) {
            
            // x0 < x1 && y0 > y1 => 겹치는 선분
            if (points[i].y < cur.y) {
                if (cur.isAlive) {
                    totalCount--;
                    cur.isAlive = false;
                }
                totalCount--;
                points[i].isAlive = false;
            }
            else {
                // x0 > x1 && y0 < y1 => 겹치는 선분
                if (points[i].x < cur.x) {
                    if (cur.isAlive) {
                    totalCount--;
                    cur.isAlive = false;
                }
                    totalCount--;
                    points[i].isAlive = false;
                }
                cur = points[i];
            }
        }

        System.out.println(totalCount);
    }
}