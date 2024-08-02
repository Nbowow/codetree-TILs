import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        int cnt = 1;
        for (int i=0; i<N; i++) {
            tMap.put(nums[i], cnt++);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int sk = tMap.get(s);
            int ek = tMap.get(e);

            sb.append(ek-sk+1);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}