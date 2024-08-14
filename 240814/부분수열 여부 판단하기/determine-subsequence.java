import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aLen = Integer.parseInt(st.nextToken());
        int bLen = Integer.parseInt(st.nextToken());

        int[] a = new int[aLen];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<aLen; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] b = new int[bLen];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<bLen; i++) b[i] = Integer.parseInt(st.nextToken());

        int i=0;
        boolean isOverlap = true;
        for (int j=0; j<bLen; j++) {

            while (i < aLen && a[i] != b[j]) {
                i++;
            }

            if (i == aLen) {
                isOverlap = false;
                break;
            }

            else i++;
        }

        if (isOverlap) System.out.println("Yes");
        else System.out.println("No");
    }
}