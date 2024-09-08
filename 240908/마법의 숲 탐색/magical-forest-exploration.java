import java.util.*;
import java.io.*;

public class Main {

    static class Golem {
        // r, c : 현재 골렘의 위치, d : 골렘 출구 방향
        int r, c, d;

        public Golem(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int R, C, K;
    static int ans;
    static int[][] map;
    static int[][] dxdy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서
    static Golem[] golems;

    static void findBottom(int idx) {

        Golem cur = golems[idx];

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[R+3][C];

        q.offer(new int[]{cur.r, cur.c, idx+1});
        isVisited[cur.r][cur.c] = true;

        int maxR = -1;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            int val = temp[2]; // 골렘 번호

            // 최대 r 값 갱신
            maxR = Math.max(maxR, r);

            for (int i=0; i<4; i++) {
                int dx = r + dxdy[i][0];
                int dy = c + dxdy[i][1];

                if (!isIn(dx, dy) || map[dx][dy] == 0 || isVisited[dx][dy]) continue;

                // 같은 골렘이라면
                if (map[dx][dy] == val) {
                    isVisited[dx][dy] = true;
                    q.offer(new int[]{dx, dy, map[dx][dy]});
                }

                // 다른 골렘이라면
                else {
                    // 출구일 경우만 다른 골렘으로 이동 가능
                    // System.out.println("golem : " + (golems[val-1].r + dxdy[golems[val-1].d][0]) + " " + (golems[val-1].c + dxdy[golems[val-1].d][1]));
                    if (r == (golems[val-1].r + dxdy[golems[val-1].d][0])
                        && c == (golems[val-1].c + dxdy[golems[val-1].d][1])) {
                            isVisited[dx][dy] = true;
                            q.offer(new int[]{dx, dy, map[dx][dy]});
                        }
                }
            }

        }

        // System.out.println(maxR-2);
        ans += maxR-2;

    }

    static boolean goRightDown(int idx) {

        Golem cur = golems[idx];
        boolean isExecute = false;

        if (isIn(cur.r, cur.c+2) && isIn(cur.r-1, cur.c+1) && isIn(cur.r+1, cur.c+1) && isIn(cur.r+1, cur.c+2) && isIn(cur.r+2, cur.c+1)
            && map[cur.r][cur.c+2] == 0 && map[cur.r-1][cur.c+1] == 0 && map[cur.r+1][cur.c+1] == 0
            && map[cur.r+1][cur.c+2] == 0 && map[cur.r+2][cur.c+1] == 0) {
                cur.r += 1;
                cur.c += 1;
                clockwise(idx);
                isExecute = true;
            }

        return isExecute;
    }

    static boolean goLeftDown(int idx) {

        Golem cur = golems[idx];
        boolean isExecute = false;

        if (isIn(cur.r, cur.c-2) && isIn(cur.r-1, cur.c-1) && isIn(cur.r+1, cur.c-1) && isIn(cur.r+1, cur.c-2) && isIn(cur.r+2, cur.c-1)
            && map[cur.r][cur.c-2] == 0 && map[cur.r-1][cur.c-1] == 0 && map[cur.r+1][cur.c-1] == 0
            && map[cur.r+1][cur.c-2] == 0 && map[cur.r+2][cur.c-1] == 0) {
                cur.r += 1;
                cur.c -= 1;
                counterClockwise(idx);
                isExecute = true;
            }

        return isExecute;
    }

    static void goDown(int idx) {

        Golem cur = golems[idx];

        while (isIn(cur.r+2, cur.c) && isIn(cur.r+1, cur.c-1) && isIn(cur.r+1, cur.c+1) 
            && map[cur.r+2][cur.c] == 0 && map[cur.r+1][cur.c-1] == 0 && map[cur.r+1][cur.c+1] == 0) {

            cur.r += 1;
        }

        return;
    }

    static void start() {

        // 모든 골렘이 이동할 때 까지 진행
        for (int g=0; g<golems.length; g++) {

            while (true) {
                // 하강
                goDown(g);

                // 불가능할 경우 좌이동 후 하강
                if (goLeftDown(g)) continue;

                // 불가능할 경우 우이동 후 하강
                if (!goRightDown(g)) break;
            }

            // 하강 후 최종 위치가 맵 밖이라면 (r == -1) map 초기화
            if (golems[g].r < 4) map = new int[R+3][C];
            
            // 하강 후 최종 위치가 맵 안이라면 맵에 위치 표시
            else {
                Golem cur = golems[g];
                map[cur.r][cur.c] = g+1;
                if (isIn(cur.r-1, cur.c)) map[cur.r-1][cur.c] = g+1;
                map[cur.r][cur.c+1] = g+1;
                map[cur.r+1][cur.c] = g+1;
                map[cur.r][cur.c-1] = g+1;

                // 이동 가능한 경로중 가장 아래행 까지 이동
                findBottom(g);

            }

            // printMap(map);
            // System.out.println();
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R+3][C];
        golems = new Golem[K];
        // 골렘 정보 입력
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            golems[i] = new Golem(-1, c-1, d);
        }

        start();

        System.out.println(ans);

    }

    static void printMap(int[][] map) {
        for (int i=0; i<R+3; i++) {
            for (int j=0; j<C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isIn(int x, int y) {
        return x>=0 && x<R+3 && y>=0 && y<C;
    }

    static void counterClockwise(int idx) {
        if (golems[idx].d == 0) golems[idx].d = 3;
        else golems[idx].d -= 1;
    }

    static void clockwise(int idx) {
        if (golems[idx].d == 3) golems[idx].d = 0;
        else golems[idx].d += 1;
    }
}