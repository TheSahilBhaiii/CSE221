import java.io.*;
import java.util.*;
public class t1 {
    
    static class Edge{
        int to;
        long weight;

        public Edge(int to, long weight){
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

        int U[]=new int[m];
        int V[]=new int[m];
        long W[]=new long[m];

        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            while (!st.hasMoreTokens()) st = new StringTokenizer(bf.readLine());

            U[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            while (!st.hasMoreTokens()) st = new StringTokenizer(bf.readLine());

            V[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            while (!st.hasMoreTokens()) st = new StringTokenizer(bf.readLine());

            W[i]=Long.parseLong(st.nextToken());
        }

        ArrayList<Edge> adj[]=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            adj[U[i]].add(new Edge(V[i],W[i]));
        }

        long dist[]=new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);

        int parent[]=new int[n+1];
        Arrays.fill(parent,-1);

        PriorityQueue<Pair> pq=new PriorityQueue<>();

        dist[s]=0;
        pq.add(new Pair(s,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            long d_u=curr.dist;

            if(d_u> dist[u]) continue;

            for(Edge edge :adj[u]){
                int v=edge.to;
                long weight=edge.weight;

                if(dist[u]+weight < dist[v]){
                    dist[v]=dist[u]+weight;
                    parent[v]=u;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }

        if(dist[d]==Long.MAX_VALUE){
            pw.println("-1");
        }
        else{
            pw.println(dist[d]);

            ArrayList<Integer> path=new ArrayList<>();
            int curr=d;

            while(curr!=-1){
                path.add(curr);
                curr=parent[curr];
            }

            for(int i=(path.size()-1);i>=0;i--){
                pw.print(path.get(i)+ " ");
            }
            pw.println();
        }
        pw.flush();
    }
}
