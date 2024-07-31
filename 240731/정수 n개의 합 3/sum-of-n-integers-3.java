import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[][] map;
    static int[][] PSum;
    static int max_sum;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        PSum = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합 배열 생성
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                PSum[i][j] = PSum[i-1][j] + PSum[i][j-1] - PSum[i-1][j-1] + map[i][j];
            }
        }

        // 최대 정사각형 구하기
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (isIn(i-K, j-K)) {
                    max_sum = Math.max(max_sum, PSum[i][j] - PSum[i-K][j] - PSum[i][j-K] + PSum[i-K][j-K]);
                }
            }
        }
        
        System.out.println(max_sum);
    }

    static void printMap(int[][] map) {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isIn(int x, int y) {
        return x>=0 && x<N+1 && y>=0 && y<N+1;
    }
}