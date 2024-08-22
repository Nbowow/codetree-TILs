import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int _max = 0;
        int maxNum = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            // 입력된 모든 수가 음수일 경우 대비
            maxNum = Math.max(maxNum, nums[i]);

            if (_max + nums[i] > 0) _max += nums[i];
            else _max = Math.max(0, nums[i]);
        }

        System.out.println(_max == 0 ? maxNum : _max);
    }
}