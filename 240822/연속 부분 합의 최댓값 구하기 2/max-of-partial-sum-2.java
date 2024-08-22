import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int ans = nums[0];
        int maxSum = 0;
        for (int i=0; i<N; i++) {
            // 현재 maxSum이 음수이면 다음수부터 진행(직접 그려보면서 이해해야할듯)
            if (maxSum < 0) maxSum = nums[i];
            else maxSum += nums[i];

            ans = Math.max(ans, maxSum);
        }

        System.out.println(ans);
    }
}