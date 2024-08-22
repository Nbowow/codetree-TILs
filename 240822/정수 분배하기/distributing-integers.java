import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] nums;

    static boolean parametricSearch(int cur) {

        // 예외처리
        if (cur == 0) return false;
        
        // cur숫자로 분배하여 m개 이상 얻을 수 있는지 확인 
        int totalCount = 0;
        for (int i=0; i<N; i++) {
            int q = nums[i] / cur;

            totalCount += q;

            if (totalCount >= M) return true;
        }

        return false;
        
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums[N-1];
        int ans = 0;
        while (left <= right) {

            int mid = (left + right) / 2;

            if (parametricSearch(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }

            else right = mid - 1;

        }

        System.out.println(ans);
    }
}