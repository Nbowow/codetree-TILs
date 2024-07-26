import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                hmap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            else if (command.equals("find")) {

                int findNum = hmap.getOrDefault(Integer.parseInt(st.nextToken()), 0);

                if (findNum == 0) sb.append("None");
                else sb.append(findNum);
                sb.append("\n");
            }
            else if (command.equals("remove")) {
                hmap.remove(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);
    }
}