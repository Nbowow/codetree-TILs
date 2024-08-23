import java.util.*;
import java.io.*;

public class Main {

    static class Jewel implements Comparable<Jewel>{

        double w, v;

        public Jewel(double w, double v) {
            this.w = w;
            this.v = v;
        }

        // 가치 / 무게 기준 내림차순 정렬
        @Override
        public int compareTo(Jewel j) {
            return Double.compare(j.v / j.w, this.v / this.w);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Jewel[] items = new Jewel[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            items[i] = new Jewel((double)w, (double)v);
        }

        Arrays.sort(items);

        double ansW = 0;
        double ansV = 0;
        for (int i=0; i<N; i++) {
            if (ansW + items[i].w > M) {

                double restW = M - ansW;

                ansW += restW;
                ansV += (items[i].v / items[i].w) * restW;
                break;
            }

            ansW += items[i].w;
            ansV += items[i].v;
        }

        System.out.printf("%.3f", ansV);
    }
}