import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc=0; tc<T; tc++) {
            int k = Integer.parseInt(br.readLine());

            TreeSet<Integer> tSet = new TreeSet<>();
            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if (command.equals("I")) {
                    int n = Integer.parseInt(st.nextToken());
                    tSet.add(n);
                }
                else if (command.equals("D")) {
                    int nCommand = Integer.parseInt(st.nextToken());

                    if (nCommand == 1) {
                        if (!tSet.isEmpty()) {
                            tSet.remove(tSet.last());
                        }
                    }
                    else if (nCommand == -1) {
                        if (!tSet.isEmpty()) {
                            tSet.remove(tSet.first());
                        }
                    } 
                }
            }

                if (!tSet.isEmpty()) {
                    System.out.println(tSet.last() + " " + tSet.first());
                }
                else System.out.println("EMPTY");

        }
    }
}