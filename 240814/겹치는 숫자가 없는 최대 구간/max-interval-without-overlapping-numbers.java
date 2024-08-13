import java.util.*;
import java.io.*;

public class Main {

    static int MAX_NUM = 100000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        for (int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int j = 0;
        int max_d = 0;
        int[] counts = new int[MAX_NUM];
        counts[nums[0]]++;
        for (int i=0; i<N; i++) {

            while (j + 1 < N && counts[nums[j+1]] != 1) {
                counts[nums[j+1]]++;
                j++;
            }

            max_d = Math.max(max_d, j - i + 1);

            counts[nums[i]]--;
        }

        System.out.println(max_d);
    }
}