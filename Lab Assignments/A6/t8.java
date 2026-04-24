import java.io.*;
import java.util.*;

public class t8 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String line = bf.readLine();
        if (line == null) return;
        StringTokenizer st = new StringTokenizer(line);

        int n = Integer.parseInt(st.nextToken());

        String[] words = new String[n];
        boolean[] present = new boolean[26];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            words[i] = st.nextToken();
            
            for (int j = 0; j < words[i].length(); j++) {
                int c = words[i].charAt(j) - 'a';
                if (!present[c]) {
                    present[c] = true;
                    uniqueCount++;
                }
            }
        }

        boolean[][] adj = new boolean[26][26];
        int[] inDegree = new int[26];

        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());
            boolean diffFound = false;

            for (int j = 0; j < len; j++) {
                int u = w1.charAt(j) - 'a';
                int v = w2.charAt(j) - 'a';

                if (u != v) {
                    diffFound = true;
                    
                    if (!adj[u][v]) {
                        adj[u][v] = true;
                        inDegree[v]++;
                    }
                    break; 
                }
            }

            if (!diffFound && w1.length() > w2.length()) {
                pw.println("-1");
                pw.flush();
                return;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < 26; i++) {
            if (present[i] && inDegree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int curr = pq.poll(); 
            sb.append((char) (curr + 'a'));

            for (int next = 0; next < 26; next++) {
                if (adj[curr][next]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        pq.add(next);
                    }
                }
            }
        }

        if (sb.length() == uniqueCount) {
            pw.println(sb.toString());
        } else {
            pw.println("-1");
        }

        pw.flush();
    }
}