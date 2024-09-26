import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] original = br.readLine().toCharArray();

        char[] cur = br.readLine().toCharArray();

        int ans = 0;
        for (int i=0; i<N; i++) {
            if (original[i] != cur[i]) {
                ans++;
                int j=0;
                for (j=i+1; j<N; j++) {
                    if (original[j] == cur[j]) break;
                }

                i = j;
            }
        }
 
        System.out.println(ans);
    }
}