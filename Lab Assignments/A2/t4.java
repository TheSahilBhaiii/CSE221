import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class t4 {
    
    // A clean Fast I/O class to handle huge inputs effortlessly
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        
        // Use PrintWriter for insanely fast output
        PrintWriter out = new PrintWriter(System.out);

        // Safely check if input exists
        String firstToken = sc.next();
        if (firstToken == null) return;
        
        // 1. Read Alice's List
        int N = Integer.parseInt(firstToken);
        int[] alice = new int[N];
        for (int i = 0; i < N; i++) {
            alice[i] = sc.nextInt();
        }

        // 2. Read Bob's List
        int M = sc.nextInt();
        int[] bob = new int[M];
        for (int i = 0; i < M; i++) {
            bob[i] = sc.nextInt();
        }

        // 3. Merge Step using Two Pointers
        int i = 0; // Alice's pointer
        int j = 0; // Bob's pointer

        // Keep comparing until one list runs out
        while (i < N && j < M) {
            if (alice[i] <= bob[j]) {
                out.print(alice[i] + " ");
                i++;
            } else {
                out.print(bob[j] + " ");
                j++;
            }
        }

        // 4. Print any leftovers from Alice's list
        while (i < N) {
            out.print(alice[i] + " ");
            i++;
        }

        // 5. Print any leftovers from Bob's list
        while (j < M) {
            out.print(bob[j] + " ");
            j++;
        }

        // CRITICAL: You must flush the PrintWriter to push the text to the console!
        out.flush();
    }
}