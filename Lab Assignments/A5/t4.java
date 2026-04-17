import java.io.*;
import java.util.*;
public class t4{
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw=new PrintWriter(System.out);

        String firstLine=bf.readLine();

        if(firstLine==null){
            return;
        }
        StringTokenizer st=new StringTokenizer(firstLine);

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int source=Integer.parseInt(st.nextToken());
        int dest=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        ArrayList<Integer> adj[]=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());

            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            adj[u].add(v);
        }

        List<Integer> path1=getShortestpath(source,k,n,adj);
        List<Integer> path2=getShortestpath(k,dest,n,adj);

        if(path1==null || path2==null){
            pw.println("-1");
        }
        else{
            int distance=(path1.size()-1)+(path2.size()-1);
            pw.println(distance);

            for(int i=0;i<path1.size();i++){
                pw.print(path1.get(i)+" ");
            }
            for(int i=1;i<path2.size();i++){
                pw.print(path2.get(i)+" ");
            }
        pw.println();

        }
        pw.flush();
}

static List<Integer> getShortestpath(int start,int end,int n,List<Integer> adj[]){
    int dist[]=new int[n+1];
    int parent[]=new int[n+1];

    Arrays.fill(dist,-1);
    Arrays.fill(parent,-1);

    Queue<Integer> q=new LinkedList<>();
    q.add(start);
    dist[start]=0;

    while(!q.isEmpty()){
        int current=q.poll();

        if(current==end){
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
        if(dist[end]==-1){
        return null;
        }

        ArrayList<Integer> path=new ArrayList<>();

        int curr=end;

        while(curr!=-1){
            path.add(curr);
            curr=parent[curr];
        }
        Collections.reverse(path);
        return path;
    } 
}

