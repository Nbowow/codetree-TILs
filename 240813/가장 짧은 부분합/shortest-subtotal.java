import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;
        int tempSum = nums[0];
        int j = 0;
        for (int i=0; i<N; i++) {

            // 합이 S 이상이 되어야 함
            while (j + 1 < N && tempSum + nums[j+1] < S) {
                tempSum += nums[j+1];
                j++;
            }

            // 다음 원소가 없을 경우 => 불가능한 경우
            if (j + 1 == N && tempSum < S) break;

            // 다음 원소를 더하면 S 이상 된다.
            ans = Math.min(ans, j - i + 2);

            tempSum -= nums[i];
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }
}