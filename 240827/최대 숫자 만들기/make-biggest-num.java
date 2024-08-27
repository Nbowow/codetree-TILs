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
                
                String ab = aS+bS;
                String ba = bS+aS;

                // 내림차순으로 정렬
                return ba.compareTo(ab);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (long num : nums) {
            sb.append(num);
        }

        System.out.println(sb);

    }
}