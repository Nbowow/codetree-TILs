import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int idx, val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.val, n.val);
        }
    }

    static int N, M;
    static int[][] map;
    static PriorityQueue<Node> pq;
    static List<Node>[] nodes;
    static int[] dist;

    static void dijkstra() {

        pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        dist = new int[N];
        for (int i=1; i<N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        boolean[] isVisited = new boolean[N];
        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            int idx = cur.idx;
            int value = cur.val;

            if (isVisited[idx]) continue;
            isVisited[idx] = true;

            for (Node node : nodes[idx]) {
                if (dist[node.idx] > dist[idx] + node.val) {
                    dist[node.idx] = dist[idx] + node.val;
                    pq.offer(new Node(node.idx, dist[node.idx]));
                }
            }

        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nodes = new List[N];
        for (int i=0; i<N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());

            nodes[s].add(new Node(e, v));
        }

        dijkstra();

        for (int i=1; i<N; i++) {
            System.out.println(dist[i]);
        }
    }
}