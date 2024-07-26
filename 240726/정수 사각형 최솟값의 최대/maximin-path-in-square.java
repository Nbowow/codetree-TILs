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
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        dp[0][0] = map[0][0];
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (isIn(i-1, j) && isIn(i, j-1)) {
                    dp[i][j] = Math.max(Math.min(dp[i-1][j], map[i][j]), Math.min(dp[i][j-1], map[i][j]));
                }
                else if (isIn(i-1, j)) {
                    dp[i][j] = Math.min(dp[i-1][j], map[i][j]);
                }
                else if (isIn(i, j-1)) {
                    dp[i][j] = Math.min(dp[i][j-1], map[i][j]);
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }

    static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}