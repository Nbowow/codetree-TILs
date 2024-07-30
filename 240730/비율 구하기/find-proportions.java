import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> tMap = new TreeMap<>();
        for (int i=0; i<n; i++) {
            String color = br.readLine();
            if (tMap.containsKey(color)) {
                tMap.put(color, tMap.get(color) + 1);
            } else {
                tMap.put(color, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Entry<String, Integer>> iter = tMap.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Integer> entry = iter.next();
            String percentage = String.format("%.4f", entry.getValue() * 100.0 / n);

            sb.append(entry.getKey() + " " + percentage);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}