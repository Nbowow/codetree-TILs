import java.util.*;
import java.io.*;
import java.util.Map.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("add")) {
                tMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            else if (command.equals("find")) {
                int findNum = tMap.getOrDefault(Integer.parseInt(st.nextToken()), 0);

                if (findNum == 0) sb.append("None");
                else sb.append(findNum);

                sb.append("\n");
            }
            else if (command.equals("remove")) {
                tMap.remove(Integer.parseInt(st.nextToken()));
            }
            else {
                if (tMap.isEmpty()) sb.append("None");
                else {
                    Iterator<Entry<Integer, Integer>> it = tMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Entry<Integer, Integer> entry = it.next();
                        sb.append(entry.getValue() + " ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}