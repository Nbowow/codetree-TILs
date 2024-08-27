import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Long[] nums = new Long[N];

        for (int i=0; i<N; i++) nums[i] = Long.parseLong(br.readLine());

        Arrays.sort(nums, new Comparator<Long>() {
            @Override
            public int compare(Long a, Long b) {
                String aS = Long.toString(a);
                String bS = Long.toString(b);
                
                long ab = Long.parseLong(aS + bS);
                long ba = Long.parseLong(bS + aS);

                // 내림차순으로 정렬
                return Long.compare(ba, ab);
            }
        });

        String ans = "";
        for (long num : nums) {
            ans += Long.toString(num);
        }

        System.out.println(ans);

    }
}