import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] nums;

    static int binary(int num) {
        
        int left = 0;
        int right = n-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (num == nums[mid]) return mid;
            else if (num < nums[mid]) {
                right = mid - 1;
            }
            else left = mid + 1;
        }        

        return -1;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) nums[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            int cur = Integer.parseInt(br.readLine());

            sb.append(binary(cur) + "\n");
        }

        System.out.println(sb);
    }
}