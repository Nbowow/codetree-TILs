import java.util.*;
import java.io.*;

public class Main {

    static class Confer implements Comparable<Confer>{
        int s, e;

        public Confer(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Confer c) {
            if(this.e == c.e) return Integer.compare(c.s, this.s);
            return Integer.compare(this.e, c.e);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Confer[] conf = new Confer[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            conf[i] = new Confer(s, e);
        }

        Arrays.sort(conf);

        int endTime = conf[0].e;
        int confCount = 1;
        for (int i=1; i<N; i++) {
            if (conf[i].s >= endTime) {
                endTime = conf[i].e;
                confCount++;
            }
        }

        System.out.println(confCount);

    }
}