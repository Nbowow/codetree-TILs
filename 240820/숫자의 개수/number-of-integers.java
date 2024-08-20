import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] nums;

    static int upperBound(int cur) {
        int left = 0;
        int right = N - 1;

        int minIdx = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > cur) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else left = mid + 1;
        }

        return minIdx;

    }
    
    static int lowerBound(int cur) {

        int left = 0;
        int right = N-1;

        int minIdx = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] >= cur) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }

            else left = mid + 1;
        }

        return minIdx;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());

        for (int i=0; i<M; i++) {
            int temp = Integer.parseInt(br.readLine());

            int gap = upperBound(temp) - lowerBound(temp);
            System.out.println(gap);
        }
    }
}