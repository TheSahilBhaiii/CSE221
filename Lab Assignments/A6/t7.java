import java.io.*;
import java.util.*;

public class t7{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        String startWord = st.nextToken();
        String targetWord = st.nextToken();

        
        if (startWord.equals(targetWord)) {
            pw.println("YES");
            pw.flush();
            return;
        }

        
        boolean[][] adj = new boolean[26][26];

        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            String word = st.nextToken();
            
            int u = word.charAt(0) - 'A';
            int v = word.charAt(word.length() - 1) - 'A';
            
            adj[u][v] = true;
        }

        
        int startNode = startWord.charAt(startWord.length() - 1) - 'A';
        int targetNode = targetWord.charAt(0) - 'A';

        
        boolean[] visited = new boolean[26];
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(startNode);
        visited[startNode] = true;

        boolean found = false;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == targetNode) {
                found = true;
                break;
            }

            for (int next = 0; next < 26; next++) {
                if (adj[current][next] && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        if (found) {
            pw.println("YES");
        } else {
            pw.println("NO");
        }
        
        pw.flush();
    }
}