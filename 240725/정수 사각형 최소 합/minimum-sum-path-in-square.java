import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][N-1] = map[0][N-1];
        for (int i=0; i<N; i++) {
            for (int j=N-1; j>=0; j--) {
                // 상, 우
                if (isIn(i-1, j) && isIn(i, j+1)) dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + map[i][j];
                else if (isIn(i-1, j)) dp[i][j] = dp[i-1][j] + map[i][j]; // 상
                else if (isIn(i, j+1)) dp[i][j] = dp[i][j+1] + map[i][j]; // 우
            }
        }

        System.out.println(dp[N-1][0]);

    }
    
    static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}