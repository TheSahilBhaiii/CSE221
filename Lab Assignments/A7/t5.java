import java.io.*;
import java.util.*;
public class t5 {
    
    static class Edge{
        int to;
        long weight;

        public Edge(int to,long weight){
            this.to=to;
            this.weight=weight;
        }
    }
    static class Pair implements Comparable<Pair>{
        int Node;
        long dist;
        int parity;

        public Pair(int Node,long dist,int parity){
            this.Node=Node;
            this.dist=dist;
            this.parity=parity;
        }
        public int compareTo(Pair other){
            return Long.compare(this.dist,other.dist);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int U[]=new int[m];
        int V[]=new int[m];
        long W[]=new long[m];

        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            while(!st.hasMoreTokens()){
                st=new StringTokenizer(bf.readLine());
            }
            U[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            while(!st.hasMoreTokens()){
                st=new StringTokenizer(bf.readLine());
            }
            V[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            while(!st.hasMoreTokens()){
                st=new StringTokenizer(bf.readLine());
            }
            W[i]=Long.parseLong(st.nextToken());
        }

        ArrayList<Edge> adj[]=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            adj[U[i]].add(new Edge(V[i], W[i]));
        }

        long dist[][]=new long[n+1][2];
        for(int i=1;i<=n;i++){
            dist[i][0]=Long.MAX_VALUE;
            dist[i][1]=Long.MAX_VALUE;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();

        pq.add(new Pair(1,0,-1));
        dist[1][0]=0;
        dist[1][1]=0;

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.Node;
            long d=curr.dist;
            int p=curr.parity;

            if(p!=-1 && d>dist[u][p]) continue;

            for(Edge edge:adj[u]){
                int v=edge.to;
                long weight=edge.weight;
                int nextParity=(int)(weight%2);

                if(p==nextParity) continue;

                if(d+weight <dist[v][nextParity]){
                    dist[v][nextParity]=d+weight;
                    pq.add(new Pair(v, dist[v][nextParity], nextParity));
                }
            }
        }
        long ans=Math.min(dist[n][0],dist[n][1]);

        if(ans==Long.MAX_VALUE){
            pw.println("-1");
        }
        else{
            pw.println(ans);
        }
        pw.flush();
    }
}
