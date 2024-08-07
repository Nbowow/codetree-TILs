import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int[] pSumL = new int[N];
        int[] pSumR = new int[N];

        if (str[0] == 'C') pSumL[0] = 1;
        if (str[N-1] == 'W') pSumR[N-1] = 1;

        // 왼쪽부터 C 갯수
        for (int i=1; i<N; i++) {
            if (str[i] == 'C') {
                pSumL[i] = pSumL[i-1] + 1;
            } else pSumL[i] = pSumL[i-1];
        }

        // 오른쪽부터 W 갯수
        for (int i=N-2; i>=0; i--) {
            if (str[i] == 'W') {
                pSumR[i] = pSumR[i+1] + 1;
            } else pSumR[i] = pSumR[i+1];
        }

        int ans = 0;
        for (int i=1; i<N-1; i++) {
            if (str[i] == 'O') {
                ans += pSumL[i] * pSumR[i];
            }
        }

        System.out.println(ans);

    }
}