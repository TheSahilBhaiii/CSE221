import java.io.*;
import java.util.*;

public class t6{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        int dist[]=new int[10000];
        Arrays.fill(dist,-1);

        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        
        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            int forbidden = Integer.parseInt(st.nextToken());
            dist[forbidden] = -2;
        }
        
        Queue<Integer> q=new ArrayDeque<>();

        q.add(start);
        dist[start]=0;
        
        boolean found=false;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == target) {
                pw.println(dist[curr]);
                found = true;
                break;
            }

            int[] pow10 = {1000, 100, 10, 1};
            
            for (int i = 0; i < 4; i++) {
                int digit = (curr / pow10[i]) % 10;
                int up = (digit + 1) % 10; 
                int neighborUp = curr - (digit * pow10[i]) + (up * pow10[i]);
                
                if (dist[neighborUp] == -1) {
                    dist[neighborUp] = dist[curr] + 1;
                    q.add(neighborUp);
                }

                
                int down = (digit + 9) % 10; 
                int neighborDown = curr - (digit * pow10[i]) + (down * pow10[i]);
                
                if (dist[neighborDown] == -1) {
                    dist[neighborDown] = dist[curr] + 1;
                    q.add(neighborDown);
                }
            }
        }

        
        if (!found) {
            pw.println("-1");
        }

        pw.flush();
    }
}