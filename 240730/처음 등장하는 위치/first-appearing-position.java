import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!tMap.containsKey(num)) tMap.put(num, i+1);
        }

        Iterator<Entry<Integer, Integer>> iter = tMap.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()) {
            Entry<Integer, Integer> entry = iter.next();
            sb.append(entry.getKey() + " " + entry.getValue());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}