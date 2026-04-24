import java.io.*;
import java.util.*;

public class t5 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int numDestinations = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < s; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            int sourceNode = Integer.parseInt(st.nextToken());
            if (dist[sourceNode] == -1) {
                dist[sourceNode] = 0;
                q.add(sourceNode);
            }
        }

        
        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 0; i < adj[current].size(); i++) {
                int neighbor = adj[current].get(i);

                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 1;
                    q.add(neighbor);
                }
            }
        }

        
        for (int i = 0; i < numDestinations; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            int destNode = Integer.parseInt(st.nextToken());
            

            pw.print(dist[destNode] + " ");
        }
        
        pw.println();
        pw.flush();
    }
}