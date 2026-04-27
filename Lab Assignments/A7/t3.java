import java.io.*;
import java.util.*;
public class t3 {
    
    static class Edge{
        int to;
        long weight;

        public Edge(int to,long weight){
            this.to=to;
            this.weight=weight;
        }
    }
    static class Pair implements Comparable<Pair>{
        int node;
        long dist;

        public Pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
        public int compareTo(Pair other){
            return Long.compare(this.dist, other.dist);
        }
    }

    static ArrayList<Edge> adj[];

    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        adj=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            long w=Long.parseLong(st.nextToken());

            adj[u].add(new Edge(v,w));
            adj[v].add(new Edge(u,w));
        }
        long dist[]=new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);

        PriorityQueue<Pair> pq=new PriorityQueue<>();

        dist[1]=0;
        pq.add(new Pair(1,0));
        

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            long ds=curr.dist;

            if(ds>dist[u]) continue;

            for(Edge edge: adj[u]){
                int v=edge.to;
                long weight=edge.weight;

                if(Math.max(dist[u],weight) <dist[v]){
                    dist[v]=Math.max(dist[u],weight);
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(dist[i]==Long.MAX_VALUE){
                pw.print("-1 ");
            }
            else{
                pw.print(dist[i]+" ");
            }
        }
        pw.println();
        pw.flush();
    }
}
        

