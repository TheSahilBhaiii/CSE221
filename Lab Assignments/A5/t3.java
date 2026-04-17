import java.io.*;
import java.util.*;
public class t3 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int source=Integer.parseInt(st.nextToken());
        int dest=Integer.parseInt(st.nextToken());

        ArrayList<Integer> adj[]=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        if(m>0){
        StringTokenizer stU=new StringTokenizer(bf.readLine());
        StringTokenizer stV=new StringTokenizer(bf.readLine());

        for(int i=0;i<m;i++){
            int u=Integer.parseInt(stU.nextToken());
            int v=Integer.parseInt(stV.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }
        }
        for(int i=1;i<=n;i++){
            Collections.sort(adj[i]);
        }

        int dist[]=new int[n+1];
        int parent[]=new int[n+1];

        Arrays.fill(dist,-1);
        Arrays.fill(parent,-1);

        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        dist[source]=0;

        while(!q.isEmpty()){
            int current=q.poll();

            if(current==dest){
                break;
            }
            for(int i=0;i<adj[current].size();i++){
                int neighbor=adj[current].get(i);

                if(dist[neighbor]==-1){
                dist[neighbor]=dist[current]+1;
                parent[neighbor]=current;
                q.add(neighbor);
                }
            }
        }
        if(dist[dest]==-1){
            pw.println("-1");
        }
        else{
            pw.println(dist[dest]);

            ArrayList<Integer> path=new ArrayList<>();

            int curr=dest;

            while(curr!=-1){
                path.add(curr);
                curr=parent[curr];
            }
            Collections.reverse(path);

            for(int i=0;i<path.size();i++){
                pw.print(path.get(i)+" ");
            }
            pw.println();
        }
        pw.flush();
    }
}
