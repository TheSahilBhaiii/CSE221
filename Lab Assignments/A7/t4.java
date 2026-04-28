import java.io.*;
import java.util.*;
public class t4 {
        
        static class Pair implements Comparable<Pair>{
            int Node;
            long dist;

            public Pair(int Node,long dist){
                this.Node=Node;
                this.dist=dist;
            }
            public int compareTo(Pair other){
                return Long.compare(this.dist, other.dist);
            }
        }
    
        public static void main(String[] args) throws Exception{
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw=new PrintWriter(System.out);
            StringTokenizer st=new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            long w[]=new long[n+1];

            st = new StringTokenizer(bf.readLine());
            for(int i=1;i<=n;i++){
                w[i]=Long.parseLong(st.nextToken());
            }

            ArrayList<Integer> adj[]=new ArrayList[n+1];

            for(int i=1;i<=n;i++){
                adj[i]=new ArrayList<>();
            }
            for(int i=0;i<m;i++){
                st=new StringTokenizer(bf.readLine());
                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());

                adj[u].add(v);
            }
            long dist[]=new long[n+1];
            Arrays.fill(dist,Long.MAX_VALUE);

            PriorityQueue<Pair> pq=new PriorityQueue<>();

            dist[s]=w[s];
            pq.add(new Pair(s,dist[s]));

            while(!pq.isEmpty()){
                Pair curr=pq.poll();
                int u=curr.Node;
                long ds=curr.dist;

                if(ds>dist[u]) continue;

                for(int v:adj[u]){
                    if(dist[u]+w[v] < dist[v]){
                        dist[v]=dist[u]+w[v];
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
            if(dist[d]==Long.MAX_VALUE){
                pw.println("-1");
            }
            else{
                pw.println(dist[d]);
            }
            pw.flush();
        }
    }

