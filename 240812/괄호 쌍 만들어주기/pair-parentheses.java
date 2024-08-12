import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();

        int[] close = new int[str.length];
        for (int i=str.length-2; i>=0; i--) {
            if (str[i] == ')' && str[i+1] == ')') {
                close[i] = close[i+1] + 1;
            }
            else close[i] = close[i+1];
        }

        long ans = 0;
        for (int i=1; i<str.length; i++) {
            if (str[i] == '(' && str[i-1] == '(') {
                ans += close[i];
            }
        }
        
        System.out.println(ans);
    }
}