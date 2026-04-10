import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class t8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (!st.hasMoreTokens()) return;
        int t = Integer.parseInt(st.nextToken()); 
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long k = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long ans = k + (k - 1) / (x - 1);
            
            out.println(ans);
        }
        out.flush(); 
    }
}