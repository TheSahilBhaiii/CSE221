import java.io.*;
import java.util.*;
public class t2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        ArrayList<Integer> adj[]=new ArrayList[n+1];

        StringTokenizer stU=new StringTokenizer(bf.readLine());
        StringTokenizer stV=new StringTokenizer(bf.readLine());

        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<=n;i++){
            int u=Integer.parseInt(stU.nextToken());
            int v=Integer.parseInt(stV.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }
        
        for(int i=1;i<=n;i++){
            Collections.sort(adj[i]);
        }

        int color[]=new int[n+1];

        dfs(1,adj,color,pw);

        pw.println();
        pw.flush();
    }
    static void dfs(int current,ArrayList<Integer> adj[],int color[],PrintWriter pw){
        color[current]=1;

        pw.print(current+" ");

        for(int i=0;i<adj[current].size();i++){
            int neighbor=adj[current].get(i);

            if(color[neighbor]==0){
                dfs(neighbor,adj,color,pw);
            }
        }
    }
}
