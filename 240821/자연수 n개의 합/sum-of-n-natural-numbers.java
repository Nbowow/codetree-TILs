import java.util.*;
import java.io.*;

public class Main {

    static long binary(long target) {

        long left = 0;
        long right = target-1;
        long minIdx = target;

        while (left <= right) {
            long mid = (left+right) / 2;

            if (mid * (mid+1) / 2 >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }

            else left = mid + 1;
        }

        return minIdx;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());

        long ans = binary(s);
        
        System.out.println(ans - 1);

    }
}