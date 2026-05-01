import java.io.*;
import java.util.*;
public class t6 {
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

    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        
        ArrayList<Edge> adj[]=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        long dist1[]=new long[n+1];
        long dist2[]=new long[n+1];

        Arrays.fill(dist1,Long.MAX_VALUE);
        Arrays.fill(dist2,Long.MAX_VALUE);

        PriorityQueue<Pair> pq=new PriorityQueue<>();

        dist1[s]=0;
        pq.add(new Pair(s,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            long currDist=curr.dist;
            
            if(currDist>dist2[u]) continue;

            for(Edge edge:adj[u]){
                int v=edge.to;
                long weight=edge.weight;
                long nextDist=currDist+weight;

                if(nextDist<dist1[v]){
                    dist2[v]=dist1[v];
                    dist1[v]=nextDist;

                    pq.add(new Pair(v,dist1[v]));
                }
                else if(nextDist> dist1[v] && nextDist<dist2[v]){
                    dist2[v]=nextDist;
                    pq.add(new Pair(v,dist2[v]));
                }
            }
        }
        if(dist2[d]==Long.MAX_VALUE){
            pw.println("-1");
        }
        else{
            pw.println(dist2[d]);
        }
        pw.flush();
    }
}
