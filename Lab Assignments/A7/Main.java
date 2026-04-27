import java.io.*;
import java.util.*;
public class Main{
    
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

    public Pair(int Node,long dist){
        this.Node=Node;
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
    int s=Integer.parseInt(st.nextToken());
    int t=Integer.parseInt(st.nextToken());

    adj=new ArrayList[n+1];

    for(int i=1;i<=n;i++){
        adj[i]=new ArrayList<>();
    }
    for(int i=0;i<m;i++){
        st=new StringTokenizer(bf.readLine());

    int U=Integer.parseInt(st.nextToken());
    int V=Integer.parseInt(st.nextToken());
    long W=Long.parseLong(st.nextToken());

    adj[U].add(new Edge(V, W));
    }

    long distA[]=dijkstra(s,n);
    long distB[]=dijkstra(t,n);

    long minMeetingTime=Long.MAX_VALUE;
    int bestMeetingNode=-1;

    for(int i=1;i<=n;i++){
        if(distA[i]!=Long.MAX_VALUE && distB[i]!=Long.MAX_VALUE){
            long timeToMeetHere=Math.max(distA[i], distB[i]);

            if(timeToMeetHere<minMeetingTime){
            minMeetingTime=timeToMeetHere;
            bestMeetingNode=i;
            }
        }
    }
    if(bestMeetingNode==-1){
        pw.println("-1");
    }
    else{
        pw.println(minMeetingTime+" "+bestMeetingNode);
    }
    pw.flush();
}
static long[] dijkstra(int startNode,int n){
    long dist[]=new long[n+1];
    Arrays.fill(dist,Long.MAX_VALUE);

    PriorityQueue<Pair> pq=new PriorityQueue<>();
    dist[startNode]=0;
    pq.add(new Pair(startNode, 0));

    while(!pq.isEmpty()){
        Pair curr=pq.poll();
        int u=curr.Node;
        long ds=curr.dist;

        if(ds>dist[u]) continue;

        for(Edge edge:adj[u]){
            int v=edge.to;
            long weight=edge.weight;

            if(dist[u]+weight < dist[v]){
                dist[v]=dist[u]+weight;
                pq.add(new Pair(v, dist[v]));
            }
        }
    }
    return dist;
    }
}

