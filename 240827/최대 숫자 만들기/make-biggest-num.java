import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] nums = new Integer[N];

        for (int i=0; i<N; i++) nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String aS = Integer.toString(a);
                String bS = Integer.toString(b);
                
                int ab = Integer.parseInt(aS + bS);
                int ba = Integer.parseInt(bS + aS);

                // 내림차순으로 정렬
                return Integer.compare(ba, ab);
            }
        });

        String ans = "";
        for (int num : nums) {
            ans += Integer.toString(num);
        }

        System.out.println(ans);

    }
}