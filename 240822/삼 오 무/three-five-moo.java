import java.util.*;
import java.io.*;

public class Main {

    static long N;

    static long parameticSearch(long cur) {

        long mooCount = cur / 3 + cur / 5 - cur / 15;

        return cur - mooCount;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        long left = 0;
        long right = Long.MAX_VALUE;
        long ans = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (parameticSearch(mid) >= N) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }

            else left = mid + 1;
        }

        System.out.println(ans);
    }
}